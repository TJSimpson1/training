package com.fdmgroup.interfacesExercises;

public class Runner {

	public static void main(String[] args) {
		Toy toy = new Toy("Lego", 10.99, 3, 8);
		Laptop laptop = new Laptop("Lenovo", 799.99, 50, 1000, 2.5);
		Snack snack1 = new Snack("Apple", 0.50, 100, 0, 5);
		Snack snack2 = new Snack("Chocolate bar", 0.90, 600, 15, 80);
		ReadyMeal readyMeal1 = new ReadyMeal("Curry", 2.50, 400, "Indian");
		ReadyMeal readyMeal2 = new ReadyMeal("Pizza", 3.99, 800, "Italian");
		Basket basket = new Basket();
		CalorieCounter calorieCounter = new CalorieCounter();
		
		basket.addItem(toy);
		basket.addItem(laptop);
		basket.addItem(snack1);
		basket.addItem(snack2);
		basket.addItem(readyMeal1);
		basket.addItem(readyMeal2);
		
		for(BasketItem eachItem : basket.getAllItems()) {
			System.out.println(eachItem.getName());
		}
		
		basket.removeItem(laptop);
		System.out.println("-------");
		
		for(BasketItem eachItem : basket.getAllItems()) {
			System.out.println(eachItem.getName());
		}
		
		calorieCounter.addLowCalorieFood(snack1);
		calorieCounter.addLowCalorieFood(snack2);
		calorieCounter.addLowCalorieFood(readyMeal1);
		calorieCounter.addLowCalorieFood(readyMeal2);
		
		//calorieCounter.addLowCalorieFood(toy); Error as toy does not implement FoodItem. Same for laptop.
		
		for(FoodItem lowCalorieFood : calorieCounter.getAllLowCalorieFoods()) {
			System.out.println(lowCalorieFood.getCalories());
		}
		

	}

}
