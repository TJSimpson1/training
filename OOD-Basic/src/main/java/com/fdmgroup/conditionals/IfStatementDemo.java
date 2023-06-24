package com.fdmgroup.conditionals;

public class IfStatementDemo {

	public static void main(String[] args) {
		int priceOfPhone = 520;
		
		if(priceOfPhone < 150) {
			System.out.println("Phone is cheap");
		} else if(priceOfPhone < 500) {
			System.out.println("Phone is average");
		} else {
			System.out.println("Phone is not cheap");
		}

	}

}
