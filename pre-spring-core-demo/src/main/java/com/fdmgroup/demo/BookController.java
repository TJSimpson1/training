package com.fdmgroup.demo;

public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	public void addNewbook(int isbn, String title, String author, String genre, double price) {
		Book book = new Book(isbn,title,author,genre,price);
		Book addedbook = bookService.addBook(book);
		
		if (addedbook == null) {
			System.out.println("Failed to create book: "+title);
		} else {
			System.out.println("book created:"+book.getTitle());
		}
	}
	
}
