package com.fdmgroup.jpa.relationship;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Author.findByLastName", query = "SELECT a FROM Author a WHERE a.lastName = :givenLastName")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorgen")
	@SequenceGenerator(name = "authorgen", sequenceName = "authorseq", allocationSize = 1)
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name="BOOKS_AND_AUTHORS",
			joinColumns = @JoinColumn(name = "FK_AUTHOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "FK_BOOK_ID"))
	private List<Book> books = new ArrayList<Book>();
	
	public Author() {}
	
	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
		book.addAuthor(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + "]";
	}
	
	
}
