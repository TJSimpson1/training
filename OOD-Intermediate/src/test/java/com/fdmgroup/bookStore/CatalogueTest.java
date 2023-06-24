package com.fdmgroup.bookStore;

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
class CatalogueTest {
	
	Catalogue catalogue;
	
	@Mock
	ReadItemCommand mockReadItemCommand;
	
	@Mock
	WriteItemCommand mockWriteItemCommand;
	
	@Mock
	Book mockBook1, mockBook2, mockBook3;
	
	

	@BeforeEach
	void setUp() throws Exception {
		catalogue = new Catalogue(mockReadItemCommand, mockWriteItemCommand);
		
 	}

	@Test
	void test_getAllBooks_ReturnsEmptyList_IfNoBooksAreInTheCatalogue() {
		int listOfBooksSize = catalogue.getAllBooks().size(); //Act
		assertEquals(0, listOfBooksSize); //Assert
	}
	
	@Test
	void test_getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() {
		catalogue.getAllBooks(); //Act
		verify(mockReadItemCommand).readAll();	
	}
	
	@Test
	void test_getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() {
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2,mockBook3));
		when(mockReadItemCommand.readAll()).thenReturn(mockBooks);
		
		List<Book> listOfBooks = catalogue.getAllBooks();
		assertEquals(mockBooks, listOfBooks);
	}
	
	@Test
	void test_addBook_CallsInsertItemMethodOfWriteItemCommand_WhenCalled() {
		catalogue.addBook(mockBook1);
		verify(mockWriteItemCommand).insertItem(mockBook1);
	}
	
	@Test
	void test_addBooks_CallsInsertItemMethodOfWriteItemCommandThreeTimes_WhenPassingInThreeBooks() {
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2,mockBook3));
		catalogue.addBooks(mockBooks);
		verify(mockWriteItemCommand, times(3)).insertItem(any(Book.class));
	}
	
	@Test
	void test_getBook_ReturnsBookItReceivesFromGetItemMethodOfReadItemCommand_WhenCalled() {
		mockBook1.setIsbn("123456");
		
		when(mockReadItemCommand.getItem("123456")).thenReturn(mockBook1);
		Book readBook = catalogue.getBook("123456");
		
		verify(mockReadItemCommand).getItem("123456");
		assertEquals(mockBook1, readBook);
	}
	
	@Test
	void test_getBook_ReturnsAnotherBookItReceivesFromGetItemMethodOfReadItemCommand_WhenCalled() {
		mockBook2.setIsbn("193753");
		
		when(mockReadItemCommand.getItem("193753")).thenReturn(mockBook2);
		Book readBook = catalogue.getBook("193753");

		verify(mockReadItemCommand).getItem("193753");
		assertEquals(mockBook2, readBook);
		
	}
	
//	@Test
//	void test_getBook_ReturnsNullWhenItReceivesAnIncorrectIsbn_WhenCalled() {
//		mockBook3.setIsbn("123456");
//		
//		//when(mockReadItemCommand.getItem("123456")).thenReturn(mockBook3);
//		when(mockReadItemCommand.getItem("987654")).thenReturn(null);
//		
//		Book readBook = catalogue.getBook("987654");
//
//		verify(mockReadItemCommand).getItem("987654");
//		assertEquals(null, readBook);
//		
//	}
	
	@Test
	void test_deleteBook_PassesBookOntoDeleteItemMethodOfWriteItemCommand_WhenCalled() {
		catalogue.deleteBook(mockBook1);
		
		verify(mockWriteItemCommand).deleteItem(mockBook1);
	}
	
	@Test
	void test_deleteAllBooks_CallsReadAllMethodOfReadItemCommandAndCallsDeleteItemOfWriteItemCommandForAllBooks_WhenCalled() {
		List<Book> mockBooks = new ArrayList<>(Arrays.asList(mockBook1,mockBook2,mockBook3));
		when(mockReadItemCommand.readAll()).thenReturn(mockBooks);
		
		catalogue.deleteAllBooks();
		
		verify(mockReadItemCommand).readAll();
		verify(mockWriteItemCommand, times(3)).deleteItem(any(Book.class));
	}

}
