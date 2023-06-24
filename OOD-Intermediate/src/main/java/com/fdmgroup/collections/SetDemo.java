package com.fdmgroup.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(3, 8, 200, 740, 8, 7, 12, 12)); //Unordered and unsorted but very quick at for .contains

		System.out.println("======HashSet======");
		for (Integer number : set) {
			System.out.println(number);
		}

		System.out.println(set.contains(200));
		System.out.println(set.contains(2414));

		Set<Integer> treeSet = new TreeSet<>(Arrays.asList(3, 8, 200, 740, 8, 7, 12, 12)); //Sorted but much slower than hashset for .contains

		System.out.println("\n======TreeSet======");
		for (Integer number : treeSet) {
			System.out.println(number);
		}

	}

}
