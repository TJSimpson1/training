package com.fdmgroup.dependenciesExercises;


public class Runner1 {

	public static void main(String[] args) {
		HardDrive hardDrive1 = new HardDrive("Seagate", 2048);
		HardDrive hardDrive2 = new HardDrive("Dell", 3072);
		Processor processor1 = new Processor("Intel Xeon",2.93,6);
		Processor processor2 = new Processor("Intel Celeron",2.9,2);
		Memory memory1 = new Memory("Kingston", 4, 1600);
		Memory memory2 = new Memory("Corsair", 8, 1333);
		
		PowerSource powerSource = new PowerSource();
		powerSource.setWatts(50);
		
		
		Computer computer1 = new Computer("Dell", hardDrive1, memory1, processor1);
		Computer computer2 = new Computer("Lenovo", hardDrive2, memory2, processor2);
		
		computer1.getPower(powerSource);
		
		ComputerStore computerStore = new ComputerStore("PC World");
		computerStore.addComputer(computer1);
		computerStore.addComputer(computer2);
		
		//System.out.println(computerStore.getAllComputers().contains(computer2));
		for(Computer computer : computerStore.getAllComputers()) {
			System.out.println(computer.getMODEL());
		}
		//computer1.turnOn();

	}

}
