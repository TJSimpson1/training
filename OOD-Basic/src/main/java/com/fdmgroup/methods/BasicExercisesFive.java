package com.fdmgroup.methods;

public class BasicExercisesFive {

	public static void main(String[] args) {
		int points = getPoints("blue");
		System.out.println("You've scored " + points + " points!");
		
		long total = sumOfNumbersUpTo(100);
		System.out.println(total);
		
		displayTimesTable(15);

	}
	
	public static int getPoints(String alienColour) {
		if(alienColour.equals("green")) {
			return 5;
		}
		
		else if(alienColour.equals("red")) {
			return 10;
		}
		else if(alienColour.equals("yellow")) {
			return 15;
		}else {
			return 0;
		}
	}
	
	public static long sumOfNumbersUpTo(int number) {
		long sum = 0L;
		for(int count = 1; count <= number; count++) {
			sum += count;
		}
		return sum;
	}
	
	public static void displayTimesTable(int number) {
		for(int count = 1; count <= 12; count++) {
			System.out.println(count + " x " + number + " = " + count*number);
		}
	}
	

}
