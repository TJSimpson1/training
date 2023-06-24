package com.fdmgroup.bookStore;


import java.util.List;

public class Catalogue {
	private List<Book> books;
	private ReadItemCommand readItemCommand;
	private WriteItemCommand writeItemCommand;
	
	public Catalogue(ReadItemCommand readItemCommand, WriteItemCommand writeItemCommand) {
		super();
		this.readItemCommand = readItemCommand;
		this.writeItemCommand = writeItemCommand;
	}

	public List<Book> getAllBooks() {
		books = readItemCommand.readAll();
		return books;
	}

	public void addBook(Book book) {
		writeItemCommand.insertItem(book);
		
	}

	public void addBooks(List<Book> books) {
		for(Book eachBook : books) {
			writeItemCommand.insertItem(eachBook);
		}
		
	}

	public Book getBook(String ISBN) {
		Book book = readItemCommand.getItem(ISBN);
		return book;
	}

	public void deleteBook(Book book) {
		writeItemCommand.deleteItem(book);
		
	}

	public void deleteAllBooks() {
		List<Book> bookList = readItemCommand.readAll();
		for(Book eachBook : bookList) {
			writeItemCommand.deleteItem(eachBook);
		}

		
	}

}
