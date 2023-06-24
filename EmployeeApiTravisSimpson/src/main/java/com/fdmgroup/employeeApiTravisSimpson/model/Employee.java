package com.fdmgroup.employeeApiTravisSimpson.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "First name must not be null or blank.")
	@Size(min = 2, max = 30, message = "First name must be between 2-30 characters.")
	private String firstName;
	@NotBlank(message = "Last name must not be null or blank.")
	@Size(min = 2, max = 30, message = "Last name must be between 2-30 characters.")
	private String lastName;
	@Min(value = 12000, message = "Salary must be over £12,000.")
	private BigDecimal salary;
	@NotBlank(message = "State must not be null or blank.")
	@Size(min = 2, max = 30, message = "State must be between 2-30 characters.")
	private String state;
	@NotBlank(message = "Country must not be null or blank.")
	@Size(min = 2, max = 30, message = "Country must be between 2-30 characters.")
	private String country;
	
	
	
	public Employee(String firstName, String lastName, BigDecimal salary, String state, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.state = state;
		this.country = country;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	

}
