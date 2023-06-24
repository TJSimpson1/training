package com.fdmgroup.memoryHandling;

public class PassBySecondDemo {

	public static void main(String[] args) {
		Person person1 = new Person("Travis", 22);
		
		changeDetails(person1, "John", 50);
		
		System.out.println(person1.getName() + ": " + person1.getAge());

	}
	
	public static void changeDetails(Person somePerson, String name, int age) {
		somePerson = new Person(name, age);
//		somePerson.setName(name);
//		somePerson.setAge(age);
	}

}
