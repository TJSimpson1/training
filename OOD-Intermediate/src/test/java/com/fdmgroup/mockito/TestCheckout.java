package com.fdmgroup.mockito;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestCheckout {
	
	Checkout checkout;
	
	@Mock
	Basket mockBasket;
	
	@Mock
	Book mockBook1, mockBook2, mockBook3;
	
	//The class we are testing is the ONLY real object. All the rest are just mocks
	@BeforeEach
	void setUp() throws Exception {
		checkout = new Checkout();
	}
	

	@Test
	void test_calculatePrice_callsMockBasketGetBooksInBasketMethod() {
		//No need to store return value (i.e. double total = ...) since the value is not being tested
		checkout.calculatePrice(mockBasket); //Act
		verify(mockBasket).getBooksInBasket();
	}
	
//	@Test
//	void test() {
//		mockBook1.setPrice(2.50);
//		mockBook2.setPrice(9.99);
//		
//		when(mockBook1.getPrice()).thenReturn(10.50);
//		when(mockBook2.getPrice()).thenReturn(13.55);
//		
//		System.out.println("Book 1: " + mockBook1.getPrice());
//		System.out.println("Book 2: " + mockBook2.getPrice());
//	}
	
	@Test
	void test_calculatePrice_returns20point5_whenBooksCosting9point25And11point25InBasket() {
		when(mockBook1.getPrice()).thenReturn(9.25);
		when(mockBook2.getPrice()).thenReturn(11.25);
		
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2));
		when(mockBasket.getBooksInBasket()).thenReturn(mockBooks);
		
		double total = checkout.calculatePrice(mockBasket); //Act
		assertEquals(20.5, total);
		
	}
	
	@Test
	void test_calculatePrice_returns25_whenBooksCosting9point25And11point25And4point5InBasket() {
		when(mockBook1.getPrice()).thenReturn(9.25);
		when(mockBook2.getPrice()).thenReturn(11.25);
		when(mockBook3.getPrice()).thenReturn(4.5);
		
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2,mockBook3));
		when(mockBasket.getBooksInBasket()).thenReturn(mockBooks);
		
		double total = checkout.calculatePrice(mockBasket); //Act
		assertEquals(25, total);
		
	}
	
	@Test
	void test_emptyBasket_callsRemoveBookTwice_whenTwoBooksInBasket() {
//		when(mockBook1.getPrice()).thenReturn(9.25);
//		when(mockBook2.getPrice()).thenReturn(11.25);
		
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2));
		when(mockBasket.getBooksInBasket()).thenReturn(mockBooks);
		
		checkout.emptyBasket(mockBasket);
		
		verify(mockBasket, times(2)).removeBook(any(Book.class));
	}
	
	@Test
	void test_emptyBasket_callsRemoveBookThreeTimes_whenThreeBooksInBasket() {
//		when(mockBook1.getPrice()).thenReturn(9.25);
//		when(mockBook2.getPrice()).thenReturn(11.25);
//		when(mockBook3.getPrice()).thenReturn(4.5);
		
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2,mockBook3));
		when(mockBasket.getBooksInBasket()).thenReturn(mockBooks);
		
		checkout.emptyBasket(mockBasket);
		
		verify(mockBasket, times(3)).removeBook(any(Book.class));
	}

}
