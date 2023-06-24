package com.fdmgroup.designPatterns.singleton;

public class Runner {

	public static void main(String[] args) {
		PrintSpooler printSpooler1 = PrintSpooler.getInstance();
		PrintSpooler printSpooler2 = PrintSpooler.getInstance();
		PrintSpooler printSpooler3 = PrintSpooler.getInstance();
		
		printSpooler1.addToQueue(new PrintJob(1));
		printSpooler2.addToQueue(new PrintJob(2));

		printSpooler3.printNextJob();
		printSpooler3.printNextJob();
	
	}
}
