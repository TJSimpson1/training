package com.fdmgroup.designPatterns.adapter;

public class UKLaptop implements IUKelectronicDevice {

	ThreePinPlug plug;
	
	public void setPlug(ThreePinPlug plug) {
		this.plug = plug;
	}

	public void plugIn(IUKsocket socket) {
		String power = socket.supplyPower(plug);
		System.out.println("UK Laptop: "+power);
	}

}
