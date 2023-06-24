package com.example.springdatademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdatademo.model.Book;
import com.example.springdatademo.service.BookService;


@Controller
public class BookController {
	
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@GetMapping("/add-book")
	public String displayAddBook(Model model, @ModelAttribute Book book) {
		model.addAttribute("book", new Book());
		
		if (book != null) {
			model.addAttribute("book", book);
		}
			
		return "addBook";
	}
	
	@GetMapping("/show-books")
	public String displayShowBooks(Model model) {
		model.addAttribute("books", bookService.listbooks());
		return "showBooks";
	}
	
	@PostMapping("submit-new-book")
	public String handleSubmitNewBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
		System.out.println("Title: " + book.getTitle() + " Author: " + book.getAuthor());
		if (bookService.addBook(book) == null) {
			redirectAttributes.addFlashAttribute("book", book);
			redirectAttributes.addFlashAttribute("errorMessage", "Unable to add book, check ID doesn't exist and price not negative");
			return "redirect:/add-book";
		}
		
		return "redirect:/show-books";
	}
	
	@GetMapping("delete-book")
	public String handleDeleteBook(@RequestParam("isbn") int isbn) {
		bookService.deleteBook(isbn);
		return "redirect:/show-books";
	}
	
	@GetMapping("edit-book")
	public String displayEditBook(Model model, @RequestParam("isbn") int isbn, @ModelAttribute Book book) {
//		System.out.println("In display edit isbn is " + isbn);
		model.addAttribute("book", bookService.getBook(isbn));
			
		return "editBook";
	}
	
	@PostMapping("submit-edit-book")
	public String handleSubmitEditBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
		System.out.println("Title: " + book.getTitle() + " Author: " + book.getAuthor());
		
		bookService.updateBook(book);
//		if (bookService.updateBook(book) == null) {
//			redirectAttributes.addFlashAttribute("book", book);
//			redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit book, check price not negative");
//			return "redirect:/edit-book";
//		}
		
		return "redirect:/show-books";
	}
	
	@PostMapping("search-by-author")
	public String handleSearchByAuthor(Model model, @RequestParam("author") String author) {
		model.addAttribute("books", bookService.listByAuthor(author));
		return "showBooks";
	}
	
	@PostMapping("search-by-genre")
	public String handleSearchByGenre(Model model, @RequestParam("genre") String genre) {
		model.addAttribute("books", bookService.listByGenre(genre));
		return "showBooks";
	}
	
	@PostMapping("search-by-price-less-than")
	public String handleSearchByPriceLessThan(Model model, @RequestParam("price") double price) {
		model.addAttribute("books", bookService.listByPriceLessThan(price));
		return "showBooks";
	}
	
}
