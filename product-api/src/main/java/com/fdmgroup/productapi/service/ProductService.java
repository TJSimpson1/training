package com.fdmgroup.productapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.productapi.model.Product;
import com.fdmgroup.productapi.repository.ProductDAO;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}
	
	public Product createProduct(Product product) {
		Product savedProduct = productDAO.save(product);
		System.out.println("Product id "+savedProduct.getId()+" saved");
		return savedProduct;
	}
	
}
