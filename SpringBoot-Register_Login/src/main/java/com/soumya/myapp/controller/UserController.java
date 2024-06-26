package com.soumya.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.soumya.myapp.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getAllUsers(Model model) {
		
		model.addAttribute("users", this.userService.getAllUsers());
		
		return "users-list";
	}

}
