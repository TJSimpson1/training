package com.fdmgroup.threading;

public class RaceConditionDemo {

	public static void main(String[] args) {
		Counter counter = new Counter();
		
		Thread incrementThread = new Thread(() -> {
			for(int num = 1; num <= 1_000_000; num++) {
				counter.increment();
			}
		});
		
		Thread decrementThread = new Thread(() -> {
			for(int num = 1; num <= 950_000; num++) {
				counter.decrement();
			}
		});
		
		incrementThread.start();
		decrementThread.start();
		
		try {
			incrementThread.join();
			decrementThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total: " + counter.getCount());

	}

}
