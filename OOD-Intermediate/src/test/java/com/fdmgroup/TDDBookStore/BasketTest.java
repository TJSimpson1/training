package com.fdmgroup.TDDBookStore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasketTest {
	
	Book book;
	Basket basket;
	List<Book> booksList;

	@BeforeEach
	void setUp() throws Exception {
		basket = new Basket(); //Arrange
		book = new Book(0.0, 1234567);
		booksList = basket.getBooksInBasket();
	}

	@Test
	public void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded(){
		assertEquals(0, booksList.size()); //Assert
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() {
		booksList = basket.addBook(book); //Act
		assertEquals(1, booksList.size()); //Assert
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBooks() {
		booksList = basket.addBook(book); 
		booksList = basket.addBook(book);
		assertEquals(2, basket.getBooksInBasket().size()); //Assert
	}
	
	



}
