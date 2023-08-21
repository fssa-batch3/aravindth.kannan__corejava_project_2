package com.fssa.sharpandclean.validation.exception;

public class InvalidStyleException extends Exception{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStyleException(String msg) {
		super(msg);
	}

	public InvalidStyleException(Throwable e) {
		super(e);
	}

}
