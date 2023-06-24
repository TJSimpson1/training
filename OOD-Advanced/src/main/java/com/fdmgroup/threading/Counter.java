package com.fdmgroup.threading;

public class Counter {
	private int count;
	
	public synchronized void increment() {
		count++;
	}
	
	public synchronized void decrement() {
		count--;
	}
	
	public synchronized int getCount() {
		return count;
	}

}
