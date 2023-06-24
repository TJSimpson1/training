package com.fdmgroup.loops;

import java.util.ArrayList;
import java.util.Collections;

public class BasicExercisesFour {

	public static void main(String[] args) {
		
		//Section 1 - For Each Loops =====================================
		
		String[] courses = {"UNIX", "SQL", "Java", "Python", "Web Apps"};
		for(String eachCourse : courses) {
			System.out.println("I love learning " + eachCourse);
		}
		
		ArrayList<String> coursesList = new ArrayList<String>();
		for(String eachCourse : courses) {
			coursesList.add(eachCourse);
		}
		
		for(String eachCourse : coursesList) {
			System.out.println(eachCourse);
		}
		
		ArrayList<Double> prices = new ArrayList<Double>();
		prices.add(4.50);
		prices.add(1.99);
		prices.add(9.75);
		prices.add(3.15);
		prices.add(10.25);
		double totalPrice = 0;
		for(double eachPrice : prices) {
			totalPrice += eachPrice;
		}
		System.out.println(totalPrice);
		
		double[] pricesArray = new double[5];
		int index = 0;
		for(double eachPrice : prices) {
			pricesArray[index] = eachPrice;
			//System.out.println(pricesArray[index]);
			index++;
		}
		
		String text = "10,7,25,3,8";
		String[] numbers = text.split(",");
		int totalSum = 0;
		for(String eachNumber : numbers) {
			totalSum += Integer.parseInt(eachNumber);
		}
		System.out.println(totalSum);
		
		String string = "desrever neeb sah txet sihT";
		String reversed = "";
		char[] letters = string.toCharArray();
		for(char eachLetter : letters) {
			reversed = eachLetter + reversed;
		}
		System.out.println(reversed);
		
		
		//Section 2 - For Loops ============================================
		
		
//		for(int count = 1; count <= 1000000; count++) {
//			System.out.println(count);
//		}
		
		long sum = 0L;
		for(int count = 1; count <= 1000000; count++) {
			sum += count;
		}
		System.out.println(sum);
		
		for(int odd = 1; odd <=20; odd += 2) {
			System.out.println(odd);
		}
		
		for(int count = 1; count <= 12; count++) {
			System.out.println(count + " x 3 = " + count*3);
		}
		
		int[] scores = {25,15,99,75,47,59,82};
		for(int index1 = 1; index1 < scores.length; index1 += 2) {
			scores[index1]++;
		}
		for(int eachScore : scores) {
			System.out.println(eachScore);
		}
		
		for(char letter = 'b'; letter <= 'z'; letter += 2) {
			System.out.print(letter);
		}
		
		for(int multiple2 = 2; multiple2 <= 12; multiple2++) {
			System.out.println("\n"+multiple2 + " times table:");
			for(int multiple1 = 1; multiple1 <= 12; multiple1++) {
				System.out.println(multiple1 + "x" + multiple2 + " = " + multiple1*multiple2);
			}
		}
		
		
		//Section 3 - While Loops ===============================================
		
		
//		int count = 1;
//		while(count <= 1000000) {
//			System.out.println(count);
//			count++;
//		}
		
		char alph = 'a';
		while(alph <= 'z') {
			System.out.print(alph);
			alph++;
		}
		
		System.out.println();
		
		int fibonacci1 = 0;
		int fibonacci2 = 1;
		while(fibonacci1 <= 1000) {
			System.out.println(fibonacci1);
			int fibonacciPlaceholder = fibonacci1;
			fibonacci1 = fibonacci2;
			fibonacci2 += fibonacciPlaceholder;
		}
		
		
		//Section 4 - Controlling a Loop with an if Statement ==============
		
		
		String[] cities = {"Glasgow", "London", "Birmingham", 
				"Cardiff", "Manchester", "Newcastle"};
		for(String eachCity : cities) {
			if(eachCity.charAt(0) == 'B') {
				System.out.println(eachCity + " - match");
				break;
			}
			System.out.println(eachCity + " - doesn't match");
		}
		
		int[] numbers1 = {6,15,75,32,89,24,103,17,5,250,63,91};
		for(int eachNumber : numbers1) {
			if(eachNumber>100) {
				System.out.println(eachNumber);
				break;
			}
		}
		
	}

}
