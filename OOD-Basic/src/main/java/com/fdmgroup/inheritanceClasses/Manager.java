package com.fdmgroup.inheritanceClasses;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {

	private List<Employee> employees = new ArrayList<Employee>();
	
	/*
	 * Child classes inherit everything with exception of the constructor
	*/
	public Manager(String name, String jobTitle, int salary) {
		super(name, jobTitle, salary);
	}
	
	public void manage() {
		System.out.println(name + " is managing their team");
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
