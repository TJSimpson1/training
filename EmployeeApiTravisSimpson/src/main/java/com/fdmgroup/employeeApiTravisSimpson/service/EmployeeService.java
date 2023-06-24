package com.fdmgroup.employeeApiTravisSimpson.service;

import java.util.List;

import java.util.Optional;


import org.springframework.stereotype.Service;

import com.fdmgroup.employeeApiTravisSimpson.exception.ResourceNotFoundException;
import com.fdmgroup.employeeApiTravisSimpson.model.Employee;
import com.fdmgroup.employeeApiTravisSimpson.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepo;

	public EmployeeService(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> employeeOpt = employeeRepo.findById(id);
		if(employeeOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		return employeeOpt.get();
	}
	
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	private String getMessage(int id) {
		return "Employee with id of " + id + " not found.";
	}

	public Employee updateEmployee(Employee employee, int id) {
		Optional<Employee> employeeOpt = employeeRepo.findById(id);
		if(employeeOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		String state = employeeOpt.get().getState();
		String country = employeeOpt.get().getCountry();
		employee.setId(id);
		employee.setState(state);
		employee.setCountry(country);
		return employeeRepo.save(employee);
	}

	public void deleteById(int id) {
		Optional<Employee> employeeOpt = employeeRepo.findById(id);
		if(employeeOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		employeeRepo.deleteById(id);
	}

	public List<Employee> listEmployeesByFirstName(String firstName) {
		return employeeRepo.findByFirstNameContainingIgnoreCase(firstName);
	}
	
	public List<Employee> listEmployeesByLastName(String lastName) {
		return employeeRepo.findByLastNameContainingIgnoreCase(lastName);
	}

}
