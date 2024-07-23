package com.soumya.myapp.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/dashboard")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getAdminPage(Principal principal,HttpSession session) {
		
		System.err.println(session.getId());
		
		System.err.println(principal.getName());
		return "Admin-Dashboard";
	}

}
