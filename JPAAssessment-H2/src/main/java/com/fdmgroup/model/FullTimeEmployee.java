package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FULLTIME_EMPLOYEE")
public class FullTimeEmployee extends Employee {
	@Column(name = "SALARY", nullable = false)
	private double salary;
	
	FullTimeEmployee(){}

	public FullTimeEmployee(String empName, String empDesignation, Department department, double salary) {
		super(empName, empDesignation, department);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	

}
