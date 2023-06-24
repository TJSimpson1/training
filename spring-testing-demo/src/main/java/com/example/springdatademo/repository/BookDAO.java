package com.example.springdatademo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springdatademo.model.Book;

public interface BookDAO extends JpaRepository<Book, Integer> {
	
	//Derived queries
	Optional<Book> findByTitle(String title); //ONLY USE optional if output is definitely unique
	
	List<Book> findByAuthorIgnoreCase(String author);
	
	List<Book> findByGenreIgnoreCase(String genre);
	
	//Custom queries
	@Query("SELECT b FROM Book b WHERE b.price < :price")
	List<Book> findByPriceLessThan(@Param("price") double price);

}
