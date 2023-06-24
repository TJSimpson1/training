package com.example.springdatademo.service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdatademo.model.Book;
import com.example.springdatademo.repository.BookDAO;



@Service
public class BookService {

	private BookDAO bookDAO;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		super();
		this.bookDAO = bookDAO;
	}
	
	public Book addBook(Book book) {
		if (book.getPrice() >= 0 && ! bookDAO.existsById(book.getIsbn())) {
			System.out.println("Saving: " + book.getTitle());
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
	
	public List<Book> listByAuthor(String author){
		return bookDAO.findByAuthorIgnoreCase(author);
	}
	
	public List<Book> listByGenre(String genre){
		return bookDAO.findByGenreIgnoreCase(genre);
	}
	
	public List<Book> listByPriceLessThan(double price){
		return bookDAO.findByPriceLessThan(price);
	}
}
