package pt.tecnico.supplier;

import static javax.xml.bind.DatatypeConverter.printHexBinary;

import com.google.protobuf.ByteString;
import com.google.type.Money;

import io.grpc.stub.StreamObserver;
import pt.tecnico.supplier.domain.Supplier;
import pt.tecnico.supplier.grpc.*;
import pt.tecnico.supplier.grpc.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.security.*;

import static javax.xml.bind.DatatypeConverter.printHexBinary;
import java.io.InputStream;

public class SupplierServiceImpl extends SupplierGrpc.SupplierImplBase {

	/**
	 * Set flag to true to print debug messages. The flag can be set using the
	 * -Ddebug command line option.
	 */
	private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);

	/** Helper method to print debug messages. */
	private static void debug(String debugMessage) {
		if (DEBUG_FLAG)
			System.err.println(debugMessage);
	}

	/** Domain object. */
	final private Supplier supplier = Supplier.getInstance();

	/** Constructor */
	public SupplierServiceImpl() throws Exception {
		debug("Loading demo data...");
		supplier.demoData();
	}

	/** Helper method to convert domain product to message product. */
	private Product buildProductFromProduct(pt.tecnico.supplier.domain.Product p) {
		Product.Builder productBuilder = Product.newBuilder();
		productBuilder.setIdentifier(p.getId());
		productBuilder.setDescription(p.getDescription());
		productBuilder.setQuantity(p.getQuantity());

		Money.Builder moneyBuilder = Money.newBuilder();
		moneyBuilder.setCurrencyCode("EUR").setUnits(p.getPrice());
		productBuilder.setPrice(moneyBuilder.build());

		return productBuilder.build();
	}

	public static Key readKey(String resourcePath) throws IOException {
		System.out.println("Reading key from resource " + resourcePath + " ...");

		InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
		byte[] encoded = new byte[fis.available()];
		fis.read(encoded);
		fis.close();

		System.out.println("Key:");
		System.out.println(printHexBinary(encoded));
		SecretKeySpec keySpec = new SecretKeySpec(encoded, "AES");

		return keySpec;
	}

	@Override
	public void listProducts(ProductsRequest request, StreamObserver<SignedResponse> responseObserver) {
		debug("listProducts called");

		debug("Received request:");
		debug(request.toString());
		debug("in binary hexadecimals:");
		byte[] requestBinary = request.toByteArray();
		debug(String.format("%d bytes%n", requestBinary.length));
		
		// build response
		ProductsResponse.Builder responseBuilder = ProductsResponse.newBuilder();
		responseBuilder.setSupplierIdentifier(supplier.getId());
		for (String pid : supplier.getProductsIDs()) {
			pt.tecnico.supplier.domain.Product p = supplier.getProduct(pid);
			Product product = buildProductFromProduct(p);
			responseBuilder.addProduct(product);
		}
		ProductsResponse response = responseBuilder.build();

		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(response.toByteArray());
			byte[] digest = md.digest();
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = new byte[16];
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.nextBytes(iv);
			IvParameterSpec ips = new IvParameterSpec(iv);
			cipher.init(Cipher.ENCRYPT_MODE, readKey("secret.key"), ips);
			byte[] cipherDigest = cipher.doFinal(digest);

			debug("Response to send:");
			debug(response.toString());
			debug("in binary hexadecimals:");
			byte[] responseBinary = response.toByteArray();
			debug(printHexBinary(responseBinary));
			debug(String.format("%d bytes%n", responseBinary.length));

			Signature signature = Signature.newBuilder()
					.setSignerId("Totally Trustworthy Server")
					.setValue(ByteString.copyFrom(cipherDigest))
					.setIv(ByteString.copyFrom(iv))
					.setTime(System.currentTimeMillis()).build();

			SignedResponse signed = SignedResponse.newBuilder().setResponse(response).setSignature(signature).build();
			responseObserver.onNext(signed);
		} catch(NoSuchAlgorithmException | NoSuchPaddingException | IOException e){
			/*gib compile*/
		} catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		// complete call
		responseObserver.onCompleted();
	}

}

