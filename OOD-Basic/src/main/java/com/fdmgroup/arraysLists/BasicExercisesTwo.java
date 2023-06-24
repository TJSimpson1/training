package com.fdmgroup.arraysLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicExercisesTwo {
	
	public int removeDuplicates(int[] nums) {
	    int i = nums.length > 0 ? 1 : 0;
	    for (int n : nums)
	        if (n > nums[i-1])
	            nums[i++] = n;
	    return i;
	}

	public static void main(String[] args) {
		//Section 1 - Arrays =============================================
		
		String[] bestFriends = {"Holly", "Ed", "Matt", "Jord", "Joe"};
		
		System.out.println(bestFriends.length);
		System.out.println(bestFriends[0]);
		System.out.println(bestFriends[1]);
		System.out.println(bestFriends[2]);
		System.out.println(bestFriends[3]);
		System.out.println(bestFriends[4]);
		System.out.println("-----");
		bestFriends[4] = "Gus";
		Arrays.sort(bestFriends);
		System.out.println(bestFriends[0]);
		System.out.println(bestFriends[4]);
		bestFriends[1] = null;
		
		String[] pokerHand = new String[5];
		pokerHand[0] = "Queen of hearts";
		pokerHand[1] = "3 of spades";
		pokerHand[2] = "3 of diamonds";
		pokerHand[3] = "9 of hearts";
		pokerHand[4] = "6 of clubs";
		
		//Section 2 - ArrayLists
		System.out.println("\n");
		
		
		List<String> shoppingBasket = new ArrayList<String>();
		shoppingBasket.add("milk");
		shoppingBasket.add("cereals");
		shoppingBasket.add("apples");
		shoppingBasket.add("oranges");
		shoppingBasket.add("bread");
		
		System.out.println(shoppingBasket.size());
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(4));
		
		shoppingBasket.remove("bread");
		System.out.println(shoppingBasket.size());
		shoppingBasket.remove(2);
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(1));
		System.out.println(shoppingBasket.get(2));
		
		shoppingBasket.add("potatoes");
		shoppingBasket.add("olive oil");
		shoppingBasket.add("chicken");
		
		Collections.sort(shoppingBasket);
		System.out.println(shoppingBasket.get(0));
		System.out.println(shoppingBasket.get(5));
		
		
		List<Integer> salaries = new ArrayList<Integer>();
		salaries.add(75000);
		salaries.add(25000);
		salaries.add(42000);
		salaries.add(30000);
		salaries.add(55000);
		salaries.add(42000);
		salaries.add(39000);
		
		System.out.println(Collections.max(salaries));
		System.out.println(Collections.min(salaries));
		System.out.println(Collections.frequency(salaries, 42000));
		
		Collections.sort(salaries);
		System.out.println(salaries.get(3));
		Collections.reverse(salaries);
		System.out.println(salaries.get(0));
		System.out.println(salaries.get(6));
		

	}

}
