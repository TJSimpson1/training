package com.fdmgroup.classesAndObjectsExercises;

public class HardDrive {
	//Attributes
	private final String MODEL;
	private final double CAPACITY;
	private double usedSpace;
	
	//Constructors
	public HardDrive(String model, double capacity) {
		super();
		this.MODEL = model;
		if(capacity>0) {
			this.CAPACITY = capacity;
		}else {
			this.CAPACITY=0;
		}
	}
	
	//Behaviours
	public String readData(String file) {
		return "data from "+file;
	}
	
	public void writeData(String data, String file) {
		System.out.println("writeData: " + data + ", " + file);
	}

	//Getters & Setters
	public double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(double usedSpace) {
		if(usedSpace > 0) {
			this.usedSpace = usedSpace;
		}else {
			this.usedSpace=0;
		}
	}

	public String getMODEL() {
		return MODEL;
	}

	public double getCAPACITY() {
		return CAPACITY;
	}
	

	
	

	
}
