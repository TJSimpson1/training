package com.fdmgroup.mutableImmutable;

public class StringBuilderMutabilityDemo {

	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = sb1;
		
		System.out.println(sb1);
		System.out.println(sb2);
		
		sb1.append('d');
		
		System.out.println(sb1);
		System.out.println(sb2);

	}

}
