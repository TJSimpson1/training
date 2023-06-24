package com.fdmgroup.inheritanceClasses;

public class Employee {
	protected String name;
	private String jobTitle;
	private int salary;


	public Employee(String name, String jobTitle, int salary) {
		super();
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	
	public void work() {
		System.out.println(name + " is working as a/an " + jobTitle + " and earns £" + salary);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	

}
