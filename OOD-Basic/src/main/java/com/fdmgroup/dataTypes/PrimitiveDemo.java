package com.fdmgroup.dataTypes;

public class PrimitiveDemo {

	public static void main(String[] args) {
		// This is a single line comment
		/* 
		 * 1) byte -> data type -> defines the type of variable
		 * 2) score -> reference name -> what we use to refer back to the value held by that variable
		 * 3) 100 -> value associated to the score variable
		 */
		byte score = 100;
		/*
		 * Can also do:
		 * byte score;
		 * 
		 * score=100;
		 */
		//System.out.println(score);
		
		short matchAttendance = 25000;
		int populationOfChina = 1500000000;
		long populationOfTheWorld = 6000000000L;
		
		float price = 1.99F;
		double anotherPrice = 2.50;
		
		boolean isCorrect = false;
		
		// Must use single quotation marks '' for char
		char letter1 = 'a';
		char letter2 = 'b';
		
		System.out.println((char) (letter1 + letter2));
		System.out.println((int) letter1);
		System.out.println((int) letter2);
		System.out.println((char) 99);
	}

}
