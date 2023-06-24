package com.fdmgroup.TDDBookStore;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Book> books = new ArrayList<Book>();

	public List<Book> getBooksInBasket() {
		return books;
	}

	public List<Book> addBook(Book book) {
		//books = new ArrayList<Book>(Arrays.asList(book)); //Passes add one book but fails for >1 books
		books.add(book);
		return books;
	}

}
