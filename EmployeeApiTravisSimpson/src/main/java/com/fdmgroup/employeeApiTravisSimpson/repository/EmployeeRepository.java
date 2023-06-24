package com.fdmgroup.employeeApiTravisSimpson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.employeeApiTravisSimpson.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
	
	List<Employee> findByLastNameContainingIgnoreCase(String lastName);

}
