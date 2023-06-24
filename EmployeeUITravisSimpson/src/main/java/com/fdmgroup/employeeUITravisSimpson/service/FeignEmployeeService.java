package com.fdmgroup.employeeUITravisSimpson.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fdmgroup.employeeUITravisSimpson.model.Employee;

@FeignClient(name = "EMPLOYEE-API", path = "/api/v1/employees")
public interface FeignEmployeeService {
	
	@GetMapping
	public List<Employee> getAllEmployees();

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee); 
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") int id);
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") int id);
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value = "id") int id);
	
	@GetMapping("/firstName/{firstName}")
	public List<Employee> listEmployeesByFirstName(@PathVariable(value = "firstName") String firstName);
	
	@GetMapping("/lastName/{lastName}")
	public List<Employee> listEmployeesByLastName(@PathVariable(value = "lastName") String lastName);
	
}
