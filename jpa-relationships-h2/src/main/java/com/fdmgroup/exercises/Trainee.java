package com.fdmgroup.exercises;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Trainee.findByStream", query = "SELECT t FROM Trainee t WHERE t.stream = :givenStream")
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainee_gen")
	@SequenceGenerator(name = "trainee_gen", sequenceName = "trainee_seq", allocationSize = 1)
	@Column(name = "TRAINEE_ID")
	private int id;
	@Column(name = "FIRST_NAME", nullable=false, updatable=false)
	private String firstName;
	@Column(name = "LAST_NAME", nullable=false, updatable=false)
	private String lastName;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_STREAM_ID")
	private Stream stream;
	
	Trainee() {}
	
	public Trainee(String firstName, String lastName, Stream stream) {
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
	public Stream getStream() {
		return stream;
	}
	public void setStream(Stream stream) {
		this.stream = stream;
	}

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", stream=" + stream + "]";
	}
	
	
	
	
	
	
}
