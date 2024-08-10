package com.soumya.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InvalidSessionController {
	
	@GetMapping("/invalid-session")
	public String handleSession(HttpServletRequest req) {
		
		System.err.println(req.getSession().getId());
		return "Invalid-Session";
	}

}
