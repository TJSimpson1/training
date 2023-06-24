package com.fdmgroup.castingExercises;

public class Snack implements BasketItem, FoodItem {
	private String name;
	private double price;
	private int calories;
	private int fatContent;
	private int sugarContent;
	
	
	public Snack(String name, double price, int calories, int fatContent, int sugarContent) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.fatContent = fatContent;
		this.sugarContent = sugarContent;
	}

	@Override
	public int getCalories() {
		return calories;
	}

	@Override
	public void setCalories(int calories) {
		this.calories = calories;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	public int getFatContent() {
		return fatContent;
	}

	public void setFatContent(int fatContent) {
		this.fatContent = fatContent;
	}

	public int getSugarContent() {
		return sugarContent;
	}

	public void setSugarContent(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	
	

}
