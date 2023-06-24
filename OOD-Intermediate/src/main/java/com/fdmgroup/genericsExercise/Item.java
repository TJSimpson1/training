package com.fdmgroup.genericsExercise;

public abstract class Item<T extends Number> {
	
	private T id;
	private String name;
	
	public Item(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
