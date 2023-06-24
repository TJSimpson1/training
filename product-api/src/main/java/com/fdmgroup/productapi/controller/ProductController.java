package com.fdmgroup.productapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.productapi.model.Product;
import com.fdmgroup.productapi.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins="http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	private List<Product> listProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product createdProduct = productService.createProduct(product);
		
		if (createdProduct != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{username}")
					.buildAndExpand(createdProduct.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
}
