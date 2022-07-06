package pt.tecnico.supplier.domain;

/** Exception used to signal a problem with the product quantity. */
public class InputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InputException() {
	}

	public InputException(String message) {
		super(message);
	}

}
