package com.fdmgroup.arraysLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Only works with object types.
		List<Double> prices = new ArrayList<Double>();
		prices.add(2.50);
		prices.add(9.99);
		prices.add(2.50);
		prices.add(3.95);
		prices.add(2.50);
		prices.add(7.50);
		prices.add(2.50);
		prices.add(2.50);
		
		System.out.println("Number of items is: " + prices.size());
		
		System.out.println("Printing values individually.");
		
		System.out.println(prices.get(0));
		System.out.println(prices.get(1));
		System.out.println(prices.get(2));
		System.out.println(prices.get(3));
		System.out.println(prices.get(4));
		System.out.println(prices.get(5));
		System.out.println(prices.get(6));
		System.out.println(prices.get(7));
		
		prices.remove(2.50);
		System.out.println("Number of items is: " + prices.size());
		//Removes first occurence

		//prices.removeAll(2.50);
		
		prices.remove(5);
		System.out.println("Number of items is: " + prices.size());
		//Removes 5th element
		
		//If list is full of integers, .remove will remove by index, not by
		// int values inside!
		
		System.out.println("My list contains 2.50: " +prices.contains(2.50));
		System.out.println("My list contains 99.99: " +prices.contains(99.99));
		
		Collections.sort(prices);
		System.out.println("Printing values individually after sorting.");
		System.out.println(prices.get(0));
		System.out.println(prices.get(1));
		System.out.println(prices.get(2));
		System.out.println(prices.get(3));
		System.out.println(prices.get(4));
		System.out.println(prices.get(5));
		
		Collections.reverse(prices);
		System.out.println("Printing values individually after reversing.");
		System.out.println(prices.get(0));
		System.out.println(prices.get(1));
		System.out.println(prices.get(2));
		System.out.println(prices.get(3));
		System.out.println(prices.get(4));
		System.out.println(prices.get(5));
		//Note this just reverses, not sorting!
		
		System.out.println("The highest value is: "+ Collections.max(prices));
		System.out.println("The lowest value is: "+ Collections.min(prices));
		
		System.out.println("2.50 occurs " + Collections.frequency(prices, 2.50) + " times");
	}

}
