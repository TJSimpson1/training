package com.fdmgroup.memoryHandling;

public class PassByDemo {
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		
		System.out.println("before we swap x is " + x + " and y is " + y);
		swap(x, y);
		System.out.println("after the swap x is " + x + " and y is " + y);
	}

	public static void swap(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
}
