package com.fdmgroup.optionals;

import java.util.Optional;

public class Motherboard {
	private String model;
	private MemoryChip memoryChip;
	public Motherboard(String model) {
		super();
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Optional<MemoryChip> getMemoryChip() {
		return Optional.ofNullable(memoryChip);
	}
	public void setMemoryChip(MemoryChip memoryChip) {
		this.memoryChip = memoryChip;
	}
	
	

}
