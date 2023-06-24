package com.fdmgroup.inheritanceClasses;

public class Runner {

	public static void main(String[] args) {
		Manager manager = new Manager("Tim", "Academy Manager", 100000);
		
		manager.manage();
		manager.work();
		
		SalaryManager salaryManager = new SalaryManager();
		salaryManager.increaseSalary(manager, 10);
		
		System.out.println(manager.getName() + " now earns £" + manager.getSalary());

	}

}
