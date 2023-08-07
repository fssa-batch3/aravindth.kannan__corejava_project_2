package SharpAndClean.dao.exception;

public class HairServiceDAOException extends Exception {
	private static final long serialVersionUID = -7798283981195321951L;

	public HairServiceDAOException(String msg) {
		super(msg);
	}

	public HairServiceDAOException(Throwable e) {
		super(e);
	}
}
