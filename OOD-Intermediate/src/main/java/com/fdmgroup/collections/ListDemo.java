package com.fdmgroup.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 7, 2, 7, 3, 6));

		System.out.println("====== ArrayList ======");
		for (Integer number : list) {
			System.out.println(number);
		}

		List<Integer> linkedList = new LinkedList<>(Arrays.asList(4, 3, 7, 2, 7, 3, 6));

		System.out.println("====== LinkedList ======");
		for (Integer number : linkedList) {
			System.out.println(number);
		}
		
		List<Integer> vectorList = new Vector<>(Arrays.asList(4, 3, 7, 2, 7, 3, 6));

		System.out.println("====== Vector ======");
		for (Integer number : vectorList) {
			System.out.println(number);
		}

	}

}
