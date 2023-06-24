package com.fdmgroup.comparisonsExercise;

import java.util.Comparator;

public class BookPagesComparatorAscendingOrder implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		return ((Integer) book1.getNumberOfPages()).compareTo(book2.getNumberOfPages());
	}

}
