package com.fdmgroup.conditionals;

public class ConditionsDemo {

	public static void main(String[] args) {
		int num1 = 128;
		int num2 = 128;
		
		Integer num3 = 128;
		Integer num4 = 128;
		
		
		//To check equality of two values
		System.out.println(num1 == num2); // == works with primitives
		System.out.println(num3.equals(num4)); // .equals works with objects
		// == with objects checks if they're pointing at same area in memory
		
		//Checking non-equality
		System.out.println(num1 != num2);
		System.out.println(!num3.equals(num4));
		
		System.out.println("----Combining conditions-----");
		
		int number = 0;
		
		if(number >=1 && number <=10) {
			System.out.println("Valid number");
		} else {
			System.out.println("Invalid number");
		}
		
		if(number < 1 || number > 10) {
			System.out.println("Invalid number");
		} else {
			System.out.println("Valid number");
		}
	}

}
