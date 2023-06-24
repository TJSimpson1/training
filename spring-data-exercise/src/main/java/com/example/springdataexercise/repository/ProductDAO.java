package com.example.springdataexercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springdataexercise.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	List<Product> findBySupplierIgnoreCase(String supplier);
	
	List<Product> findByMakeIgnoreCase(String make);
	
	@Query("SELECT p FROM Product p WHERE p.price <= :price")
	List<Product> findByPriceLessThan(@Param("price") double price);
}
