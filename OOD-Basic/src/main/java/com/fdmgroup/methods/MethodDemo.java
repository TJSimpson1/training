package com.fdmgroup.methods;

public class MethodDemo {

	public static void main(String[] args) {
		int length1 = 583;
		int length2 = 371;
		int longestLength = getLargestNumber(length1,length2);
		printLargestNumber(length1,length2);
		
		
		System.out.println("Longest length is " + longestLength);
		
		int speed1 = 75;
		int speed2 = 150;
		int fastestSpeed = getLargestNumber(speed1,speed2);
		printLargestNumber(speed1,speed2);
		
		
		System.out.println("fastest speed is " + fastestSpeed);
		
		//printNumbers(2,4);
		printNumbers(24,3,5,71,1,8);

	}
	
	/* 1) public - access modifier - visible to all the project
	 * 2) static - to be covered on static module (most methods not static)
	 * 3) int - return type - what type of data we're getting back when called
	 * 4) getLargestNumber - method name - use to call method when needed
	 * 5) int num1, int num2 - method arguments - input(s) required by method
	*/
	
	public static int getLargestNumber(int num1, int num2) {
		if(num1>num2) {
			return num1;
		}
		return num2;
	}
	
	public static void printLargestNumber(int num1, int num2) {
		if(num1>num2) {
			System.out.println("Largest number is " + num1);
		} else {
			System.out.println("Largest number is " + num2);
		}
	}
	
	public static void printNumbers(int ...numbers) {
		for(int eachNumber : numbers) {
			System.out.println(eachNumber);
		}
	}
	
	
	

}
