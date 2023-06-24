package com.fdmgroup.generics;

import java.util.ArrayList;
import java.util.List;

//T is a placeholder for a data type, and not a data type itself.
public class Basket<T> {
	List<T> items = new ArrayList<>();
	
	public List<T> getItemsInBasket(){
		return items;
	}
	
	public void addItem(T item) {
		items.add(item);
	}

}
