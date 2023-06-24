package com.fdmgroup.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book implements Comparable<Book>{
	
	private String title;
	private String author;
	private String isbn;
	
	public Book(@JsonProperty("title") String title, @JsonProperty("author")String author, @JsonProperty("isbn-10")String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int compareTo(Book book) {
		return this.getTitle().compareTo(book.getTitle());
	}
}
