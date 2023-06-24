package com.fdmgroup.userclient.exception;

import java.util.Arrays;
import java.util.List;

public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final List<String> errorMessages;
	public InvalidUserException(String csvErrors) {
		super("Invalid user.");
		this.errorMessages = Arrays.asList(csvErrors.split(","));
	}
	public List<String> getErrorMessages() {
		return errorMessages;
	}
	
}
