package com.fdmgroup.polymorphism;

public class Runner2 {

	public static void main(String[] args) {
		Trainee trainee1 = new Trainee("John", "Java", 7);
		Trainee trainee2 = new Trainee("John", "Java", 7);
				
		System.out.println(trainee1 == trainee2);
		System.out.println(trainee1.equals(trainee2));
		
		System.out.println(trainee1.hashCode());
		System.out.println(trainee2.hashCode());
		
		System.out.println(trainee1);
	}

}
