package com.fdmgroup.inheritanceInterfaces;

public class Runner {

	public static void main(String[] args) {
		Tablet tablet = new Tablet();
		Speaker speaker = new Speaker();
		UsbCharger usbCharger = new UsbCharger(2.5);
		PortableLamp portableLamp = new PortableLamp();
		
		Mobile mobile = new Mobile();
		
		usbCharger.supplyPower(tablet);
		usbCharger.supplyPower(speaker);
		usbCharger.supplyPower(mobile);
		usbCharger.supplyPower(portableLamp);
		
		System.out.println(Chargeable.IMPEDANCE);
		
		System.out.println(Chargeable.calculateWatts(2, 2.25));
		
		tablet.connectToUsb();
		speaker.connectToUsb();
		mobile.connectToUsb();
		portableLamp.connectToUsb();
		
		portableLamp.produceLight();
		
		//Interfaces cannot be instantiated
		//Chargeable chargeable = new Chargeable();
		
		

	}

}
