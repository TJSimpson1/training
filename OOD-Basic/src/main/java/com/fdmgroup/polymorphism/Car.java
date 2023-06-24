package com.fdmgroup.polymorphism;

public class Car extends Vehicle {
	
	@Override //Checks that accelerate is overriding a method in Vehicle (compile error if not, essentially spell check)
	public void accelerate() {
		System.out.println("Car acceleration.");
	}
	
//	public void accelerate(int speedLimit) {
//		System.out.println("Car is accelerating. Max speed is " + speedLimit);
//	}
	
	public void accelerate(double hillGradient) {
		System.out.println("Car is accelerating. Hill gradient is " + hillGradient);
	}
	
	public void accelerate(int speedLimit, String weather) {}
	
	public void accelerate(String weather, int speedLimit) {}
	
	public void accelerate(byte speedLimit) {
		System.out.println("Byte");
	}
	
	public void accelerate(short speedLimit) {
		System.out.println("Short");
	}
	
	public void accelerate(long speedLimit) {
		System.out.println("Long");
	}
	
	@Override
	public void setMaxSpeed(int maxSpeed) {
		if(maxSpeed <= 100) {
			super.setMaxSpeed(maxSpeed);
		} else {
			super.setMaxSpeed(100);
		}
	}
}
