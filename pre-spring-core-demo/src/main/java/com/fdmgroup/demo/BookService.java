package com.fdmgroup.demo;

import java.util.List;
import java.util.Optional;

public class BookService {

	private BookDAO bookDAO;

	public BookService(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}
	
	public Book addBook(Book book) {
		if (book.getPrice() >= 0 && ! bookDAO.existsById(book.getIsbn())) {
			return bookDAO.save(book);
		}
		return null;
	}
	
	public Book getBook(int id) {
		Optional<Book> optionalbook = bookDAO.findById(id);
		
		if (optionalbook.isPresent()) {
			return optionalbook.get();
		}
		return null;
	}
	
	public Book updateBook(Book book) {
		if (book.getPrice() >= 0  && bookDAO.existsById(book.getIsbn())) {
			bookDAO.save(book);
			return book;
		}
		return null;
	}
	
	public void deleteBook(int id) {
		bookDAO.deleteById(id);
	}
	
	public List<Book> listbooks(){
		return bookDAO.findAll();
	}
}
