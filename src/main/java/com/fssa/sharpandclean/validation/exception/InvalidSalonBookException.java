package com.fssa.sharpandclean.validation.exception;

public class InvalidSalonBookException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidSalonBookException(String msg) {
		super(msg);
	}

	public InvalidSalonBookException(Throwable e) {
		super(e);
	}
}
