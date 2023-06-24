package com.fdmgroup.loops;

import java.util.Scanner;

public class DoWhileDemo {

	public static void main(String[] args) {
		String password = "old password";
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Enter a new password of at least six characters");
			password = scanner.nextLine();
		} while (password.length() < 6);
			
		System.out.println("Your new password is " + password);
	}

}