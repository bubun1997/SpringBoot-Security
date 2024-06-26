package com.soumya.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout/user")
public class LogoutController {
	
	@GetMapping
	public String getLogoutPage() {
		
		System.err.println("Logout called");
		return "Logout";
	}

}
