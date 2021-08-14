package com.learn.exception;




public class NotFoundException extends RuntimeException {

	public NotFoundException(String string) {
		super("The Record was not found");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994671530378580180L;

}