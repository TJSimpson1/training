package com.fdmgroup.generics;

import java.util.ArrayList;
import java.util.List;

public class Basket2 {
	List<Toy> toys = new ArrayList<>();
	
	public List<Toy> getToysInBasket(){
		return toys;
	}
	
	public void addBook(Toy toy) {
		toys.add(toy);
	}

}
