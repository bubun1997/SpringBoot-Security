package com.soumya.myapp.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soumya.myapp.entity.Customer;
import com.soumya.myapp.entity.Product;
import com.soumya.myapp.service.CustomerService;
import com.soumya.myapp.service.OrderService;
import com.soumya.myapp.service.ProductService;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/dashboard")
	@PreAuthorize("hasAuthority('USER')")
	public String getDashboardPage(Model model,Principal p,HttpSession session) {
		
		
		String userName = p.getName();
		
		System.err.println("Customer dash called "+session.getId());
		
		
		
		model.addAttribute("products", productService.getAllProducts_Customer());
		
		
		model.addAttribute("customer", this.customerService.getCustomerByUserName(userName));
		
		
		
		return "Customer-Dashboard";
	}
	
	@GetMapping("/purchase/{customerid}/{productid}")
	@PreAuthorize("hasAuthority('USER')")
	public String purchaseProduct(@PathVariable Long customerid, @PathVariable Long productid,Principal p,Model model,HttpSession session) {
		
		System.err.println(session.getId());

		   Customer customer = this.customerService.getCustomerByUserName(p.getName());
		   
		   if( ! customerid.equals(customer.getCustomerId())) {
			   
			   return "redirect:/api/customers/dashboard";
		   }
		   
		  Product product = this.productService.getProductById(productid);
		  
		  if(product == null ) 
			  return "redirect:/api/customers/dashboard";

		  else if(product.getProductQuantity() == 0)
			   return "redirect:/api/customers/dashboard";
		  
		  else {
		
			System.err.println(customerid+" "+productid);
			
			model.addAttribute("product", product);
			model.addAttribute("customer", this.customerService.getCustomerById(customerid));
			
			return "Checkout";
		  }
	}
	
	@GetMapping("/checkout/{customerId}/{productId}")
	@PreAuthorize("hasAuthority('USER')")
    public String checkoutProduct(@PathVariable Long customerId,@PathVariable Long productId, @RequestParam int quantity,Principal p) {
		
		   Customer customer = this.customerService.getCustomerByUserName(p.getName());
		   
		   if( ! customerId.equals(customer.getCustomerId())) {
			   
			   return "redirect:/api/customers/dashboard";
		   }
		   
		   Product product = this.productService.getProductById(productId);
			  
			  if(product == null ) 
				  return "redirect:/api/customers/dashboard";

			  else if(product.getProductQuantity() == 0)
				   return "redirect:/api/customers/dashboard";
			  
			  else {
		
				   this.customerService.assignProductToCustomer(customerId, productId,quantity);
				
				   return "Success";
			  }
	}
	
	@GetMapping("/orders/{customerId}")
	@PreAuthorize("hasAuthority('USER')")
	public String viewOrders(@PathVariable Long customerId,Model model,Principal p) {
		
	   Customer customer = this.customerService.getCustomerByUserName(p.getName());
	   
	   if( ! customerId.equals(customer.getCustomerId())) {
		   
		   return "redirect:/api/customers/dashboard";
	   }
		
		model.addAttribute("orders", this.orderService.findOrderByCustomerId(customerId));
		model.addAttribute("customerName", customer.getCustomerName());
		
		return "orders-list";
	}
	
	

}
