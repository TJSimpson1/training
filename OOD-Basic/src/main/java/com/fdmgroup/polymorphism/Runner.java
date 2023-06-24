package com.fdmgroup.polymorphism;

public class Runner {

	public static void main(String[] args) {
		Car car = new Car();
		Plane plane = new Plane();
		
		car.accelerate();
		plane.accelerate();
		
		car.setMaxSpeed(100000);
		System.out.println("Car's max speed is " + car.getMaxSpeed() + "mph");
		
		car.accelerate(30);
		car.accelerate(20.0);

	}

}
