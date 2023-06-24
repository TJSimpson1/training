package com.fdmgroup.inheritanceInterfaces;

public class PortableLamp implements Chargeable, Lamp {

	@Override
	public void produceLight() {
		System.out.println("Portable lamp is producing light");

	}

	@Override
	public void charge(double amps) {
		System.out.println("Portable lamp is charging with " + amps + " amps");

	}

}
