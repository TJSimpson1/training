package com.fdmgroup.threading;

public class MyThreadClass extends Thread {
	public void run() {
		System.out.println(getName() + " starting.");
		for(int num = 1; num <= 100; num++) {
			System.out.println(getName() + ": " + num);
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " ending.");
	}

}
