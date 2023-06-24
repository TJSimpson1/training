package com.example.springdataexercise.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springdataexercise.model.Product;
import com.example.springdataexercise.service.ProductService;



@Controller
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/add-product")
	public String displayAddProduct(Model model, @ModelAttribute Product product) {
		model.addAttribute("product", new Product());
		
		if (product != null) {
			model.addAttribute("product", product);
		}
			
		return "addproduct";
	}
	
	@GetMapping("/show-products")
	public String displayShowProducts(Model model) {
		model.addAttribute("products", productService.listProducts());
//		productService.listProducts().forEach(eachProduct -> System.out.println(eachProduct.getName()));
		return "showProducts";
	}
	
	@PostMapping("process")
	public String handleProcess(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
		System.out.println("Processing " + product.getName());
		if (productService.addProduct(product)==null) {
			System.out.println("Failed to add product");
			redirectAttributes.addFlashAttribute("product", product);
			redirectAttributes.addFlashAttribute("errorMessage", "ID not unique or price negative");
			return "redirect:/add-product";
		}
		System.out.println("Successfully added product");
		return "confirmation";
	}
	
	@GetMapping("delete-product")
	public String handleDeleteProduct(@RequestParam("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/show-products";
		
	}
	
	@GetMapping("edit-product")
	public String displayEditProduct(Model model, @RequestParam("id") int id, @ModelAttribute Product product) {
		model.addAttribute("product", productService.getProduct(id));
		return "editProduct";
	}
	
	@PostMapping("submit-edit-product")
	public String handleSubmitEditProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
		productService.updateProduct(product);
		return "redirect:/show-products";
	}
	
	@PostMapping("search-by-supplier")
	public String handleSearchBySupplier(Model model, @RequestParam("supplier") String supplier) {
		model.addAttribute("products", productService.listBySupplier(supplier));
		return "showProducts";
	}
	
	@PostMapping("search-by-make")
	public String handleSearchByMake(Model model, @RequestParam("make") String make) {
		model.addAttribute("products", productService.listByMake(make));
		return "showProducts";
	}
	
	@PostMapping("search-by-max-price")
	public String handleSearchByMaxPrice(Model model, @RequestParam("price") double price) {
		model.addAttribute("products", productService.listByMaxPrice(price));
		return "showProducts";
	}
	
}
