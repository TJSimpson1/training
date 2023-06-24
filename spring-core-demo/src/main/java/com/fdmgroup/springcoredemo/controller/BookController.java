package com.fdmgroup.springcoredemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fdmgroup.springcoredemo.model.Book;
import com.fdmgroup.springcoredemo.service.BookService;

// @Component is a generalised version of @Controller/@Service... which will also be initialised automatically

@Controller
public class BookController {

	private BookService bookService;
	
	@Autowired
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
