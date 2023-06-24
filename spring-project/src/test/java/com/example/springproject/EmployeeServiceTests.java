package com.example.springproject;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springproject.model.Employee;
import com.example.springproject.repository.EmployeeDAO;
import com.example.springproject.service.EmployeeService;

@SpringBootTest
class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	EmployeeDAO mockEmployeeDAO;
	
	@MockBean
	Employee mockEmployee;
	
	@MockBean 
	List<Employee> mockEmployeeList;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test_addEmployee_callsSavePassingInEmployee_whenAllEmployeeAttributesFilledOut() {
		when(mockEmployee.getId()).thenReturn(123L);
		when(mockEmployee.getFirstName()).thenReturn("fName");
		when(mockEmployee.getLastName()).thenReturn("lName");
		when(mockEmployee.getHireDate()).thenReturn(LocalDate.of(2020, 1, 7));
		when(mockEmployee.getAddress()).thenReturn("address");
		employeeService.addEmployee(mockEmployee);
		verify(mockEmployeeDAO, times(1)).save(mockEmployee);
	}
	
	@Test
	void test_addEmployee_doesntCallSavePassingInEmployee_whenAddressNotFilledOut() {
		when(mockEmployee.getId()).thenReturn(123L);
		when(mockEmployee.getFirstName()).thenReturn("fName");
		when(mockEmployee.getLastName()).thenReturn("lName");
		when(mockEmployee.getHireDate()).thenReturn(LocalDate.of(2020, 1, 7));
		when(mockEmployee.getAddress()).thenReturn("");
		employeeService.addEmployee(mockEmployee);
		verify(mockEmployeeDAO, times(0)).save(mockEmployee);
	}
	
	@Test
	void test_listEmployees_callsFindAll(){
		employeeService.listEmployees();
		verify(mockEmployeeDAO).findAll();
	}
	
	@Test
	void test_listEmployeesByAddress_callsFindByAddressContainingIgnoreCase() {
		employeeService.listEmployeesByAddress("address");
		verify(mockEmployeeDAO).findByAddressContainingIgnoreCase("address");
	}
	
	@Test
	void test_listEmployeesByFirstName_callsFindByFirstNameIgnoreCase() {
		employeeService.listEmployeesByFirstName("fName");
		verify(mockEmployeeDAO).findByFirstNameIgnoreCase("fName");
	}
	
	@Test
	void test_listEmployeesByLastName_callsFindByLastNameIgnoreCase() {
		employeeService.listEmployeesByLastName("lName");
		verify(mockEmployeeDAO).findByLastNameIgnoreCase("lName");
	}


}