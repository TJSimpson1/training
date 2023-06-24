package com.fdmgroup.mockito;

import java.util.List;

public interface Basket {
	public List<Book> getBooksInBasket();
	public void addBook(Book book);
	public void removeBook(Book book);
	
}
