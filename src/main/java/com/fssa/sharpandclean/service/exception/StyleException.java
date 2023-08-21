package com.fssa.sharpandclean.service.exception;

public class StyleException extends Exception{
	private static final long serialVersionUID = -8508529215117096666L;

	public StyleException(Object e) {
		super((String) e);
	}

	public StyleException(Throwable e) {
		super(e);
	}


}
