package com.fdmgroup.TDDBookStore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutTest {
	
	Basket basket;
	Checkout checkout;
	Book book;

	@BeforeEach
	void setUp() throws Exception {
		basket = new Basket(); //Arrange
		checkout = new Checkout();
		book = new Book(25.99, 1234567);
	}

	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket() {
		double price = checkout.calculatePrice(basket); //Act
		assertEquals(0.0, price, 0.01); //Assert
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() {
		basket.addBook(book);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(25.99, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithTwoBooks() {
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(25.99, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithThreeBooks() {
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(51.46, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithSevenBooks() {
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(152.82, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBooksInBasket_WhenPassedBasketWithTenBooks() {
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(203.50, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfTwoBooksInBasket_WhenAllBooksUnique() {
		Book book1 = new Book(19.99, 8579128);
		basket.addBook(book);
		basket.addBook(book1);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(43.68, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfThreeBooksInBasket_WhenTwoBooksSame() {
		Book book1 = new Book(19.99, 8579128);
		Book book2 = book1;
		basket.addBook(book);
		basket.addBook(book1);
		basket.addBook(book2);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(45.52, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfFourBooksInBasket_WhenTwoSetsOfBooksSame() {
		Book book1 = new Book(19.99, 8579128);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book1);
		basket.addBook(book1);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(45.52, totalPrice, 0.01);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfSixBooksInBasket_WhenTwoHalvesOfBooksSame() {
		Book book1 = new Book(19.99, 8579128);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book);
		basket.addBook(book1);
		basket.addBook(book1);
		basket.addBook(book1);
		double totalPrice = checkout.calculatePrice(basket);
		assertEquals(90.12, totalPrice, 0.01);
	}
	



}
