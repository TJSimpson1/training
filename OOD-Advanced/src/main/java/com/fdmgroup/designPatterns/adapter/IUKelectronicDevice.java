package com.fdmgroup.designPatterns.adapter;

public interface IUKelectronicDevice {

	public void plugIn(IUKsocket socket);
	
	public void setPlug(ThreePinPlug plug); 
	
}
