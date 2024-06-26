package com.soumya.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soumya.myapp.entity.Customer;
import com.soumya.myapp.service.CustomerService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping
	public String getRegistrationPage() {
		
		return "Register";
	}
	
	@PostMapping
	public String processRegistration(@ModelAttribute Customer customer) {
		
		this.customerService.saveCustomer(customer);
		
		return "redirect:/signin";
	}
	

}
