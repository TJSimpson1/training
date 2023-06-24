package com.fdmgroup.demo;

public class Runner {

	public static void main(String[] args) {
		BookDAO bookDAO = new BookDAO();
		BookService bookService = new BookService(bookDAO);
		BookController bookController = new BookController(bookService);
		
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",-19.99);
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",19.99);
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",19.99);

	}

}
