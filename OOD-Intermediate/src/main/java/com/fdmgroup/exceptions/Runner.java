package com.fdmgroup.exceptions;

public class Runner {

	public static void main(String[] args) {
		runCode();

	}
	
	public static void runCode() {
		BankAccount bankAccount = new BankAccount();
		try {
			bankAccount.addFunds(-100);
			System.out.println("Funds added successfully");
		} catch (BankAccountException e) {
			System.out.println("Running code to handle the problem");
			e.printStackTrace();
		} finally {
			System.out.println("Running the code in the finally block"); //Code always runs, even with runtime exceptions
		}
		
		System.out.println("Balance is: £" + bankAccount.getBalance());
	}

}
