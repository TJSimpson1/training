package com.fdmgroup.arraysLists;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayDemo {

	public static void main(String[] args) {
		//double price = 1.99;
		double[] prices = {1.99, 2.50, 3.70, 7.25};
		Double[] pricesWrapper = {5.50, 2.99};
		
		
		System.out.println(prices.length);
		System.out.println(pricesWrapper.length);
		// prices.length is not a method but an attribute 
		// methods have () brackets after
		
		System.out.println("Printing values of arrays individually.");
		System.out.println(prices[0]);
		System.out.println(prices[1]);
		System.out.println(prices[2]);
		System.out.println(prices[3]);
		
		//Changing individual value from array
		prices[0] = 4.30;
		System.out.println("Printing values of arrays individually after change.");
		System.out.println(prices[0]);
		System.out.println(prices[1]);
		System.out.println(prices[2]);
		System.out.println(prices[3]);
		
		Double[] morePrices = new Double[6];
		System.out.println("All values from morePrices: ");
		System.out.println(morePrices[0]);
		System.out.println(morePrices[1]);
		System.out.println(morePrices[2]);
		System.out.println(morePrices[3]);
		System.out.println(morePrices[4]);
		System.out.println(morePrices[5]);
		
		String sentence = "This is a sentence.";
		
		String[] words = sentence.split(" ");
		
		System.out.println(words[0]);
		System.out.println(words[1]);
		System.out.println(words[2]);
		System.out.println(words[3]);
		
		Arrays.sort(prices);
		System.out.println("Printing values of arrays individually after sorting.");
		System.out.println(prices[0]);
		System.out.println(prices[1]);
		System.out.println(prices[2]);
		System.out.println(prices[3]);
		
		char[][] board = {{'8','3','.','.','7','.','.','.','.'}
						,{'6','.','.','1','9','5','.','.','.'}
						,{'.','9','8','.','.','.','.','6','.'}
						,{'5','.','.','.','6','.','.','.','3'}
						,{'4','.','.','8','.','.','.','.','1'}
						,{'7','.','.','.','2','.','.','.','6'}
						,{'.','6','.','.','.','.','2','8','.'}
						,{'.','.','.','4','1','9','.','.','5'}
						,{'.','.','.','.','8','.','.','7','9'}};
		
		for(int i = 0; i<9; i++){
	        HashSet<Character> rows = new HashSet<Character>();
	        HashSet<Character> columns = new HashSet<Character>();
	        HashSet<Character> cube = new HashSet<Character>();
	        for (int j = 0; j < 9;j++){
	            if(board[i][j]!='.' && !rows.add(board[i][j])) {
	                System.out.println(false);
	            	break;
	            }
	            if(board[j][i]!='.' && !columns.add(board[j][i])) {
	            	System.out.println(false);
            		break;
	            }
	            int RowIndex = 3*(i/3);
	            int ColIndex = 3*(i%3);
	            int ColIndex2 = ColIndex + j%3;
	            System.out.println((RowIndex + j/3 + ", " + ColIndex2));
	            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3])) {
	            	System.out.println(false);
            		break;
	            }
	        }
	    }

	}

}
