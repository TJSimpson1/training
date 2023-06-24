package com.fdmgroup.genericsExercise;

import java.util.ArrayList;
import java.util.List;

public class Catalog<T extends Item<V>, V extends Number> {
	private List<T> items = new ArrayList<>();
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public T findItem(V id) {
		for(T eachItem : items) {
			V itemId = eachItem.getId();
			if(itemId.equals(id)) {
				return eachItem;
			}
		}
		return null;
	}
}
