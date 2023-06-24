package com.fdmgroup.json;

public class Course {
	private String classId;
	private String stream;
	private String[] trainees;
	
	public Course(String classId, String stream, String[] trainees) {
		super();
		this.classId = classId;
		this.stream = stream;
		this.trainees = trainees;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String[] getTrainees() {
		return trainees;
	}
	public void setTrainees(String[] trainees) {
		this.trainees = trainees;
	}
	
	
}
