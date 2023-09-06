package com.fssa.sharpandclean.validation.exception;

public class InvalidBarberException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidBarberException(String msg) {
		super(msg);
	}

	public InvalidBarberException(Throwable e) {
		super(e);
	}
	
}
