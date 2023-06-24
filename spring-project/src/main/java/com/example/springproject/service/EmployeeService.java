package com.example.springproject.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springproject.model.Employee;
import com.example.springproject.repository.EmployeeDAO;

@Service
public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	private Logger logger = LogManager.getLogger(EmployeeService.class);

	@Autowired
	public EmployeeService(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	
	/**
	 If no employee attribute is blank, saves and returns {@code employee}, otherwise just returns {@code null}.
	 @param employee object's attributes will determine return
	 @return {@code null} if one or more employee attribute is blank, otherwise {@code employee}
	 @see org.springframework.data.repository.CrudRepository#save(S entity)
	 @see java.lang.String#isBlank()
	 */
	public Employee addEmployee(Employee employee) {
		logger.trace("Entering addEmployee method");
		if(employee.getFirstName().isBlank() || employee.getLastName().isBlank() || employee.getHireDate() == null || employee.getAddress().isBlank()) {
			logger.trace("Exiting addEmployee method returning null");
			return null;
		}
		logger.trace("Exiting addEmployee method returning employee");
		return employeeDAO.save(employee);
	}
	
	/**
	 Returns list of all employees.
	 @return all employees
	 @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Employee> listEmployees(){
		return employeeDAO.findAll();
	}
	
	/**
	 Returns list of employees with address containing String argument (case-insensitive)
	 @param address String of address to be searched
	 @return list of employees whose address partially or wholly matches argument where case is insensitive
	 @see com.example.springproject.repository.EmployeeDAO#findByAddressContainingIgnoreCase(String address)
	 */
	public List<Employee> listEmployeesByAddress(String address){
		return employeeDAO.findByAddressContainingIgnoreCase(address);
	}
	
	/**
	 Returns list of employees whose first name matches String argument (case-insensitive)
	 @param firstName String of first name to be searched
	 @return list of employees whose first name matches argument where case is insensitive
	 @see com.example.springproject.repository.EmployeeDAO#findByFirstNameIgnoreCase(String firstName)
	 */
	public List<Employee> listEmployeesByFirstName(String firstName){
		return employeeDAO.findByFirstNameIgnoreCase(firstName);
	}
	
	/**
	 Returns list of employees whose last name matches String argument (case-insensitive)
	 @param lastName String of last name to be searched
	 @return list of employees whose last name matches argument where case is insensitive
	 @see com.example.springproject.repository.EmployeeDAO#findByLastNameIgnoreCase(String firstName)
	 */
	public List<Employee> listEmployeesByLastName(String lastName){
		return employeeDAO.findByLastNameIgnoreCase(lastName);
	}
	
	

}
