package com.fdmgroup.threading;

public class MyRunnableClass implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " starting.");
		for(int num = 1; num <= 100; num++) {
			System.out.println(Thread.currentThread().getName() + ": " + num);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " ending.");
	}
	

}
