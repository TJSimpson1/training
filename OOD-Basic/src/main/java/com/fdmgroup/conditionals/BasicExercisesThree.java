package com.fdmgroup.conditionals;

public class BasicExercisesThree {

	public static void main(String[] args) {
		
		//Section 1 - Simple if Statements =================================
		
		String alienColour = "red";
		if(alienColour == "green") {
			System.out.println("5 points");
		}
		
		else if(alienColour == "red") {
			System.out.println("10 points");
		}
		else if(alienColour == "yellow") {
			System.out.println("15 points");
		}else {
			System.out.println("Invalid colour");
		}
		
		int age = 23;
		if(age<2) {
			System.out.println("Baby");
		}
		else if(age < 4) {
			System.out.println("Toddler");
		}
		else if(age < 13) {
			System.out.println("Child");
		} 
		else if(age < 20) {
			System.out.println("Teenager");
		}
		else if(age < 65) {
			System.out.println("Adult");
		}
		else {
			System.out.println("Pensioner");
		}
		
		
		int salary = 85000;
		if(salary > 150000) {
			System.out.println("45%");
		}
		else if(salary > 50000) {
			System.out.println("40%");
		}
		else if(salary > 12500) {
			System.out.println("20%");
		}
		else {
			System.out.println("0%");
		}
		
		
		//Section 2 - More Complicated Conditions =========================
		
		
		int accountNumber = 16523468;
		if(accountNumber >= 10000000 && accountNumber <100000000) {
			System.out.println("Valid account number");
		} else {
			System.out.println("Invalid account number");
		}
		
		String flightCode = "PQ1234";
		
		String airlineCode = flightCode.substring(0, 2);
		
		if (airlineCode.equals("BA")){
			System.out.println("British Airways");
		} else {
			System.out.println("not British Airways");
		}

		if (!airlineCode.equals("BA") && 
			!airlineCode.equals("LH") &&
			!airlineCode.equals("FR")){
			System.out.println("invalid airline");
		} 

		boolean validPassport = false;
		boolean validDrivingLicence = false;
		
		if(validPassport || validDrivingLicence) {
			System.out.println("ID verified");
		} else {
			System.out.println("Unable to verify ID");
		}
		
		boolean hasLicence = true;
		boolean isDead = false;
		boolean hasPassedEyeTest = true;
		if(hasLicence && !isDead && hasPassedEyeTest) {
			System.out.println("Can still drive");
		} else {
			System.out.println("Not licenced to drive");
		}
		
	}

}
