package com.fdmgroup.mockitoExercise;

import java.util.List;

public class SalaryManager {

	public void increaseSalary(Employee employee, double num) {
		int salary = employee.getSalary();
		employee.setSalary((int) (salary * (1 + (num / 100))));
	}

	public void increaseDepartmentSalaries(Department department, double percent) {
		List<Employee> employees = department.getEmployees();
		for(Employee eachEmployee : employees) {
			increaseSalary(eachEmployee, percent);
		}
		
	}

}
