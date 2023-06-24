package com.fdmgroup.comparisonsExercise;

import java.util.Comparator;

public class BookPagesThenIsbnComparator implements Comparator<Book>{

	@Override
	public int compare(Book book1, Book book2) {
		if(book1.getNumberOfPages() == book2.getNumberOfPages()) {
			return ((Integer) book2.getIsbn()).compareTo(book1.getIsbn());
		}
		return ((Integer) book1.getNumberOfPages()).compareTo(book2.getNumberOfPages());
	}

}
