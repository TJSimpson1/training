package com.fdmgroup.casting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		Car car = new Car(1.6);
		Plane plane = new Plane(5);
		
		Vehicle vehicle = car;
		//vehicle.accelerate();
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>(Arrays.asList(car, plane));
		
		for(Vehicle eachVehicle : vehicles) {
			if(eachVehicle instanceof Car) {
				Car downcastCar = (Car) eachVehicle;
				System.out.println("Engine size: " + downcastCar.getEngineSize());
			} else {
				Plane downcastPlane = (Plane) eachVehicle;
				System.out.println("Wing length: " + downcastPlane.getWingLength());
			}
			
		}
		
//		Car downcastCar = (Car) vehicle;
//		System.out.println("car engine size: " + downcastCar.getEngineSize());

	}

}
