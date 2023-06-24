package com.fdmgroup.bookapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Book title must not be null or blank.")
	@Size(min = 2, max = 50, message = "Book title must be between 2 and 50 characters.")
	private String title;
	@NotBlank(message = "Book author must not be null or blank.")
	@Size(min = 2, max = 25, message = "Book author must be between 2 and 25 characters.")
	private String author;
	@Size(min = 0, max = 15, message = "Book isbn must be either 13 or 15 characters.")
	private String isbn;
	@DecimalMax(value = "200000", message = "Book price must not be over 200,000.")
	@DecimalMin(value = "0.50", message = "Book price must not be under 0.50.")
	private double price;
	
	public Book() {
		super();
	}
	public Book(String title, String author, String isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
