package com.fdmgroup.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Map<Product, Integer> productsInStock = new HashMap<>();
		
		Product product1 = new Product(1, "product1");
		Product product2 = new Product(2, "product2");
		Product product3 = new Product(3, "product3");
		
		productsInStock.put(product1, 50);
		productsInStock.put(product2, 300);
		productsInStock.put(product3, 20);
		
		productsInStock.put(product1, 12); //Duplicate keys just override key's associated value
		
		for(Product eachProduct : productsInStock.keySet()) {
			System.out.println(eachProduct.getName() + ": " + productsInStock.get(eachProduct));
		}

	}

}
