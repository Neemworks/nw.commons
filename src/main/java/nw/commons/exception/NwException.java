package nw.commons.exception;

public class NwException extends IllegalArgumentException {

	/**
	 *
	 */
	private static final long serialVersionUID = 2386236783327625339L;

	public NwException() {
		super();
	}

	public NwException(String message, Throwable cause) {
		super(message, cause);
	}

	public NwException(String message) {
		super(message);
	}

	public NwException(Throwable cause) {
		super(cause);
	}



}
