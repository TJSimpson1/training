package com.fdmgroup.casting;

public class Car extends Vehicle {
	private double engineSize;

	public Car(double engineSize) {
		super();
		this.engineSize = engineSize;
	}
	
	@Override
	public void accelerate() {
		System.out.println("Car acceleration.");
	}

	public double getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(double engineSize) {
		this.engineSize = engineSize;
	}
	
	

}
