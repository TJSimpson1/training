package com.fdmgroup.userclient.exception;

public class GenericUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public final String STATUS;
	
	public GenericUserException(String message, String sTATUS) {
		super(message);
		STATUS = sTATUS;
	}
	
	

}
