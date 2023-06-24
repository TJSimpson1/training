package com.example.springproject;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.springproject.controller.EmployeeController;
import com.example.springproject.model.Employee;
import com.example.springproject.service.EmployeeService;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTests {
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	EmployeeService mockEmployeeService;
	
	@MockBean
	Employee mockEmployee;

	@Test
	void contextLoads() {
	}
	
	@Test
	void test_GETrequestToAddEmployee_displaysAddBookPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/add-employee"))
		.andExpect(MockMvcResultMatchers.view().name("addEmployee"));
	}
	
	@Test
	void test_POSTrequestToHandleAddNewEmployee_redirectsToShowEmployees_whenAddEmployeeReturnsEmployee() throws Exception {
		when(mockEmployeeService.addEmployee(mockEmployee)).thenReturn(mockEmployee);
		mockMvc.perform(MockMvcRequestBuilders.post("/add-new-employee").flashAttr("employee", mockEmployee))
			.andExpect(MockMvcResultMatchers.view().name("redirect:/show-employees"));
	}
	
	@Test
	void test_GETrequestToShowEmployees_callsListEmployees() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/show-employees"));
		verify(mockEmployeeService).listEmployees();
	}
	
	@Test
	void test_POSTrequestToSearchAddress_callsListEmployeesByAddress() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/search-by-address").flashAttr("employee", mockEmployee).param("address", "Street road"));
		verify(mockEmployeeService).listEmployeesByAddress("Street road");
	}
	
	@Test
	void test_POSTrequestToSearchFirstName_callsListEmployeesByFirstName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/search-by-first-name").flashAttr("employee", mockEmployee).param("firstName", "John"));
		verify(mockEmployeeService).listEmployeesByFirstName("John");
	}
	
	@Test
	void test_POSTrequestToSearchLastName_callsListEmployeesByLastName() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/search-by-last-name").flashAttr("employee", mockEmployee).param("lastName", "Smith"));
		verify(mockEmployeeService).listEmployeesByLastName("Smith");
	}
	
	
	
	

}
