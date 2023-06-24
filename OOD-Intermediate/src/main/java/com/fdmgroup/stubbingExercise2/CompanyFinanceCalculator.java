package com.fdmgroup.stubbingExercise2;

public class CompanyFinanceCalculator {

	public int calculateDepartmentWageBill(Department department) {
		int total = 0;
		for(Employee eachEmployee : department.getAllEmployees()) {
			total += eachEmployee.getSalary();
		}
		
		return total;
	}

}
