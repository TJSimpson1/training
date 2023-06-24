package com.fdmgroup.stubbingExercise2;

import static org.junit.jupiter.api.Assertions.*;
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
class TestCompanyFinanceCalculator {
	
	CompanyFinanceCalculator companyFinanceCalculator;
	
	@Mock
	Department mockDepartment;
	
	@Mock
	Employee mockEmployee1, mockEmployee2, mockEmployee3;

	@BeforeEach
	void setUp() throws Exception {
		companyFinanceCalculator = new CompanyFinanceCalculator();
	}

	@Test
	void test_calculateDepartmentWageBill_returns90k_whenDepartmentWithEmployeesEarning30kAnd60kPassedIn() {
		when(mockEmployee1.getSalary()).thenReturn(30000);
		when(mockEmployee2.getSalary()).thenReturn(60000);
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(mockEmployee1,mockEmployee2));
		
		when(mockDepartment.getAllEmployees()).thenReturn(employees);
		
		int total = companyFinanceCalculator.calculateDepartmentWageBill(mockDepartment);
		assertEquals(90000, total);
	}
	
	@Test
	void test_calculateDepartmentWageBill_returns135k_whenDepartmentWithEmployeesEarning30kAnd60kAnd45kPassedIn() {
		when(mockEmployee1.getSalary()).thenReturn(30000);
		when(mockEmployee2.getSalary()).thenReturn(60000);
		when(mockEmployee3.getSalary()).thenReturn(45000);
		
		List<Employee> employees = new ArrayList<>(Arrays.asList(mockEmployee1,mockEmployee2,mockEmployee3));
		
		when(mockDepartment.getAllEmployees()).thenReturn(employees);
		
		int total = companyFinanceCalculator.calculateDepartmentWageBill(mockDepartment);
		assertEquals(135000, total);
	}

}
