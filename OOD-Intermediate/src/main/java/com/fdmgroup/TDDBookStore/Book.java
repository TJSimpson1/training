package com.fdmgroup.TDDBookStore;

import java.util.Objects;

public class Book {
	private double price;
	private final int ISBN_NUMBER;

	public Book(double price, int isbn_NUMBER) {
		super();
		this.ISBN_NUMBER = isbn_NUMBER;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getISBN_NUMBER() {
		return ISBN_NUMBER;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN_NUMBER);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return ISBN_NUMBER == other.ISBN_NUMBER;
	}
	
	
	
	
	
	


	

}
