package pt.tecnico.supplier.client;

import static javax.xml.bind.DatatypeConverter.printHexBinary;


import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pt.tecnico.supplier.grpc.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

public class SupplierClient {

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

	public static void main(String[] args) throws Exception {
		System.out.println(SupplierClient.class.getSimpleName() + " starting ...");

		// Receive and print arguments.
		System.out.printf("Received %d arguments%n", args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.printf("arg[%d] = %s%n", i, args[i]);
		}

		// Check arguments.
		if (args.length < 2) {
			System.err.println("Argument(s) missing!");
			System.err.printf("Usage: java %s host port%n", SupplierClient.class.getName());
			return;
		}

		final String host = args[0];
		final int port = Integer.parseInt(args[1]);
		final String target = host + ":" + port;

		// Channel is the abstraction to connect to a service end-point.
		final ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

		// Create a blocking stub for making synchronous remote calls.
		SupplierGrpc.SupplierBlockingStub stub = SupplierGrpc.newBlockingStub(channel);

		// Prepare request.
		ProductsRequest request = ProductsRequest.newBuilder().build();
		System.out.println("Request to send:");
		System.out.println(request.toString());
		debug("in binary hexadecimals:");
		byte[] requestBinary = request.toByteArray();
		debug(printHexBinary(requestBinary));
		debug(String.format("%d bytes%n", requestBinary.length));

		// Make the call using the stub.
		System.out.println("Remote call...");
		SignedResponse response = stub.listProducts(request);


		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(response.getResponse().toByteArray());
		byte[] digest = md.digest();

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] iv = response.getSignature().getIv().toByteArray();
		IvParameterSpec ips = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, readKey("secret.key"), ips);
		byte[] decipherDigest = cipher.doFinal(response.getSignature().getValue().toByteArray());

		long millis = System.currentTimeMillis();

		if (Arrays.equals(digest, decipherDigest)
				&& millis - 100 <= response.getSignature().getTime()
				&& response.getSignature().getTime() <= millis + 100){
			System.out.println("Signature is valid! Message accepted! :)");
			// Print response.
			System.out.println("Received response:");
			System.out.println(response.getResponse().toString());
			debug("in binary hexadecimals:");
			byte[] responseBinary = response.getResponse().toByteArray();
			debug(printHexBinary(responseBinary));
			debug(String.format("%d bytes%n", responseBinary.length));
		}
		else
			System.out.println("Signature is invalid! Message rejected! :(");



		// A Channel should be shutdown before stopping the process.
		channel.shutdownNow();
	}

	public static Key readKey(String resourcePath) throws Exception {
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
}
