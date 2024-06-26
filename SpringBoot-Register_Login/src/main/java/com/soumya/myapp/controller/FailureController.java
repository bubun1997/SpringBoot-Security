package com.soumya.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/invalid")
public class FailureController {
	
	@GetMapping
	public String getFailurePage() {
		
		return "Invalid";
	}

}
