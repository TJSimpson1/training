package com.fdmgroup.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Runner {

	public static void main(String[] args) {
		Person person1 = new Person("Edgar", "Afonso", 17);
		Person person2 = new Person("John", "Doe", 35);
		Person person3 = new Person("Jane", "Doe", 35);

		List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3));

//		String person1FullName = getFullNameMethod(person1);
//		String person2FullName = getFullNameMethod(person2);
//		
//		System.out.println(person1FullName);
//		System.out.println(person2FullName);

		System.out.println("=====Function=====");

		Function<Person, String> getFullName = person -> person.getFirstName() + " " + person.getLastName();

		String person1Name = getFullName.apply(person1);

		System.out.println(person1Name);

		System.out.println("=====BiFunction=====");

		BiFunction<Person, Integer, Integer> yearsToRetirement = (person, retirementAge) -> retirementAge
				- person.getAge();

		int person1Years = yearsToRetirement.apply(person1, 65);
		System.out.println(person1.getFirstName() + " has to work for " + person1Years + " years until retirement");

		System.out.println("=====Predicate=====");

		Predicate<Person> oldEnoughToVote = person -> person.getAge() >= 18;

		boolean person1OldEnoughToVote = oldEnoughToVote.test(person1);
		System.out.println(person1OldEnoughToVote ? person1.getFirstName() + " is old enough to vote"
				: person1.getFirstName() + " is too young to vote");

		System.out.println("=====Consumer=====");// Essentially void method

		Consumer<Person> printFirstName = person -> System.out.println(person.getFirstName());

		printFirstName.accept(person1);
		printFirstName.accept(person2);

		System.out.println("=====BinaryOperator=====");

		BinaryOperator<Person> getOldestPerson = (personOne,
				personTwo) -> personOne.getAge() > personTwo.getAge() ? personOne : personTwo;

		Person oldestPerson = getOldestPerson.apply(person1, person2);
		System.out.println(oldestPerson.getFirstName());

		System.out.println("==========================");
		System.out.println("==========Part 2==========");
		System.out.println("==========================");
		
		System.out.println("\n =====Testing Java 8's forEach method passing in a Consumer=====");
		people.forEach(printFirstName);
		people.forEach(person -> System.out.println(person.getFirstName()));
		
		System.out.println("=====Testing Java 8's removeIf method passing in a predicate=====");
		//people.removeIf(oldEnoughToVote.negate());
		people.forEach(printFirstName);
		
		System.out.println("=====Testing Java 8's sort method passing in a Comparator=====");
		Comparator<Person> sortByFirstName =
				(personOne, personTwo) -> personOne.getFirstName().compareTo(personTwo.getFirstName());
				
		people.sort(sortByFirstName);
		people.forEach(person -> System.out.println(person.getFirstName()));
		
		System.out.println("=====Combining Lambda Expressions=====");
		System.out.println("=====Combining Predicates=====");
		Predicate<Person> over25 =
				person -> person.getAge() > 25;
				
		Predicate<Person> jName =
				person -> person.getFirstName().charAt(0) == 'J';
		
		Predicate<Person> over25AndNameStartsWithJ = over25.and(jName);
		//people.removeIf(over25AndNameStartsWithJ);
		people.forEach(printFirstName);
		
		System.out.println("=====Combining Comparators=====");
		Comparator<Person> sortByAge =
				(personOne,personTwo) -> personOne.getAge() - personTwo.getAge();
				
		Comparator<Person> sortByName =
				(personOne, personTwo) -> personOne.getFirstName().compareTo(personTwo.getFirstName());
				
		Comparator<Person> sortByAgeThenName =
				sortByAge.thenComparing(sortByName);
		
		people.sort(sortByAgeThenName);
		people.forEach(person -> System.out.println(person.getFirstName() + ": " + person.getAge()));
				

	}

	public static String getFullNameMethod(Person person) {
		return person.getFirstName() + " " + person.getLastName();
	}

}
