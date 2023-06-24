package com.fdmgroup.loops;

public class ForDemo {

	public static void main(String[] args) {
//		for(int count = 1; count <= 10; count++) {
//			System.out.println(count);
//		}
		
//		for(int count = 10; count >= 1; count--) {
//			System.out.println(count);
//		}
		
//		for(int count = 10; count >= 1; count -= 2) {
//			System.out.println(count);
//		}
		
//		for(char letter = 'a'; letter <= 'z'; letter++) {
//			System.out.print(letter);
//		}
		
		double[] prices = {1.99, 2.50, 3.70, 7.25};
		
		for(int index = prices.length-1; index >= 0; index--) {
			System.out.println(prices[index]);
		}

	}

}
