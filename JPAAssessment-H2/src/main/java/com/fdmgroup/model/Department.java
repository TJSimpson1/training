package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Department.findByDeptName", query = "SELECT d FROM Department d WHERE d.deptName = :givenName")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_gen")
	@SequenceGenerator(name = "dept_gen", sequenceName = "dept_seq", allocationSize = 1)
	@Column(name = "DEPT_ID")
	private int deptId;
	
	@Column(name = "DEPT_NAME", nullable = false, unique = true)
	private String deptName;
	@OneToMany(mappedBy = "department")
	List<Employee> employees = new ArrayList<Employee>();
	
	Department() {}

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
	
	
	
	

}
