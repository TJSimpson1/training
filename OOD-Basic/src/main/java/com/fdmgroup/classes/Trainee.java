package com.fdmgroup.classes;

public class Trainee {
	//Attributes - what a trainee is
	private final String NAME;
	private String stream;
	private int week;
	
	//Constructors don't have a return type
	//Constructor's name matches with name of class
	public Trainee(String name, String stream, int week) {
		super();
		this.NAME = name;
		this.stream = stream;
		if(week >=1 && week <= 15) {
			this.week = week;
		}else {
			this.week = 1;
		}
	}

	//Behaviours - what a trainee does
	public void learn() {
		System.out.println(NAME + " is learning " + stream +", they are on week " + week);
	}
	
	public int takeExam(String topic) {
		System.out.println(NAME + " is taking " + topic + " exam");
		return (int) (Math.random() * 100);
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		if(week >=1 && week <= 15) {
			this.week = week;
		}else {
			this.week = 1;
		}
	}

	public String getNAME() {
		return NAME;
	}


	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}
	
	
	
	

}
