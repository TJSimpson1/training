package com.fdmgroup.bookapi.exception;

public class BookTitleExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookTitleExistsException(String message) {
		super(message);
	}
	
}
