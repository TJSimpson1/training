package com.fdmgroup.lambdas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapMergeDemo {

	public static void main(String[] args) {
		Map<Product, Integer> productsInStock = new HashMap<>();
		
		Product product1 = new Product(1, "Product1");
		Product product2 = new Product(2, "Product2");
		Product product3 = new Product(2, "Product3");
		
//		productsInStock.put(product1, 50);
//		productsInStock.put(product2, 300);
//		productsInStock.put(product3, 20);
//		productsInStock.put(product1,  30);
		
		BiFunction<Integer, Integer, Integer> remappingFunction =
		(currentAmount, amountToAdd) -> currentAmount + amountToAdd;

		productsInStock.merge(product1, 50, remappingFunction);
		productsInStock.merge(product2, 300, remappingFunction);
		productsInStock.merge(product3, 20, remappingFunction);
		productsInStock.merge(product1, 30, remappingFunction);
		
		for(Product product : productsInStock.keySet()) {
			System.out.println(product.getName() + ": " + productsInStock.get(product));
		}

	}

}











