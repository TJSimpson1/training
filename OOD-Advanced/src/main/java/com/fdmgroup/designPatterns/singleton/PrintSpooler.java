package com.fdmgroup.designPatterns.singleton;

import java.util.LinkedList;
import java.util.Queue;

public class PrintSpooler {
	private static PrintSpooler printSpooler;
	private Queue<PrintJob> printQueue = new LinkedList<>();
	
	private PrintSpooler() {}
	
	public static PrintSpooler getInstance() {
		if(printSpooler == null) {
			printSpooler = new PrintSpooler();
		}
		return printSpooler;	
	}
	
	public void addToQueue(PrintJob printJob) {
		printQueue.add(printJob);
	}
	
	public void printNextJob() {
		System.out.println("Printing Job: " + printQueue.poll().getId());
	}
}
