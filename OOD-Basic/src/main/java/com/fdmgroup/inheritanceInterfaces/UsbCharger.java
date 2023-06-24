package com.fdmgroup.inheritanceInterfaces;

public class UsbCharger {
	private double amps;

	public UsbCharger(double amps) {
		super();
		this.amps = amps;
	}
	
	public void supplyPower(Chargeable chargeable) {
		chargeable.charge(amps);
	}

	public double getAmps() {
		return amps;
	}

	public void setAmps(double amps) {
		this.amps = amps;
	}
	
	

}
