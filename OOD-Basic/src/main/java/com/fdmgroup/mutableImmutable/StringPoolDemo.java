package com.fdmgroup.mutableImmutable;

public class StringPoolDemo {

	public static void main(String[] args) {
		String string1 = "xyz";
		String string2 = "xyz"; //Points to the same memory as string1 (String Pool)
		
		System.out.println(string1 == string2);
		
		String string3 = new String("xyz"); //Forces Java to create string in new memory
		
		System.out.println(string1 == string3);
	
		Integer number1 = 128;
		Integer number2 = 128; //False as out of the [-128,127] range
		
		System.out.println(number1 == number2);

	}

}
