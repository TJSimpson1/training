package com.fdmgroup.TDDBookStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checkout {
	private double totalPrice;

	public double calculatePrice(Basket basket) {
		for(Book book : basket.getBooksInBasket()) {
			totalPrice += book.getPrice();
		}
		int discountSize = basket.getBooksInBasket().size() / 3;
		
		if(basket.getBooksInBasket().size() >= 10) {
			discountSize += 10;
		}
		
		//List<Book> distinctBookList = basket.getBooksInBasket().stream().distinct().collect(Collectors.toList());
		List<Book> distinctBookList = new ArrayList<Book>();
		for(Book eachBook : basket.getBooksInBasket()) {
			if(!distinctBookList.contains(eachBook)) {
				distinctBookList.add(eachBook);
			}
		}
		
		if(basket.getBooksInBasket().size() > 1 && distinctBookList.size() == basket.getBooksInBasket().size()) {
			discountSize += 5;
		}
		
		for(Book eachBook : distinctBookList) {
			if(Collections.frequency(basket.getBooksInBasket(), eachBook) > 1) {
				totalPrice -= eachBook.getPrice();
			}
			
		}
		
		
		return totalPrice * (1 - discountSize / 100.0);
		
	}

}
