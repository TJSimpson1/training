package com.fdmgroup.classesAndObjectsExercises;

public class Processor {
	//Attributes
	private final String MODEL;
	private final double SPEED;
	private final int NUMBER_OF_CORES;

	//Constructors
	public Processor(String model, double speed, int numberOfCores) {
		super();
		MODEL = model;
		SPEED = speed;
		NUMBER_OF_CORES = numberOfCores;
	}
	
	//Behaviours
	public void processData(String data) {
		System.out.println("processData: " + data);
	}

	//Getters and Setters
	public String getMODEL() {
		return MODEL;
	}

	public double getSPEED() {
		return SPEED;
	}

	public int getNUMBER_OF_CORES() {
		return NUMBER_OF_CORES;
	}
	
	
	
	
	
	

}
