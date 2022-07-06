package pt.tecnico.supplier.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/** Domain Root. */
public class Supplier {

	// Members ---------------------------------------------------------------

	/** Supplier identifier */
	private String id = this.getClass().getSimpleName();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Map of existing products. Uses concurrent hash table implementation
	 * supporting full concurrency of retrievals and high expected concurrency for
	 * updates.
	 */
	private Map<String, Product> products = new ConcurrentHashMap<>();

	// For more information regarding concurrent collections, see:
	// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/package-summary.html#package.description

	// Singleton -------------------------------------------------------------

	/* Private constructor prevents instantiation from other classes */
	private Supplier() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of Singleton.getInstance()
	 * or the first access to SingletonHolder.INSTANCE, not before.
	 */
	private static class SingletonHolder {
		private static final Supplier INSTANCE = new Supplier();
	}

	public static synchronized Supplier getInstance() {
		return SingletonHolder.INSTANCE;
	}

	// product ---------------------------------------------------------------

	public void reset() {
		products.clear();
	}

	public Boolean productExists(String productId) {
		return products.containsKey(productId);
	}

	public Product getProduct(String productId) throws InputException {
		validateTextInput("Product identifier", productId);
		return products.get(productId);
	}

	private void validateTextInput(final String inputName, String inputValue) throws InputException {
		if (inputValue == null)
			throw new InputException(inputName + " cannot be null!");
		inputValue = inputValue.trim();
		if (inputValue.length() == 0)
			throw new InputException(inputName + " cannot be empty or whitespace!");
	}

	public void addProduct(String productId, String description, int quantity, int price) throws InputException {
		validateTextInput("Product identifier", productId);
		validateTextInput("Description", description);
		if (acceptProduct(productId, description, quantity, price)) {
			products.put(productId, new Product(productId, description, quantity, price));
		}
	}

	private Boolean acceptProduct(String productId, String description, int quantity, int price) {
		return productId != null && !"".equals(productId) && description != null && !"".equals(description)
				&& quantity > 0 && price > 0;
	}

	public Set<String> getProductsIDs() {
		return products.keySet();
	}

	public List<Product> search(String descText) throws InputException {
		validateTextInput("Search text", descText);

		List<Product> resultList = new ArrayList<Product>();
		for (Product p : products.values()) {
			if (p.getDescription().contains(descText)) {
				resultList.add(p);
			}
		}
		return resultList;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", products=" + products + "]";
	}

	/** for demonstration purposes only */
	public void demoData() throws InputException {
		products.clear();
		this.id = "Sports Store";
		addProduct("A1", "Soccer ball", 22, 10);
		addProduct("B2", "Basketball", 100, 12);
		addProduct("C3", "Volley ball", 7, 8);
	}

}