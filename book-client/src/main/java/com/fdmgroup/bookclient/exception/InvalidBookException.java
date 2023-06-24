package com.fdmgroup.bookclient.exception;

import java.util.Arrays;
import java.util.List;

public class InvalidBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final List<String> errorMessages;
	
	public InvalidBookException(String csvErrors) {
		super("Invalid book.");
		this.errorMessages = Arrays.asList(csvErrors.split(","));
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

}
