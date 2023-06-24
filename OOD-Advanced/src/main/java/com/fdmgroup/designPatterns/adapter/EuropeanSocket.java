package com.fdmgroup.designPatterns.adapter;

public class EuropeanSocket implements IEuropeanSocket {

	public String supplyPower(TwoPinPlug plug) {
		
		return "power supplied from european socket";
	}

}
