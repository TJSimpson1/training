package com.fdmgroup.employeeUITravisSimpson.exception;

public class GenericEmployeeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public final String STATUS;
	
	public GenericEmployeeException(String message, String sTATUS) {
		super(message);
		STATUS = sTATUS;
	}	
	
}
