package com.fdmgroup.interfacesExercises;

import java.util.ArrayList;

public class Basket {
	ArrayList<BasketItem> basketItems = new ArrayList<BasketItem>();
	
	public void addItem(BasketItem basketItem) {
		basketItems.add(basketItem);
	}
	
	public void removeItem(BasketItem basketItem) {
		if(basketItems.contains(basketItem)) {
			basketItems.remove(basketItem);
		}
	}
	
	public ArrayList<BasketItem> getAllItems() {
		return basketItems;
	}

}
