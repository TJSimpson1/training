package com.fdmgroup.springcoredemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fdmgroup.springcoredemo.model.Book;

@Repository
public class BookDAO {

	// This is a fake DAO class - all book objects are stored in this
	// map and not in a database
	private Map<Integer,Book> books = new HashMap<>();
	
	public Book save(Book book) {
		books.put(book.getIsbn(), book);
		return books.get(book.getIsbn());
	}
	
	public Optional<Book> findById(int id) {
		if (books.containsKey(id)) {
			return Optional.ofNullable(books.get(id));
		}
		return Optional.empty();
	}
	
	public void deleteById(int id) {
		books.remove(id);
	}
	
	public List<Book> findAll(){
		return new ArrayList<>(books.values());
	}

	public boolean existsById(int id) {
		return books.containsKey(id);
	}
	
	
	
}
