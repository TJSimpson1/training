package com.fdmgroup.genericsExercise;

public class Book<T extends Number>extends Item<T> {

	public Book(T id, String name) {
		super(id, name);
	}

}
