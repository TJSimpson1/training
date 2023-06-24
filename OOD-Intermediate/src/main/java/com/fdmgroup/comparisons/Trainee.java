package com.fdmgroup.comparisons;

public class Trainee implements Comparable<Trainee> {
	private String name;
	private Integer week;
	private double averageExamScore;
	public Trainee(String name, Integer week, double averageExamScore) {
		super();
		this.name = name;
		this.week = week;
		this.averageExamScore = averageExamScore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWeek() {
		return week;
	}
	public void setWeek(Integer week) {
		this.week = week;
	}
	public double getAverageExamScore() {
		return averageExamScore;
	}
	public void setAverageExamScore(double averageExamScore) {
		this.averageExamScore = averageExamScore;
	}
	@Override
	public int compareTo(Trainee anotherTrainee) {
		return name.compareTo(anotherTrainee.getName()); //Flip order to get descending
	}
	
	
}
