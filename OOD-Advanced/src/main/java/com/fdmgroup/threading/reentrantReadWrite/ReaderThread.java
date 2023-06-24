package com.fdmgroup.threading.reentrantReadWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderThread extends Thread {

	private BankAccount bankAccount;
	
	public ReaderThread(BankAccount bankAccount) {
		super();
		this.bankAccount = bankAccount;
	}

	public void run() {
		ReentrantReadWriteLock readWriteLock = bankAccount.getLock();
		try {
			readWriteLock.readLock().lock();
			System.out.println(getName()+" accessing account, balance is "+bankAccount.getBalance());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println(getName()+" releasing lock");
			readWriteLock.readLock().unlock();
		}
		
		
		
	}
	
}
