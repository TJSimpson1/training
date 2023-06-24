package com.fdmgroup.staticKeywordExercises;

public class Employee {
	private String name;
	private String jobTitle;
	private double hourlyWage;
	private static double minimumWage;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public double getHourlyWage() {
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) {
		if(hourlyWage>minimumWage) {
			this.hourlyWage = hourlyWage;
		}else {
			this.hourlyWage = minimumWage;
		}
	}
	public static double getMinimumWage() {
		return minimumWage;
	}
	public static void setMinimumWage(double minimumWage) {
		Employee.minimumWage = minimumWage;
	}
	
	

}
