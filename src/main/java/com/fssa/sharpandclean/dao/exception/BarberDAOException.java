package com.fssa.sharpandclean.dao.exception;

public class BarberDAOException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public BarberDAOException(String msg) {
		super(msg);
	}

	public BarberDAOException(Throwable e) {
		super(e);
	}
}
