package com.soumya.myapp.controller;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soumya.myapp.entity.User;
import com.soumya.myapp.service.UserService;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getHomePage(Principal p) {
		
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
		return "Home";
	}

}
