package com.fdmgroup.threading;

public class Runner2 {

	public static void main(String[] args) {
		System.out.println("Main method starting.");
		MyRunnableClass runnable1 = new MyRunnableClass();
		MyRunnableClass runnable2 = new MyRunnableClass();
		
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		
		Thread thread3 = new Thread(() -> {
			System.out.println("Running thread 3.");
		});
		
		thread1.setName("Thread 1");
		thread2.setName("Thread 2");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main method ending.");

	}

}
