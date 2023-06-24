package com.fdmgroup.dependenciesExercises;

public class Computer {
	private final String MODEL;
	private HardDrive hardDrive;
	private Memory memory;
	private final Processor PROCESSOR;
	
	public Computer(String mODEL, HardDrive hardDrive, Memory memory, Processor pROCESSOR) {
		super();
		MODEL = mODEL;
		this.hardDrive = hardDrive;
		this.memory = memory;
		PROCESSOR = pROCESSOR;
	}
	
	public void turnOn() {
		System.out.println("Turning on "+MODEL);
	}
	
	public void turnOff() {
		System.out.println("Turning off "+MODEL);
	}
	
	public void getPower(PowerSource powerSource) {
		double watts = powerSource.supplyPower();
		System.out.println(watts + " watts received from power source");
	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public void setHardDrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public String getMODEL() {
		return MODEL;
	}

	public Processor getPROCESSOR() {
		return PROCESSOR;
	}
	
	
	
	
	
	
	

}
