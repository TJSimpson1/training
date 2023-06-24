package com.fdmgroup.designPatterns.adapter;

public class UKtoEUplugAdapter implements IUKsocket{

	IEuropeanSocket socket;
	TwoPinPlug twoPinPlug = new TwoPinPlug();
	
	public UKtoEUplugAdapter(IEuropeanSocket socket){
		this.socket = socket;
	}
	
	public String supplyPower(ThreePinPlug plug) {
		return socket.supplyPower(twoPinPlug);
	}

}
