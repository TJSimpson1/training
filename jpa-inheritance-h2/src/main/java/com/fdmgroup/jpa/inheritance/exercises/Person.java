package com.fdmgroup.jpa.inheritance.exercises;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BankCustomer {
	
	@Column(name="FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name="LAST_NAME", nullable = false)
	private String lastName;
	
	Person(){}

	public Person(String firstName, String lastName, String address) {
		super(address);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", getId()=" + getId() + ", getAddress()="
				+ getAddress() + "]";
	}
	
	

}
