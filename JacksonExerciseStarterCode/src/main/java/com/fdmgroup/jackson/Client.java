package com.fdmgroup.jackson;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

	public static void main(String[] args) {
		File file = new File("src/main/resources/books.json");
		Book[] booksRead = readFromJSONFile(file);
		printAllBooks(booksRead);
		writeToJSONFileInAlphabeticalOrder(booksRead);
		writeToJSONFileInISBNOrder(booksRead);
	}

	public static Book[] readFromJSONFile(File file) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Book[] books = mapper.readValue(file, Book[].class);
			return books;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void writeToJSONFileInAlphabeticalOrder(Book[] books) {
		ObjectMapper mapper = new ObjectMapper();
		File resultFile = new File("src/main/resources/sorted-books.json");
		Comparator<Book> sortByName = (book1, book2) -> book1.getTitle().compareTo(book2.getTitle());
		
		Arrays.sort(books, sortByName);

		try {
			mapper.writeValue(resultFile, books);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void writeToJSONFileInISBNOrder(Book[] books) {
		ObjectMapper mapper = new ObjectMapper();
		File resultFile = new File("src/main/resources/sorted-isbn.json");
		
		Comparator<Book> sortByISBN = (book1, book2) -> book1.getIsbn().compareTo(book2.getIsbn());
				
		Arrays.sort(books, sortByISBN);

		try {
			mapper.writeValue(resultFile, books);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printAllBooks(Book[] books) {
		for (Book book : books) {
			System.out.println(book.getTitle());
		}
	}

}
