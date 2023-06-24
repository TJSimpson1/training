package com.fdmgroup.mockito;

import java.util.List;

public class Checkout {

	public double calculatePrice(Basket basket) {
		List<Book> books = basket.getBooksInBasket();
		//basket.getBooksInBasket(); //Makes verify test fail as verify expects method to be called only once
		double total = 0;
		
		for(Book book : books) {
			total += book.getPrice();
		}
		
		return total;
	}

	public void emptyBasket(Basket basket) {
		for(Book book : basket.getBooksInBasket()) {
			basket.removeBook(book);
		}
		
	}

}
