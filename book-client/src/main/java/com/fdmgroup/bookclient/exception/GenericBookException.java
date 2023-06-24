package com.fdmgroup.bookclient.exception;

public class GenericBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public final String STATUS;
	
	public GenericBookException(String message, String sTATUS) {
		super(message);
		STATUS = sTATUS;
	}	

}
