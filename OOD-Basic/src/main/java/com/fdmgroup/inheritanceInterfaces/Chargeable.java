package com.fdmgroup.inheritanceInterfaces;

public interface Chargeable {
	//Only public, static, and final attributes allowed in interfaces, so only constants and NO variables
	final double IMPEDANCE = 15;
	
	//Methods in interfaces are abstract by default
	//Methods are implicitly public (unless otherwise specified)
	void charge(double amps);
	
	static double calculateWatts(int volts, double amps) {
		return volts * amps;
	}
	
	default void connectToUsb() {
		System.out.println("Connecting to USB.");
	}
	
}
