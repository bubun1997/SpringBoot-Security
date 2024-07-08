package com.soumya.myapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumya.myapp.entity.Product;
import com.soumya.myapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		
		return this.productRepository.save(product);
	}
	
    public List<Product> getAllProducts_Customer() {
    	
    	List<Product> products = productRepository.
                			     findAll().
                			     stream().
                			     filter( product -> 
                			     			product.getProductQuantity() >= 1).
                			     collect(Collectors.toList());

		
		return products;
	}
    
    public List<Product> getAllProducts_Admin() {
    	
    	System.err.println(productRepository.findAll());
    	return productRepository.findAll();
	}
    

    public Product getProductById(Long id) {
		
		return this.productRepository.findById(id).orElse(null);
	}
	

}
