package com.fdmgroup.classesAndObjectsExercises;

public class Memory {
	//Attributes
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	private final double SPEED;
	
	//Constructors
	public Memory(String model, double capacity, double speed) {
		super();
		this.MODEL = model;
		this.CAPACITY = capacity;
		this.SPEED = speed;
	}
	
	public void storeData(String data) {
		System.out.println("storeData: " + data);
	}

	public double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(double usedSpace) {
		this.usedSpace = usedSpace;
	}

	public String getMODEL() {
		return MODEL;
	}

	public double getCAPACITY() {
		return CAPACITY;
	}

	public double getSPEED() {
		return SPEED;
	}
	
	

}
