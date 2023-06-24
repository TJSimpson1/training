package com.fdmgroup.staticKeywordExercises;

public class Runner2 {

	public static void main(String[] args) {
		Employee.setMinimumWage(9.53);
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		employee1.setName("John");
		employee1.setJobTitle("Trainer");
		employee1.setHourlyWage(6.50);
		
		employee2.setName("Bob");
		employee2.setJobTitle("Salesman");
		employee2.setHourlyWage(9.00);
		
		employee3.setName("Michael");
		employee3.setJobTitle("Manager");
		employee3.setHourlyWage(12.70);
		
		System.out.println(employee1.getName() + ": " + employee1.getJobTitle() + ": " + employee1.getHourlyWage());
		System.out.println(employee2.getName() + ": " + employee2.getJobTitle() + ": " + employee2.getHourlyWage());
		System.out.println(employee3.getName() + ": " + employee3.getJobTitle() + ": " + employee3.getHourlyWage());

	}

}
