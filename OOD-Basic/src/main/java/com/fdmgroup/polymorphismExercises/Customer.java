package com.fdmgroup.polymorphismExercises;

public class Customer extends UserAccount {
	private static int minCustomerPasswordLength;

	public Customer(String username, String password, String fullName) {
		super(username, password, fullName);
	}

	@Override
	public void accessWebsite() {
		System.out.println("Accessing website as a customer");

	}
	
	@Override
	public boolean changePassword(String newPass, String confirmPass) {
		if(newPass.equals(confirmPass) && newPass.length() >= minCustomerPasswordLength) {
			super.changePassword(newPass, confirmPass);
			return true;
		} else {
			return false;
		}
		
	}

	public static int getMinCustomerPasswordLength() {
		return minCustomerPasswordLength;
	}

	public static void setMinCustomerPasswordLength(int minAdminPasswordLength) {
		Customer.minCustomerPasswordLength = minAdminPasswordLength;
	}
	
	

}
