package com.fdmgroup.castingExercises;

import java.util.ArrayList;
import java.util.List;

public class CalorieCounter {
	ArrayList<FoodItem> lowCalorieFoods = new ArrayList<FoodItem>();
	
	public void addLowCalorieFood(FoodItem foodItem) {
		if(foodItem.getCalories() <= 500) {
			lowCalorieFoods.add(foodItem);
		}
	}
	
	public ArrayList<FoodItem> getAllLowCalorieFoods() {
		return lowCalorieFoods;
	}
	
	public void removeHighCalorieFoodsFromBasket(Basket basket, int calories) {
		ArrayList<BasketItem> highCalorieList = new ArrayList<BasketItem>();
		for(BasketItem eachItem : basket.getAllItems()) {
			if(eachItem instanceof FoodItem && ((FoodItem) eachItem).getCalories() > calories) {
				highCalorieList.add(eachItem);
			}
		}
//		basket.getAllItems().removeAll(highCalorieList);
		for(BasketItem highCalorieFood : highCalorieList) {
			basket.removeItem(highCalorieFood);
		}
	}

}
