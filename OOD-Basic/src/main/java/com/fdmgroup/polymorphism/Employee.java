package com.fdmgroup.polymorphism;

public class Employee {
	private String name;
	private int salary;
	private int yearsOfService;
	
	public Employee(int salary) {
		if(salary < 0) {
			this.salary = 0;
		} else {
			this.salary = salary;
		}
	}
	
	public Employee(int salary, int yearsOfService) {
		this(salary);
		if(yearsOfService < 0) {
			this.yearsOfService = 0;
		} else {
			this.salary = yearsOfService;
		}
	}
	
	public Employee(int salary, int yearsOfService, String name) {
		this(salary, yearsOfService);
		this.name = name;
	}

}
