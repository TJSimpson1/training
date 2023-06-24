package com.fdmgroup.inheritanceExercises;

public class AdminUser extends UserAccount {

	public AdminUser(String username, String password, String fullName) {
		super(username, password, fullName);
	}

	@Override
	public void accessWebsite() {
		System.out.println("Accessing website as an admin");

	}

}
