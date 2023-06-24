package com.fdmgroup.comparisonsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

	public static void main(String[] args) {
		Book book1 = new Book("Learn Java", 45678, 19.99, 500, 4.3);
		Book book2 = new Book("Learn UNIX", 65432, 17.5, 650, 3.9);
		Book book3 = new Book("Learn SQL", 87956, 9.75, 220, 4.4);
		Book book4 = new Book("Learn Agile", 35367, 25.5, 500, 4.4);
		Book book5 = new Book("Learn React", 55676, 28.75, 490, 4.8);
		Book book6 = new Book("Learn Javascript", 34343, 14.99, 300, 4.4);
		Book book7 = new Book("Learn Python", 65767, 27.25, 500, 4.1);

//		List<Book> books = new ArrayList<Book>(Arrays.asList(book1, book2, book3, book4, book5, book6, book7));

//		Collections.sort(books, new BookPagesComparatorAscendingOrder());
//		Collections.sort(books, new BookNameComparatorAscendingOrder());
//		Collections.sort(books, new BookPriceComparatorDescendingOrder());
//		Collections.sort(books, new BookPagesThenIsbnComparator());
//		Collections.sort(books, new BookRatingThenPriceComparator());

//		for(Book eachBook : books) {
//		System.out.println(eachBook.getTitle() + " || ISBN: " + eachBook.getIsbn() + " || Price: " + eachBook.getPrice()
//				+ " || Pages: " + eachBook.getNumberOfPages() + " || Rating: " + eachBook.getRating());
//		}

		Set<Book> booksByRatingThenPrice = new TreeSet<>(new BookRatingThenPriceComparator());
		booksByRatingThenPrice.add(book1);
		booksByRatingThenPrice.add(book2);
		booksByRatingThenPrice.add(book3);
		booksByRatingThenPrice.add(book4);
		booksByRatingThenPrice.add(book5);
		booksByRatingThenPrice.add(book6);
		booksByRatingThenPrice.add(book7);

		for (Book eachBook : booksByRatingThenPrice) {
			System.out.println(
					eachBook.getTitle() + " || ISBN: " + eachBook.getIsbn() + " || Price: " + eachBook.getPrice()
							+ " || Pages: " + eachBook.getNumberOfPages() + " || Rating: " + eachBook.getRating());
		}

		PriorityQueue<Double> doubles = prioritise(5.3, 1.2, 8.9, 3.4);

		while (doubles.size() > 0) {
			System.out.println(doubles.poll());
		}

	}

	public static PriorityQueue<Double> prioritise(double... doubles) {
		PriorityQueue<Double> sorted = new PriorityQueue<Double>(1, Collections.reverseOrder());

		for (Double d : doubles) {
			sorted.add(d);
		}

		return sorted;

	}

}
