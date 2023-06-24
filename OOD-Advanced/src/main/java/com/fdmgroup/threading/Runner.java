package com.fdmgroup.threading;

public class Runner {

	public static void main(String[] args) {
//		Thread thread1 = new Thread();
//		Thread thread2 = new Thread();
//		
//		thread1.start();
//		thread2.start();
		
		System.out.println("Main method starting.");
		
		MyThreadClass thread1 = new MyThreadClass();
		MyThreadClass thread2 = new MyThreadClass();
		
		Thread backgroundProcess = new Thread(() -> {
			while(true) {
				System.out.println("Running background process...");
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					break; //Takes us out of the loop and terminates the thread
				}
			}
		});
		
		thread1.setName("Thread 1");
		thread2.setName("Thread 2");
		
		thread1.start();
		thread2.start();
		backgroundProcess.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		backgroundProcess.interrupt();
		
		System.out.println("Main method ending.");

	}

}
