package com.fdmgroup.casting;

public class Plane extends Vehicle {
	private int wingLength;

	public Plane(int wingLength) {
		super();
		this.wingLength = wingLength;
	}

	public int getWingLength() {
		return wingLength;
	}

	public void setWingLength(int wingLength) {
		this.wingLength = wingLength;
	}
	
	

}
