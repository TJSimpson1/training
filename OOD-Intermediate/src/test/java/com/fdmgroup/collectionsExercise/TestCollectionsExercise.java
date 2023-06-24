package com.fdmgroup.collectionsExercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCollectionsExercise {
	
	CollectionsExercise exercise;

	@BeforeEach
	void setUp() throws Exception {
		exercise = new CollectionsExercise();
	}

	@Test
	void test_exercise1() {
		Set<String> uniqueNames = exercise.getUniqueNames("John", "Jane", "John"); //Act
		assertEquals(2, uniqueNames.size());
		assertTrue(uniqueNames.contains("John"));
		assertTrue(uniqueNames.contains("Jane"));
	}
	
	@Test
	void test_exercise2() {
		Map<String, Color> coloursMap = exercise.getPredefinedColourMap();
		assertEquals(Color.black, coloursMap.get("Black"));
		assertEquals(Color.magenta, coloursMap.get("Magenta"));
		assertEquals(Color.darkGray, coloursMap.get("Dark grey"));
		assertEquals(Color.white, coloursMap.get("White"));
	}
	
	@Test
	void test_countLetters_getHashSetWithTwoHsThreeEsTwoLsOneOOneTAndOneR_whenHelloTherePassedIn() {
		Map<Character, Integer> letterCount = exercise.countLetters("Hello there");
		assertEquals(2, letterCount.get('h'));
		assertEquals(3, letterCount.get('e'));
		assertEquals(2, letterCount.get('l'));
		assertEquals(1, letterCount.get('o'));
		assertEquals(1, letterCount.get('t'));
		assertEquals(1, letterCount.get('r'));
	}
	
	@Test
	void test_findDuplicateWords_getStringArrayWithTheAndBrown_whenThe_the_THE_dog_is_brown_BrOwN_PassedIn() {
		int duplicates = exercise.countDuplicateWords("The the THE dog is brown BROWN.");
		assertEquals(2, duplicates);
		
	}
	
	@Test
	void test_reverseLinkedList_getLinkedList4_3_2_1_when1_2_3_4PassedIn() {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
		List<Integer> reversedList = exercise.reverseLinkedList(list);
		
		assertEquals(4, reversedList.size());
		assertEquals(4, reversedList.get(0));
		assertEquals(3, reversedList.get(1));
		assertEquals(2, reversedList.get(2));
		assertEquals(1, reversedList.get(3));
		
	}
	
	@Test
	void test_reverseLinkedList_getLinkedList0_23_8_1_5_when5_1_8_23_0PassedIn() {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5, 1, 8, 23, 0));
		List<Integer> reversedList = exercise.reverseLinkedList(list);
		
		assertEquals(5, reversedList.size());
		assertEquals(0, reversedList.get(0));
		assertEquals(23, reversedList.get(1));
		assertEquals(8, reversedList.get(2));
		assertEquals(1, reversedList.get(3));
		assertEquals(5, reversedList.get(4));
		
	}
	
	@Test
	void test_tokenizeAndSort_get_brown_the_dog_when_The_brown_dog_PassedIn() {
		Set<String> stringList = exercise.tokenizeAndSort("The brown dog");
		
		assertEquals(3, stringList.size());
		assertTrue(stringList.contains("the"));
		assertTrue(stringList.contains("brown"));
		assertTrue(stringList.contains("dog"));
	}
	
	@Test
	void test_tokenizeAndSort_get_A_a_farm_is_not_zoo_when_A_zoo_is_not_a_farm_PassedIn() {
		Set<String> stringList = exercise.tokenizeAndSort("A zoo is not a farm.");
		
		assertEquals(5, stringList.size());
		assertTrue(stringList.contains("a"));
		assertTrue(stringList.contains("zoo"));
		assertTrue(stringList.contains("is"));
		assertTrue(stringList.contains("not"));
		assertTrue(stringList.contains("a"));
		assertTrue(stringList.contains("farm."));
	}

}
