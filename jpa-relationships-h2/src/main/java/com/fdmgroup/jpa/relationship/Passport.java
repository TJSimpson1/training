package com.fdmgroup.jpa.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private int id;
	private String passportNumber;
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	Passport() {}
	
	public Passport(int id, String passportNumber) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", person=" + person + "]";
	}

	
	
	
}
