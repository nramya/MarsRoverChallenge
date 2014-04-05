package exceptions;

public class InvalidInputException extends Exception {

	// User-defined exception to indicate an invalid input in the given file
	private static final long serialVersionUID = -8686026341470955965L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		super(message);
	}
}
