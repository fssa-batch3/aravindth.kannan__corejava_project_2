package SharpAndClean.validation.exception;

public class InvalidHairServiceException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidHairServiceException(String msg) {
		super(msg);
	}

	public InvalidHairServiceException(Throwable e) {
		super(e);
	}

}
