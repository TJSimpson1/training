package com.fdmgroup.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.productapi.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
