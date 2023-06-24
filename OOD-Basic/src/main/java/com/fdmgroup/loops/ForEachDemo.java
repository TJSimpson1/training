package com.fdmgroup.loops;

import java.util.ArrayList;
import java.util.List;

public class ForEachDemo {

	public static void main(String[] args) {
		//double[] prices = {1.99, 2.50, 3.70, 7.25};
		
		List<Double> prices = new ArrayList<Double>();
		prices.add(2.50);
		prices.add(9.99);
		prices.add(2.50);
		prices.add(3.95);
		prices.add(2.50);
		prices.add(7.50);
		prices.add(2.50);
		prices.add(2.50);
		
		for(double eachPrice : prices) {
			System.out.println(eachPrice);
		}
		
		

	}

}
