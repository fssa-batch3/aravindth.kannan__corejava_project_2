package com.fssa.sharpandclean.validation.exception;

public class InvalidSalonException  extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidSalonException(String msg) {
		super(msg);
	}

	public InvalidSalonException(Throwable e) {
		super(e);
	}
}
