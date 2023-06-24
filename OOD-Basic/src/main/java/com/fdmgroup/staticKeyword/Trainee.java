package com.fdmgroup.staticKeyword;

public class Trainee {
	private String name;
	private final int id;
	private static int numberOfTrainees;
	
	public Trainee() {
		numberOfTrainees = getNumberOfTrainees() + 1;
		id = numberOfTrainees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNumberOfTrainees() {
		return numberOfTrainees;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
