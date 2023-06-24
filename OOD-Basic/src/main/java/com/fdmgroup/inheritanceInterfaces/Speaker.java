package com.fdmgroup.inheritanceInterfaces;

public class Speaker implements Chargeable {

	public void charge(double amps) {
		System.out.println("Speaker is charging with " + amps + " amps.");
	}
	
	public void makeSound() {
		System.out.println("Speaker is making sound");
	}

}
