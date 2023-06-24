package com.fdmgroup.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.bookapi.exception.BookTitleExistsException;
import com.fdmgroup.bookapi.exception.ResourceNotFoundException;
import com.fdmgroup.bookapi.model.Book;
import com.fdmgroup.bookapi.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepo;
	
	// Remember constructor bean injection has an implicit @Autowired
	public BookService(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public Book getBookById(int id) {
		Optional<Book> bookOpt = bookRepo.findById(id);
		if(bookOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		return bookOpt.get();
	}

	public Book createBook(Book book) {
		Optional<Book> bookOpt = bookRepo.findByTitle(book.getTitle());
		if(bookOpt.isPresent()) {
			throw new BookTitleExistsException("Book with title of " + book.getTitle() + " already exists.");
		}
		return bookRepo.save(book);		
	}

	public Book updateBook(Book book, int id) {
		Optional<Book> bookOpt = bookRepo.findById(id);
		if(bookOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		book.setId(id);
		return bookRepo.save(book);
	}

	public void deleteById(int id) {
		Optional<Book> bookOpt = bookRepo.findById(id);
		if(bookOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		bookRepo.deleteById(id);		
	}
	
	private String getMessage(int id) {
		return "Book with id of " + id + " not found.";
	}

}
