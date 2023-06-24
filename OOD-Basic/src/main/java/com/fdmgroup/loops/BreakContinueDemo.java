package com.fdmgroup.loops;

import java.util.Scanner;

public class BreakContinueDemo {

	public static void main(String[] args) {
		String oldPassword = "old password";
		String password = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter a new password with at least 6 characters");
			password = scanner.nextLine();
			
			if(password.equals(oldPassword)) {
				System.out.println("New password must be different to old password");
				continue;
			}
			
			if(password.length() >= 6) {
				break;
			}
			
			System.out.println("password too short");
		}
		
		System.out.println("Your new password is: " + password);
	}

}