package com.fdmgroup.mockitoExercise;

import static org.junit.jupiter.api.Assertions.*;
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
class TestSalaryManager {
	
	SalaryManager salaryManager;
	List<Employee> twoEmployees;
	List<Employee> threeEmployees;
	
	@Mock
	Employee mockEmployee1, mockEmployee2, mockEmployee3;
	
	@Mock
	Department mockDepartment;

	@BeforeEach
	void setUp() throws Exception {
		salaryManager = new SalaryManager();
		twoEmployees = new ArrayList<>(Arrays.asList(mockEmployee1, mockEmployee2));
		threeEmployees = new ArrayList<>(Arrays.asList(mockEmployee1, mockEmployee2, mockEmployee3));
	}

	@Test
	void test_increaseSalary_callsGetSalaryMethod_whenEmployeePassedIn() {
		salaryManager.increaseSalary(mockEmployee1, 10.0);
		
		verify(mockEmployee1).getSalary();
	}
	
	@Test
	void test_increaseSalary_callsSetSalaryWith110000_WhenSalaryIs100000AndPercentIs10() {
		when(mockEmployee1.getSalary()).thenReturn(100000);
		
		salaryManager.increaseSalary(mockEmployee1, 10.0);
		
		verify(mockEmployee1).setSalary(110000);
	}
	
	@Test
	void test_increaseSalary_callsSetSalaryWith78750_WhenSalaryIs75000AndPercentIs5() {
		when(mockEmployee1.getSalary()).thenReturn(75000);
		
		salaryManager.increaseSalary(mockEmployee1, 5.0);
		
		verify(mockEmployee1).setSalary(78750);
	}
	
	@Test
	void test_increaseDepartmentSalaries_callsGetEmployees_whenDepartmentPassedIn() {
		salaryManager.increaseDepartmentSalaries(mockDepartment, 10.0);
		
		verify(mockDepartment).getEmployees();
	}
	
	@Test
	void test_increaseDepartmentSalaries_callsGetSalaryTwice_whenDepartmentWith2EmployeesPassedIn() {
		when(mockDepartment.getEmployees()).thenReturn(twoEmployees);
		
		salaryManager.increaseDepartmentSalaries(mockDepartment, 10.0);
		
		verify(mockEmployee1).getSalary();
		verify(mockEmployee2).getSalary();
	}
	
	@Test
	void test_increaseDepartmentSalaries_callsGetSalaryThreeTimes_whenDepartmentWith3EmployeesPassedIn() {
		when(mockDepartment.getEmployees()).thenReturn(threeEmployees);
		
		salaryManager.increaseDepartmentSalaries(mockDepartment, 10.0);
		
		verify(mockEmployee1).getSalary();
		verify(mockEmployee2).getSalary();
		verify(mockEmployee3).getSalary();
	}
	
	@Test
	void test_increaseDepartmentSalaries_callsSetSalaryTwiceWithCorrectVals_forDeptWith2Employees() {
		when(mockDepartment.getEmployees()).thenReturn(twoEmployees);
		when(mockEmployee1.getSalary()).thenReturn(100000);
		when(mockEmployee2.getSalary()).thenReturn(50000);
		
		salaryManager.increaseDepartmentSalaries(mockDepartment, 1.0);
		
		verify(mockEmployee1).setSalary(101000);
		verify(mockEmployee2).setSalary(50500);
		
	}
	
	@Test
	void test_increaseDepartmentSalaries_callsSetSalaryTwiceWithCorrectVals_forDeptWith3Employees() {
		when(mockDepartment.getEmployees()).thenReturn(threeEmployees);
		when(mockEmployee1.getSalary()).thenReturn(100000);
		when(mockEmployee2.getSalary()).thenReturn(50000);
		when(mockEmployee3.getSalary()).thenReturn(20000);
		
		salaryManager.increaseDepartmentSalaries(mockDepartment, 5.0);
		
		verify(mockEmployee1).setSalary(105000);
		verify(mockEmployee2).setSalary(52500);
		verify(mockEmployee3).setSalary(21000);
		
	}
	
	

}
