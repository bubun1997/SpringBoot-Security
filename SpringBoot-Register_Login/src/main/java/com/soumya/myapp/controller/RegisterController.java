package com.soumya.myapp.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soumya.myapp.entity.Customer;
import com.soumya.myapp.entity.User;
import com.soumya.myapp.service.CustomerService;
import com.soumya.myapp.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getRegistrationPage(Principal p) {
		
			if(p != null) {
			
			String uname = p.getName();
			
			User user = this.userService.getUserByUserName(uname);
			
			List<String> roleNames = user.
									 getRoles().
									 stream().
									 map( role -> role.getRoleName()).
									 collect(Collectors.toList());
			
			
			if(roleNames.contains("ADMIN"))
				return "redirect:/admin/dashboard";
			else 
				return "redirect:/api/customers/dashboard";
			
		}
		
		
		return "Register";
	}
	
	@PostMapping
	public String processRegistration(@ModelAttribute Customer customer) {
		
		this.customerService.saveCustomer(customer);
		
		return "redirect:/signin";
	}
	

}
