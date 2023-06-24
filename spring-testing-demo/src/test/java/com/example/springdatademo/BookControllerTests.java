package com.example.springdatademo;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springdatademo.controller.BookController;
import com.example.springdatademo.model.Book;
import com.example.springdatademo.service.BookService;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTests {
	
	@Autowired
	BookController bookController;
	
	@Autowired
	MockMvc mockMvc; //This is NOT a mock object!
	
	// dependencies are mock objects
	@MockBean
	BookService mockBookService;
	
	@MockBean
	Book mockBook;
	
	
	

	@Test
	void contextLoads() {
	}
	
	// Test if correct service is called for each request
	@Test
	void test_GETrequestToShowBooks_callsListBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/show-books"));
		verify(mockBookService).listbooks();
	}
	
	@Test
	void test_POSTrequestToSubmitNewBook_callsAddBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/submit-new-book").flashAttr("book", mockBook));
		verify(mockBookService).addBook(mockBook);
	}
	
	@Test
	void test_GETrequestToDeleteBook_callsDeleteBook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/delete-book").param("isbn", "123"));
		verify(mockBookService).deleteBook(123);
	}
	
	// Test if the correct page is displayed for each request
	@Test
	void test_GETrequestToShowBooks_displayShowBooksPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/show-books"))
				.andExpect(MockMvcResultMatchers.view().name("showBooks"));
	}
	
	@Test
	void test_POSTrequestToHandleSubmitNewBook_redirectsToShowBooks_whenAddBookReturnsBook() throws Exception {
		when(mockBookService.addBook(mockBook)).thenReturn(mockBook);
		mockMvc.perform(MockMvcRequestBuilders.post("/submit-new-book").flashAttr("book", mockBook))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/show-books"));
	}
	
	@Test
	void test_POSTrequestToHandleSubmitNewBook_redirectsToAddBook_whenAddBookReturnsNull() throws Exception {
		when(mockBookService.addBook(mockBook)).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.post("/submit-new-book").flashAttr("book", mockBook))
				.andExpect(MockMvcResultMatchers.view().name("redirect:/add-book"));
	}

}
