package com.fdmgroup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_gen")
	@SequenceGenerator(name = "emp_gen", sequenceName = "emp_seq", allocationSize = 1)
	@Column(name = "EMP_ID")
	private int id;
	@Column(name = "EMP_NAME", nullable = false, updatable = false)
	private String empName;
	@Column(name = "EMP_DESIGNATION", nullable = false)
	private String empDesignation;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "FK_DEPT_ID")
	private Department department;
	
	Employee(){}

	public Employee(String empName, String empDesignation, Department department) {
		super();
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.department = department;
		department.getEmployees().add(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empDesignation=" + empDesignation + ", department="
				+ department + "]";
	}
	
	
	
	

}
