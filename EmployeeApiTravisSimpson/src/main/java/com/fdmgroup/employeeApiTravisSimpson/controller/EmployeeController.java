package com.fdmgroup.employeeApiTravisSimpson.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.employeeApiTravisSimpson.exception.ResourceNotFoundException;
import com.fdmgroup.employeeApiTravisSimpson.model.Employee;
import com.fdmgroup.employeeApiTravisSimpson.service.EmployeeService;
import com.google.common.net.HttpHeaders;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@Operation(
			summary = "Finds and returns all employees.",
			description = "Finds and returns all employees currently in the database.",
			method = "GET",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns employee resources successfully, employee resources are returned"
									+ "in a JSON list in the body of the response.",
							content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
					)
			}
	)
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		return ResponseEntity
				.ok(employeeService.getAllEmployees());
	}
	
	@Operation(
			summary = "Finds and returns a single employee based on ID.",
			description = "Finds and returns a single employee with a matching ID to the supplied ID argument.",
			method = "GET",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns employee resource successfully found, employee resource is returned"
									+ "as a JSON object in the body of the response.",
							content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
					),
					@ApiResponse(
							responseCode = "404",
							description = "There is no employee resource with the given ID.",
							content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}
					)
			}
	)
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.getEmployeeById(id));
	}
	
	@Operation(
			summary = "Creates a new Employee resource.",
			description = "Accepts an employee object and creates the new employee resource if employee attributes are valid.",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "Employee created, location of employee in header.",
							content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)},
							headers = {@Header(
									name = HttpHeaders.LOCATION,
									description = "The location of the new employee resource.",
									required = true
							)}
					),
					@ApiResponse(
							responseCode = "400",
							description = "Employee is invalid, returns a CSV string containing validation errors.",
							content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}
					)
			}
	)
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
		employeeService.createEmployee(employee);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(employee.getId())
				.toUri();
		return ResponseEntity
				.created(location)
				.body(employee);
	}
	
	@Operation(
			summary = "Updates an Employee resource.",
			description = "Validates a supplied employee object, then checks if supplied ID is valid. Finally employee is updated.",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Employee updated.",
							content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)},
							headers = {@Header(
									name = HttpHeaders.LOCATION,
									description = "The location of the new employee resource.",
									required = true
							)}
					),
					@ApiResponse(
							responseCode = "400",
							description = "Employee is invalid, returns a CSV string containing validation errors.",
							content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}
					),
					@ApiResponse(
							responseCode = "404",
							description = "There is no employee resource with the given ID.",
							content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}
					)
			}
	)
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable int id){
		return ResponseEntity
				.ok(employeeService.updateEmployee(employee, id));
	}
	
	@Operation(
			summary = "Deletes an Employee resource.",
			description = "Checks if supplied ID is valid, then employee is deleted.",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Employee deleted.",
							content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}
					),
					@ApiResponse(
							responseCode = "404",
							description = "There is no employee resource with the given ID.",
							content = {@Content(mediaType = MediaType.TEXT_PLAIN_VALUE)}
					)
			}
	)
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		employeeService.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
	
	@GetMapping("/firstName/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String firstName){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.listEmployeesByFirstName(firstName));
	}
	
	@GetMapping("/lastName/{lastName}")
	public ResponseEntity<List<Employee>> getEmployeeByLastName(@PathVariable String lastName){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(employeeService.listEmployeesByLastName(lastName));
	}
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	

}
