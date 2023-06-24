package com.fdmgroup.inheritanceInterfaces;

public class Tablet implements Chargeable {

	public void charge(double amps) {
		System.out.println("Tablet is charging with " + amps + " amps.");

	}

	public void displayApp() {
		System.out.println("Tablet is displaying app");
	}
	
}
