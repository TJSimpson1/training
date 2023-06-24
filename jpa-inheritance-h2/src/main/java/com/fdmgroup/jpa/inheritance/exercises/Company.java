package com.fdmgroup.jpa.inheritance.exercises;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :givenName")
public class Company extends BankCustomer {
	
	@Column(name="COMPANY_NAME", nullable = false, unique = true)
	private String name;
	@Column(name="COMPANY_ABN", nullable = false, unique = true)
	private long abn;
	
	Company(){}

	public Company(String name, long abn, String address) {
		super(address);
		this.name = name;
		this.abn = abn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAbn() {
		return abn;
	}

	public void setAbn(long abn) {
		this.abn = abn;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", abn=" + abn + ", getId()=" + getId() + ", getAddress()=" + getAddress()
				+ "]";
	}
	
	
	
	
	

}
