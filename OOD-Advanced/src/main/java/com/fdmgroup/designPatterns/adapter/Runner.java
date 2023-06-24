package com.fdmgroup.designPatterns.adapter;

public class Runner {

	public static void main(String[] args) {
		ThreePinPlug threePinPlug = new ThreePinPlug();
		
		UKLaptop ukLaptop = new UKLaptop();
		ukLaptop.setPlug(threePinPlug);
		
		UKsocket ukSocket = new UKsocket();
		
//		ukLaptop.plugIn(ukSocket);

		
		EuropeanSocket europeanSocket = new EuropeanSocket();

//		ukLaptop.plugIn(europeanSocket);
		
		UKtoEUplugAdapter adapter = new UKtoEUplugAdapter(europeanSocket);
		
		ukLaptop.plugIn(adapter);
		
	}

}
