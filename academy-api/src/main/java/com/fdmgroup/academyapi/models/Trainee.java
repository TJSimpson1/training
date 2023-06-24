package com.fdmgroup.academyapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="trainees")
public class Trainee {

	@Id
	@Column(name="trainee_id")
	@SequenceGenerator(name = "TRAINEE_ID_GEN", sequenceName = "trainee_id_seq", initialValue = 61, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINEE_ID_GEN")
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name="stream_id")
	private Stream stream;
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	@ManyToOne
	@JoinColumn(name="academy_id")
	private Academy academy;
	
	public int getId() {
		return id;
	}
	public void setId(int traineeId) {
		this.id = traineeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Stream getStream() {
		return stream;
	}
	public void setLearningStream(Stream stream) {
		this.stream = stream;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
		
}
