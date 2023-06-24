package com.fdmgroup.polymorphismExercises;

public class AdminUser extends UserAccount {
	private static int minAdminPasswordLength;

	public AdminUser(String username, String password, String fullName) {
		super(username, password, fullName);
	}
	
	@Override
	public boolean changePassword(String newPass, String confirmPass) {
		if(newPass.length() >= minAdminPasswordLength) {
			super.changePassword(newPass, confirmPass);
			return true;
		} else {
			System.out.println("Password not long enough");
			return false;
		}
		
	}
	
	public boolean changePassword(String newPass, String confirmPass, UserAccount userAccount) {
		return userAccount.changePassword(newPass, confirmPass);
	}

	@Override
	public void accessWebsite() {
		System.out.println("Accessing website as an admin");

	}

	public static int getMinAdminPasswordLength() {
		return minAdminPasswordLength;
	}

	public static void setMinAdminPasswordLength(int minAdminPasswordLength) {
		AdminUser.minAdminPasswordLength = minAdminPasswordLength;
	}
	
	

}
