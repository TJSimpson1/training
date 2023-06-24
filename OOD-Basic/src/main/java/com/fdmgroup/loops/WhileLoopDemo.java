package com.fdmgroup.loops;

import java.util.Scanner;

public class WhileLoopDemo {

	public static void main(String[] args) {
		String password = "";
		Scanner scanner = new Scanner(System.in);
		
		while(password.length() < 6) {
			System.out.println("Enter a new password of at least 6 characters");
			password = scanner.nextLine();
		}
		
		System.out.println("Your new password is: " + password);

	}

}