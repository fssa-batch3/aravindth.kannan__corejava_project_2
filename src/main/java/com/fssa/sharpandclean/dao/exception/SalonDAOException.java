package com.fssa.sharpandclean.dao.exception;

public class SalonDAOException extends Exception {
	private static final long serialVersionUID = 1L;

	public SalonDAOException(String msg) {
		super(msg);
	}

	public SalonDAOException(Throwable e) {
		super(e);
	}
}
