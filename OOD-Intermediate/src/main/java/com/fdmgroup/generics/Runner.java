package com.fdmgroup.generics;


public class Runner {

	public static void main(String[] args) {
		Basket<Book> basketOfBooks = new Basket<>();
		Basket<Toy> basketOfToys = new Basket<>();
		
		Book book = new Book();
		Toy toy = new Toy();
		
		basketOfBooks.addItem(book);
		basketOfToys.addItem(toy);
		
		GenericClass<Integer, Book> gc = new GenericClass<>();
		gc.setVar1(5);
		
	}

}
