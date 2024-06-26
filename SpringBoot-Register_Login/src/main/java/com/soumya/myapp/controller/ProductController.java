package com.soumya.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soumya.myapp.entity.Product;
import com.soumya.myapp.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveProduct(@ModelAttribute Product product){
		
		this.productService.addProduct(product);
		return "product-Success";
	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getAddProductPage(Model model){
		
		model.addAttribute("products", this.productService.getAllProducts_Admin());
		return "Product";
	}

}
