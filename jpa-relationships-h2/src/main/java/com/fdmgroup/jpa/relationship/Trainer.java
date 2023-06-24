package com.fdmgroup.jpa.relationship;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Trainer.findTrainerByAcademyLocation", query = "SELECT t from Trainer t WHERE t.academy.location = :givenLocation")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainer_gen")
	@SequenceGenerator(name = "trainer_gen", sequenceName = "trainer_seq", allocationSize=1)
	private int id;
	private String firstName;
	private String lastName;
	private String stream;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "FK_ACADEMY_ID")
	private Academy academy;
	
	Trainer() {}
	
	public Trainer(String firstName, String lastName, String stream) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.stream = stream;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", stream=" + stream + "]";
	}
	
}
