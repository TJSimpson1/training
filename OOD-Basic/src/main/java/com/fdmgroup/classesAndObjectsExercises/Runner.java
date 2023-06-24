package com.fdmgroup.classesAndObjectsExercises;

public class Runner {

	public static void main(String[] args) {
		//Creating objects
		HardDrive drive1 = new HardDrive("Seagate", 2048);
		HardDrive drive2 = new HardDrive("Dell", 3072);
		Processor processor1 = new Processor("Intel Xeon",2.93,6);
		Processor processor2 = new Processor("Intel Celeron",2.9,2);
		Memory memory1 = new Memory("Kingston", 4, 1600);
		Memory memory2 = new Memory("Corsair", 8, 1333);
		
		//Inputting using Setters
		drive1.setUsedSpace(0.0); //Not necessary as 0.0 is default value anyway
		drive2.setUsedSpace(500.0);
		
		//Outputting all data
//		System.out.println(drive1.getMODEL());
//		System.out.println(drive1.getCAPACITY());
//		System.out.println(drive1.getUsedSpace());
//		System.out.println(drive2.getMODEL());
//		System.out.println(drive2.getCAPACITY());
//		System.out.println(drive2.getUsedSpace());
//		
//		System.out.println(processor1.getMODEL());
//		System.out.println(processor1.getNUMBER_OF_CORES());
//		System.out.println(processor1.getSPEED());
//		System.out.println(processor2.getMODEL());
//		System.out.println(processor2.getNUMBER_OF_CORES());
//		System.out.println(processor2.getSPEED());
//		
//		System.out.println(memory1.getMODEL());
//		System.out.println(memory1.getCAPACITY());
//		System.out.println(memory1.getSPEED());
//		System.out.println(memory2.getMODEL());
//		System.out.println(memory2.getCAPACITY());
//		System.out.println(memory2.getSPEED());
		
		drive1.setUsedSpace(50);
		
		System.out.println(drive1.getUsedSpace());
		
		//System.out.println(drive1.readData("file"));

	}

}
