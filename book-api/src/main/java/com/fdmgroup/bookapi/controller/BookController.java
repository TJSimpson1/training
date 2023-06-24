package com.fdmgroup.bookapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.bookapi.exception.BookTitleExistsException;
import com.fdmgroup.bookapi.exception.ResourceNotFoundException;
import com.fdmgroup.bookapi.model.Book;
import com.fdmgroup.bookapi.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		System.err.println("@@@@@@@@@@@@@@@@@@@@ BOOK API 1 @@@@@@@@@@@@@@@@@@@@");
		return ResponseEntity
				.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable int id) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(bookService.getBookById(id));
	}
	
	@PostMapping
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) { // while this week we will be accepting our entities directly, in practice you will be using DTOs and the ObjectMapper
		bookService.createBook(book);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()         // http://localhost:8088/api/v1/books
				.path("/{id}")                // http://localhost:8088/api/v1/books/{id}
				.buildAndExpand(book.getId()) // http://localhost:8088/api/v1/books/4
				.toUri();
		return ResponseEntity
				.created(location)
				.body(book);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @PathVariable int id) {
		return ResponseEntity
				.ok(bookService.updateBook(book, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id) {
		bookService.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
	
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(value=BookTitleExistsException.class)
	public ResponseEntity<String> handleBookTitleExistsException(BookTitleExistsException ex) {
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<ObjectError> errors = ex.getAllErrors();
		StringBuilder stringBuilder = new StringBuilder();
		errors.forEach(error -> stringBuilder.append(error.getDefaultMessage() + ","));
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(stringBuilder.toString());
	}
}
