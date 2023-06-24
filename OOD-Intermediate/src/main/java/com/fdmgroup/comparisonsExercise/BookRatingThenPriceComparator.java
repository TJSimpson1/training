package com.fdmgroup.comparisonsExercise;

import java.util.Comparator;

public class BookRatingThenPriceComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		if(book1.getRating() == book2.getRating()) {
			return book1.getPrice().compareTo(book2.getPrice());
		}
		return ((Double) book2.getRating()).compareTo(book1.getRating());
	}

}
