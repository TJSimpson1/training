package com.fdmgroup.academyapi.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="trainers")
public class Trainer {

	@Id
	@Column(name="trainer_id")
	@SequenceGenerator(name = "TRAINER_ID_GEN", sequenceName = "trainer_id_seq", initialValue = 21, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINER_ID_GEN")
	private int id;
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;
	@ManyToOne
	@JoinColumn(name="academy_id")
	private Academy academy;
	@ManyToMany
	@JoinTable(name="trainers_courses", joinColumns=@JoinColumn(name="trainer_id"), inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int trainerId) {
		this.id = trainerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
