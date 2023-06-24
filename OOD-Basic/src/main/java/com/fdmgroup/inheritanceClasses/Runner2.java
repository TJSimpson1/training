package com.fdmgroup.inheritanceClasses;

import java.util.ArrayList;
import java.util.List;

public class Runner2 {

	public static void main(String[] args) {
		//Vehicle vehicle = new Vehicle(); can't instantiate abstract class
		Car car = new Car();
		Plane plane = new Plane();
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(car);
		vehicles.add(plane);
		
		for(Vehicle vehicle : vehicles) {
			vehicle.accelerate();
		}

	}

}
