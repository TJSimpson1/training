package com.fdmgroup.designPatterns.adapter;

public class UKsocket implements IUKsocket {

	public String supplyPower(ThreePinPlug plug) {
		return "power supplied from UK socket";
	}

}
