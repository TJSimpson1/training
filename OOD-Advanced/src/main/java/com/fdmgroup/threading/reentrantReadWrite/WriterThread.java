package com.fdmgroup.threading.reentrantReadWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriterThread extends Thread {

	private BankAccount bankAccount;
	private double amountToAdd;

	public WriterThread(BankAccount bankAccount, double amountToAdd) {
		super();
		this.bankAccount = bankAccount;
		this.amountToAdd = amountToAdd;
	}
	
	public void run() {
		ReentrantReadWriteLock readWriteLock = bankAccount.getLock();
		
		try {
			readWriteLock.writeLock().lock();
			System.out.println(getName()+" is adding "+amountToAdd+" to the balance");
			bankAccount.setBalance(bankAccount.getBalance()+amountToAdd);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println(getName()+" releasing lock");
			readWriteLock.writeLock().unlock();
		}
	}
	
	
	
}
