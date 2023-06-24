package com.fdmgroup.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>(Arrays.asList(4, 3, 7, 2, 5, 6, 7));
		
		System.out.println("======LinkedList======");
		while(queue.size() > 0) {
			System.out.println("Next item: " + queue.poll());
			System.out.println("queue contains " + queue.size() + " elements.");
		}
		
		Queue<Integer> priorityQueue = new PriorityQueue<>(Arrays.asList(4, 3, 7, 2, 5, 6, 7));
		
		System.out.println("\n======PriorityQueue======");
		while(priorityQueue.size() > 0) {
			System.out.println("Next item: " + priorityQueue.poll());
			System.out.println("queue contains " + priorityQueue.size() + " elements.");
		}
		
//		Queue<Product> products = new PriorityQueue<>();
//		Product product1 = new Product(1, "product1");
//		Product product2 = new Product(2, "product2");
//		
//		products.add(product1);
//		products.add(product2);
//		
//		while(products.size() > 0) {
//			products.poll();
//		}

	}

}
