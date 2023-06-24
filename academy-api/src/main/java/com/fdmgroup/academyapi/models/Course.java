package com.fdmgroup.academyapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="courses")
public class Course {

	@Id
	@Column(name="course_id")
	@SequenceGenerator(name = "COURSE_ID_GEN", sequenceName = "course_id_seq", initialValue = 14, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_ID_GEN")
	private int id;
	@Column(unique = true)
	private String name;
	@Column(name="duration_days")
	private int durationDays;
	
	public int getId() {
		return id;
	}
	public void setId(int courseId) {
		this.id = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDurationDays() {
		return durationDays;
	}
	public void setDurationDays(int durationDays) {
		this.durationDays = durationDays;
	}

		
}
