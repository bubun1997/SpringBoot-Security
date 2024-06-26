package com.soumya.myapp.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soumya.myapp.service.CustomerService;
import com.soumya.myapp.service.OrderService;
import com.soumya.myapp.service.ProductService;


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
	public String getDashboardPage(Model model,Principal p) {
		
		
		String userName = p.getName();
		
		
		
		model.addAttribute("products", productService.getAllProducts_Customer());
		
		
		model.addAttribute("customer", this.customerService.getCustomerByUserName(userName));
		
		
		return "Customer-Dashboard";
	}
	
	@GetMapping("/purchase/{customerid}/{productid}")
	@PreAuthorize("hasAuthority('USER')")
	public String purchaseProduct(@PathVariable Long customerid, @PathVariable Long productid,Model model) {
		
		System.err.println(customerid+" "+productid);
		
		model.addAttribute("product", this.productService.getProductById(productid));
		model.addAttribute("customer", this.customerService.getCustomerById(customerid));
		
		return "Checkout";
	}
	
	@PostMapping("/checkout/{customerId}/{productId}")
	@PreAuthorize("hasAuthority('USER')")
    public String checkoutProduct(@PathVariable Long customerId,@PathVariable Long productId, @RequestParam int quantity) {
		
		this.customerService.assignProductToCustomer(customerId, productId,quantity);
		
		return "Success";
	}
	
	@GetMapping("/orders/{customerId}")
	@PreAuthorize("hasAuthority('USER')")
	public String viewOrders(@PathVariable Long customerId,Model model) {
		
		model.addAttribute("orders", this.orderService.findOrderByCustomerId(customerId));
		
		return "orders-list";
	}
	
	

}
