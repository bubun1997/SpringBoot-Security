package com.soumya.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.soumya.myapp.entity.Customer;
import com.soumya.myapp.entity.Orders;
import com.soumya.myapp.entity.Product;
import com.soumya.myapp.entity.Role;
import com.soumya.myapp.entity.User;
import com.soumya.myapp.repository.CustomerRepository;
import com.soumya.myapp.repository.UserRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public Customer saveCustomer(Customer customer) {
		
		 customer.setPassword(encoder.encode(customer.getPassword()));
					
	     customer =customerRepository.save(customer);
	     
	     User user = User.builder().
	    		          userName(customer.getCustomerEmail()).
	    		          password(customer.getPassword()).build();
	     
	     Role role= Role.builder().roleName("USER").user(user).build();
	     
	     
	     user.setRoles(List.of(role));
	     
		this.userRepository.save(user);
		

			
	     return customer;
	}
	
	public void assignProductToCustomer(Long customerId,Long productId,int quantity) {
		
		Customer customer = this.customerRepository.findById(customerId).get();
		
		Product product = this.productService.getProductById(productId);
		
		
		customer.setProduct(product);
		
		product.setProductQuantity(product.getProductQuantity()-quantity);
		
		this.customerRepository.save(customer);
		this.productService.addProduct(product);
		
		Orders order = this.orderService.findOrderByCustomerIdAndProductName(customerId, product.getProductName());
		
		if(order == null) {
			
			order = Orders.
					builder().
					customerId(customerId).
					customerName(customer.getCustomerName()).
					productName(product.getProductName()).
					productQuantity(quantity).
					build();
			
			this.orderService.saveOrder(order);
		}
		else {
			
			order.setProductQuantity(order.getProductQuantity()+quantity);
			this.orderService.saveOrder(order);

		}
		
	}
	
	public Customer getCustomerByUserName(String uname) {
		
		return this.customerRepository.findByCustomerEmail(uname).get();
	}
	
    public Customer getCustomerById(Long id) {
		
		return this.customerRepository.findById(id).get();
	}

}
