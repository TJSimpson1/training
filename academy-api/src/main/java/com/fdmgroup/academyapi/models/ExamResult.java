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

@Entity(name="exam_results")
public class ExamResult {

	@Id
	@Column(name="result_id")
	@SequenceGenerator(name = "RESULT_ID_GEN", sequenceName = "result_id_seq", initialValue = 309, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESULT_ID_GEN")
	private int id;
	@ManyToOne
	@JoinColumn(name="trainee_id")
	private Trainee trainee;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	@Temporal(TemporalType.DATE)
	@Column(name="exam_date")
	private Date examDate;
	private int score;
	
	public int getId() {
		return id;
	}
	public void setId(int resultId) {
		this.id = resultId;
	}
	public Trainee getTrainee() {
		return trainee;
	}
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
