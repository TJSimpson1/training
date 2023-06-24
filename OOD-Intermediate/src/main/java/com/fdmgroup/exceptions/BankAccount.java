package com.fdmgroup.exceptions;

public class BankAccount {
	private double balance;
	
	public void withdraw(double amount) throws BankAccountException {
		if(amount < 0) {
			throw new BankAccountException("Cannot withdraw a negative amount");
		}
		balance -= amount;
	}
	
	public void addFunds(double amount) throws BankAccountException {
		//bad code to deliberately throw a runtime exception.
//		String string = null;
//		System.out.println(string.length());
		if(amount < 0) {
			throw new BankAccountException("Cannot deposit a negative amount");
		}
		balance += amount;
	}
	
	public double getBalance() {
		return balance;
	}

}
