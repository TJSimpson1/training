package com.fdmgroup.genericsExercise;


public class Runner {

	public static void main(String[] args) {
		Book<Integer> book1 = new Book<Integer>(1, "book 1");
		Book<Integer> book2 = new Book<Integer>(2, "book 2");
		Borrower<Integer> borrower1 = new Borrower<Integer>(1, "borrower 1");
		Borrower<Integer> borrower2 = new Borrower<Integer>(2, "borrower 2");
		
		Catalog<Book<Integer>,Integer> books = new Catalog<Book<Integer>,Integer>();
		Catalog<Borrower<Integer>,Integer> borrowers = new Catalog<Borrower<Integer>,Integer>();
		
		books.addItem(book1);
		books.addItem(book2);
		borrowers.addItem(borrower1);
		borrowers.addItem(borrower2);
		
		Book<Integer> book = books.findItem(2);
		System.out.println(book.getName());
		
		Borrower<Integer> borrower = borrowers.findItem(1);
		System.out.println(borrower.getName());
		
		
	}

}
