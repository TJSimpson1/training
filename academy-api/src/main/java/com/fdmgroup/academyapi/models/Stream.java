package com.fdmgroup.academyapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="streams")
public class Stream {

	@Id
	@Column(name="stream_id")
	@SequenceGenerator(name = "STREAM_ID_GEN", sequenceName = "stream_id_seq", initialValue = 6, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STREAM_ID_GEN")
	private int id;
	@Column(unique = true)
	private String name;
	@Column(name="duration_weeks")
	private int durationWeeks;
	
	@ManyToMany
	@JoinTable(name="streams_courses", joinColumns=@JoinColumn(name="stream_id"), inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;
	
	
	public int getId() {
		return id;
	}
	public void setId(int streamId) {
		this.id = streamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDurationWeeks() {
		return durationWeeks;
	}
	public void setDurationWeeks(int durationWeeks) {
		this.durationWeeks = durationWeeks;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
		
}
