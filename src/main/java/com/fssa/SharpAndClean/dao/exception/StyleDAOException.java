package com.fssa.SharpAndClean.dao.exception;

public class StyleDAOException extends Exception {
	private static final long serialVersionUID = -7798283981195321951L;

	public StyleDAOException(String msg) {
		super(msg);
	}

	public StyleDAOException(Throwable e) {
		super(e);
	}
}
