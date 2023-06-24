package com.fdmgroup.inheritanceExercises;

import java.util.ArrayList;
import java.util.List;

public class UserAccountManager {
	private List<UserAccount> userAccounts = new ArrayList<UserAccount>();
	
	public void addUser(UserAccount user) {
		userAccounts.add(user);
	}
	
	public boolean login(String username, String password) {
		for(UserAccount userAccount : userAccounts) {
			if(userAccount.getUsername().equals(username) && userAccount.getPassword().equals(password)) {
				System.out.println("Logged in as " + userAccount.getUsername());
				return true;
			}
		}
		System.out.println("Invalid credentials.");
		return false;
	}
	

}
