package com.fdmgroup.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		Person person1 = new Person("John", "Smith", 17);
		Person person2 = new Person("Jane", "Jones", 25);
		Person person3 = new Person("Tom", "williams", 35);
		
		List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3));
		//List<Person> people = new ArrayList<>();
		
		people.stream();
		
		Person[] peopleArray = {person1, person2, person3};
		Arrays.stream(peopleArray);
		
		Predicate<Person> ageOver30 = 
				person -> person.getAge() > 30;
		
		people.stream().filter(ageOver30);

		Function<Person,Integer> ageOfPerson =
				person -> person.getAge();
				
		people.stream().map(ageOfPerson);
		
		people.stream().filter(ageOver30).map(ageOfPerson);
		
		long numberOfOver30s = people.stream().filter(ageOver30).count();
		
		System.out.println("Number of people aged over 30: " + numberOfOver30s);
		
		List<Integer> ages = people.stream().map(ageOfPerson).collect(Collectors.toList());
		
		ages.forEach(age -> System.out.println(age));
		
		
		Comparator<Integer> ageComparator =
				(age1, age2) -> age1 - age2;
		
		Optional<Integer> highestAge = people.stream()
			.map(person -> person.getAge())
			.max(ageComparator);
			
		highestAge.ifPresent(age -> System.out.println("Highest age is " + age));
		
		
		OptionalDouble averageAge =
				people.stream()
					.mapToInt(person -> person.getAge())
					.average();
		
		averageAge.ifPresent(age -> System.out.println("Average age is " + age));
		
		OptionalInt highestAge2 = people.stream()
				.mapToInt(person -> person.getAge())
				.max();
		
		highestAge2.ifPresent(age -> System.out.println("Highest age from highestAge2 is " + age));
		
	}

}
