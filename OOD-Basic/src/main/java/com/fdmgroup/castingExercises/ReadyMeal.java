package com.fdmgroup.castingExercises;

public class ReadyMeal implements BasketItem, FoodItem {
	private String name;
	private double price;
	private int calories;
	private String cuisineType;

	public ReadyMeal(String name, double price, int calories, String cuisineType) {
		super();
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.cuisineType = cuisineType;
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

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	
	
	

}
