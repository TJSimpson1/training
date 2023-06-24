package com.fdmgroup.dataTypes;

public class WrapperDemo {

	public static void main(String[] args) {
		Integer num1 = 7;
		int num2 = 8;
		
		String num3 = "7";
		String num4 = "8";
		
		//System.out.println(num3 + num4);
		
		int number3 = Integer.parseInt(num3);
		int number4 = Integer.parseInt(num4);
		
		//System.out.println(number3 + number4);
		
		char character1 = 'a';
		char character2 = '2';
		
		System.out.println(Character.isDigit(character2));
		System.out.println(Character.isLetter(character2));

	}

}
