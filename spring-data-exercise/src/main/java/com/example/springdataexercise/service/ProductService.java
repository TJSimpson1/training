package com.example.springdataexercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdataexercise.model.Product;
import com.example.springdataexercise.repository.ProductDAO;

@Service
public class ProductService {
	
	private ProductDAO productDAO;

	@Autowired
	public ProductService(ProductDAO productDAO) {
		super();
		this.productDAO = productDAO;
	}
	
	public Product addProduct(Product product) {
		if(product.getPrice() >= 0 && ! productDAO.existsById(product.getId())) {
			return productDAO.save(product);
		}
		return null;
	}
	
	public Product getProduct(int id) {
		Optional<Product> optionalProduct = productDAO.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Product updateProduct(Product product) {
		if(product.getPrice() >= 0 && productDAO.existsById(product.getId())) {
			productDAO.save(product);
			return product;
		}
		return null;
	}
	
	public void deleteProduct(int id) {
		productDAO.deleteById(id);
	}
	
	public List<Product> listProducts(){
		return productDAO.findAll();
	}
	
	public List<Product> listBySupplier(String supplier){
		return productDAO.findBySupplierIgnoreCase(supplier);
	}
	
	public List<Product> listByMake(String make){
		return productDAO.findByMakeIgnoreCase(make);
	}
	
	public List<Product> listByMaxPrice(double price){
		return productDAO.findByPriceLessThan(price);
	}
	
	
}
