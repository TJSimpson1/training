package com.fdmgroup.collectionsExercise;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsExercise {

	public Set<String> getUniqueNames(String ...names) {
//		Set<String> uniqueNames = new HashSet<>();
//		for(String eachName : names) {
//			uniqueNames.add(eachName);
//		}
//		return uniqueNames;
		return new HashSet<String>(Arrays.asList(names));
	}

	public Map<String, Color> getPredefinedColourMap() {
		Map<String, Color> colourMap = new HashMap<>();
		colourMap.put("Black", Color.black);
		colourMap.put("Blue", Color.blue);
		colourMap.put("Cyan", Color.cyan);
		colourMap.put("Dark grey", Color.darkGray);
		colourMap.put("Grey", Color.gray);
		colourMap.put("Green", Color.green);
		colourMap.put("Light grey", Color.lightGray);
		colourMap.put("Magenta", Color.magenta);
		colourMap.put("Orange", Color.orange);
		colourMap.put("Pink", Color.pink);
		colourMap.put("Red", Color.red);
		colourMap.put("White", Color.white);
		colourMap.put("Yellow", Color.yellow);
		return colourMap;
	}

	public Map<Character, Integer> countLetters(String string) {
		string = string.toLowerCase();
		char[] stringArray = string.toCharArray();
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for(char eachChar : stringArray) {
			if(countMap.keySet().contains(eachChar)) {
				countMap.put(eachChar, countMap.get(eachChar) + 1);
			} else {
				countMap.put(eachChar, 1);
			}
		}
		return countMap;
	}

	public int countDuplicateWords(String string) {
		List<String> stringList = new ArrayList<>();
		Set<String> duplicateSet = new HashSet<>();
		
		string = string.replaceAll("[^a-zA-Z]", " "); //Removes non letters
		string = string.replaceAll("( )+", " "); //Removes duplicate spaces
		string = string.toLowerCase();
		String[] stringArray = string.split(" ");
		
		for(String eachString : stringArray) {
			if(stringList.contains(eachString)) {
				duplicateSet.add(eachString);
			} else {
				stringList.add(eachString);
			}
			
		}
		return duplicateSet.size();
	}

	public LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
//		List<Integer> reversedList = new LinkedList<>();
//		for(int index = list.size() - 1; index >= 0; index--) {
//			reversedList.add(list.get(index));
//		}
		LinkedList<Integer> reversed = new LinkedList<Integer>(list);
		Collections.reverse(reversed);
		return reversed;
	}

	public Set<String> tokenizeAndSort(String string) {
		Set<String> tokenizedList = new TreeSet<>();
		String[] stringList = string.split(" ");
		for(String eachString : stringList) {
			tokenizedList.add(eachString.toLowerCase());
		}
		return tokenizedList;
	}
	
	
	
	

}
