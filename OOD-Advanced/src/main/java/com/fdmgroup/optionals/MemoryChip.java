package com.fdmgroup.optionals;

public class MemoryChip {
	private String model;

	public MemoryChip(String model) {
		super();
		this.model = model;
	}
	
	public void accessData() {
		System.out.println(model + " accessing data");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}
