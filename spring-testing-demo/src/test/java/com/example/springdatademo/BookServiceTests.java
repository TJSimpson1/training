package com.example.springdatademo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springdatademo.model.Book;
import com.example.springdatademo.repository.BookDAO;
import com.example.springdatademo.service.BookService;

@SpringBootTest
class BookServiceTests {
	
	@Autowired
	BookService bookService;
	
	// Dependencies are all mocks
	@MockBean
	BookDAO mockBookDAO;
	
	@MockBean
	Book mockBook;
	
	@MockBean
	List<Book> mockBookList;
	

	@Test
	void contextLoads() {
	}
	
	@Test
	void test_listBooks_callsFindAll() {
		bookService.listbooks();
		verify(mockBookDAO).findAll();
	}
	
	@Test
	void test_addBook_callsSavePassingInBook_whenBookDoesntExistInDB() {
		when(mockBook.getIsbn()).thenReturn(123);
		when(mockBookDAO.existsById(123)).thenReturn(false);
		bookService.addBook(mockBook);
		verify(mockBookDAO, times(1)).save(mockBook);
	}
	
	@Test
	void test_addBook_doesntCallSavePassingInBook_whenBookExistsInDB() {
		when(mockBook.getIsbn()).thenReturn(123);
		when(mockBookDAO.existsById(123)).thenReturn(true);
		bookService.addBook(mockBook);
		verify(mockBookDAO, times(0)).save(mockBook);
	}
	

}
