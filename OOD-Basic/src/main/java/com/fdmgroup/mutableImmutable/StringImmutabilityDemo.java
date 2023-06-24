package com.fdmgroup.mutableImmutable;

public class StringImmutabilityDemo {

	public static void main(String[] args) {
		String string1 = "xyz";
		String string2 = string1;
		
		string1 = "abc";
		
		System.out.println(string1);
		System.out.println(string2);

	}

}
