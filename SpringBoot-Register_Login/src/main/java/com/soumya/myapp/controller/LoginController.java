package com.soumya.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/signin")
public class LoginController {
	
	
	
	@GetMapping
	public String getLoginPage() {
		
		return "Login";

	}

}
