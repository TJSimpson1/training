package com.fdmgroup.threading.reentrantReadWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BankAccount {
	private double balance;
	
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public ReentrantReadWriteLock getLock() {
		return lock;
	}
	
	
}
