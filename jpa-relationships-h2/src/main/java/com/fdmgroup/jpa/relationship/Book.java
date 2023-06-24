package com.fdmgroup.jpa.relationship;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :givenTitle")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookgen")
	@SequenceGenerator(name = "bookgen", sequenceName = "bookseq", allocationSize = 1)
	private int id;
	private String title;
	
	@ManyToMany(mappedBy = "books")
	List<Author> authors = new ArrayList<Author>();
	
	public Book() {}
	
	public Book(String title) {
		super();
		this.title = title;
	}
	
	public void addAuthor(Author author) {
		authors.add(author);
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

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}
	
	
}
