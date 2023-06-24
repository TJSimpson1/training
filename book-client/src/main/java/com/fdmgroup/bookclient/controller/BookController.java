package com.fdmgroup.bookclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.bookclient.exception.GenericBookException;
import com.fdmgroup.bookclient.exception.InvalidBookException;
import com.fdmgroup.bookclient.model.Book;
import com.fdmgroup.bookclient.service.WebClientBookService;

@Controller
public class BookController {

	private final WebClientBookService bookService;

	public BookController(WebClientBookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@RequestMapping("allBooks") // localhost:8087/allBooks
	public String allBooks(Model model) {
		model.addAttribute("listOfBooks", bookService.getAllBooks());
		return "all-books";
	}
	
	@GetMapping("editBook")
	public String editBook(@RequestParam int id, Model model) {
		Book book = bookService.getBookById(id);
		// maybe add a session attribute here to track the ID of the book being edited rather than relying on the model attr
		model.addAttribute("book", book);
		return "edit-book";
	}
	
	@PostMapping("editBookSubmit")
	public String editBookSubmit(@ModelAttribute Book book) {
		bookService.updateBook(book, book.getId());
		return "forward:/allBooks";
	}
	
	@GetMapping("addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}
	
	@PostMapping("addBookSubmit")
	public String addBookSubmit(@ModelAttribute Book book) {
		bookService.addBook(book);
		return "forward:/allBooks";
	}
	
	@GetMapping("deleteBook")
	public String deleteBook(@RequestParam int id) {
		bookService.deleteBook(id);
		return "forward:/allBooks";
	}
	
	@ExceptionHandler(GenericBookException.class)
	public String handleGenericBookException(GenericBookException ex, Model model) {
		model.addAttribute("errorCode", ex.STATUS);
		model.addAttribute("errorMessage", ex.getMessage());
		return "error-page";
	}
	
	@ExceptionHandler(InvalidBookException.class)
	public String handleInvalidBookException(InvalidBookException ex, Model model) {
		model.addAttribute("validationErrors", ex.getErrorMessages());
		return addBook(model);
	}
}
