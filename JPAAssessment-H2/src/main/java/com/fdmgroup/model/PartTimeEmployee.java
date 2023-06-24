package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARTTIME_EMPLOYEE")
public class PartTimeEmployee extends Employee {
	@Column(name = "WAGES", nullable = false)
	private double wages;
	
	PartTimeEmployee(){}

	public PartTimeEmployee(String empName, String empDesignation, Department department, double wages) {
		super(empName, empDesignation, department);
		this.wages = wages;
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}
	
	

}
