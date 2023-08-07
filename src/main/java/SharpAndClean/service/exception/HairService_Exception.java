package SharpAndClean.service.exception;

public class HairService_Exception extends Exception{
	private static final long serialVersionUID = -8508529215117096666L;

	public HairService_Exception(Object e) {
		super((String) e);
	}

	public HairService_Exception(Throwable e) {
		super(e);
	}


}
