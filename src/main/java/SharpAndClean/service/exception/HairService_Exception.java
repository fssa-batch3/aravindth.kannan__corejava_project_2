package SharpAndClean.service.exception;

public class HairService_Exception extends Exception{
	private static final long serialVersionUID = -8508529215117096666L;

	public HairService_Exception(String msg) {
		super(msg);
	}

	public HairService_Exception(Throwable e) {
		super(e);
	}
}
