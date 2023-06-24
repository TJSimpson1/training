package com.example.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springproject.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {
	
	/**
	 Case-insensitive partial search of employees by address.
	 @param address String of address to be searched
	 @return list of employees whose address contains (wholly or partially) the String argument where case is ignored
	 */
	public List<Employee> findByAddressContainingIgnoreCase(String address);
	
	/**
	 Case-insensitive full search of employees by first name.
	 @param firstName String of first name to be searched
	 @return list of employees whose first name matches the String argument where case is ignored
	 */
	public List<Employee> findByFirstNameIgnoreCase(String firstName);
	
	/**
	 Case-insensitive full search of employees by last name.
	 @param lastName String of last name to be searched
	 @return list of employees whose last name matches the String argument where case is ignored
	 */
	public List<Employee> findByLastNameIgnoreCase(String lastName);
}
