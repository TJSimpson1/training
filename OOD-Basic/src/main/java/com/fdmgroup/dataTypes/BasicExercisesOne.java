package com.fdmgroup.dataTypes;

public class BasicExercisesOne {

	public static void main(String[] args) {
		
		//Section 1 - Strings =================================================================
		
		String message = "This is an example message.";
		System.out.println(message);
		
		String firstName = "Travis";
		String secondName = "Simpson";
		String fullName = firstName + " " + secondName;
		System.out.println(fullName);
		
		System.out.println("Hello " + firstName + ", would you like to learn some Java today?");
		
		System.out.println(firstName.length());
		System.out.println(firstName.toUpperCase());
		System.out.println(firstName.charAt(0));
		System.out.println(firstName.charAt(firstName.length()-1));
		
		String sentence = "this is a sentence";
		
		System.out.println(sentence.indexOf(' '));
		System.out.println(sentence.lastIndexOf(' '));
		System.out.println(sentence.indexOf('x'));
		System.out.println(sentence.substring(0, 4));
		System.out.println(sentence.substring(10));
		System.out.println(sentence.substring(5, 9));
		System.out.println(sentence.contains("a"));
		System.out.println(sentence.contains("x"));
		System.out.println("is ".concat(sentence).concat("?"));
		System.out.println(sentence.replaceFirst("t", "T"));
		
		
		//Section 2 - Primitives =============================================================
		
		int favouriteNumber = 45;
		System.out.println("\nMy favourite number is " + favouriteNumber);
		
		int int1 = 5;
		int int2 = 3;
		System.out.println(int1 + int2);
		
		int counter = 0;
		counter++;
		counter += 5;
		counter--;
		counter -= 2;
		counter *= 2;
		System.out.println(counter);
		
		int a = 5;
		int b = 2;
		double c = 5;
		double d = 2;
		
		System.out.println(a/b);
		System.out.println(c/d);
		System.out.println(c/b);
		System.out.println(a/d);
		
		// int/int yields an int result which will be rounded down
		// Java converts int to double when both are used in an operation
		
		
		//Section 3 - char =================================================================
		
		char letter = 'a';
		int code = 98;
		
		System.out.println("\n" + (int) letter);
		System.out.println((char) code);
		System.out.println((char) 36);
		
		System.out.println('c' - 'a');
		System.out.println('z' - 'a');
		
		char char1 = 'x';
		char char2 = 'y';
		char char3 = 'z';
		String string1 = "z";
		String string2 = "y";
		System.out.println(char1 + char2 + char3);
		System.out.println(char1 + char2 + string2);
		System.out.println(char1 + string1 + char3);
		
		//Adding 2 consecutive chars gives the sum of their Unicode values. 
		//Adding a char and a String creates a new String containing the characters from both.
		
		
		//Section 4 - Wrappers ================================================================
		System.out.println("\n");
		
		String number1 = "5";
		String number2 = "3";
		int1 = Integer.parseInt(number1);
		int2 = Integer.parseInt(number2);
		System.out.println(int1 + int2);
		
		number1 = "5.3";
		number2 = "3.2";
		double double1 = Double.parseDouble(number1);
		double double2 = Double.parseDouble(number2);
		System.out.println(double1 + double2);
		
		string1 = "abc11";
		string2 = "9xyz";
		String string3 = "abc7xyz";
		
		String string1Digits = string1.substring(3);
		String string2Digits = string2.substring(0, 1);
		String string3Digits = string3.substring(3,4);
		
		int num1 = Integer.parseInt(string1Digits);
		int num2 = Integer.parseInt(string2Digits);
		int num3 = Integer.parseInt(string3Digits);
		System.out.println(num1 + num2 + num3);
		
	}

}
