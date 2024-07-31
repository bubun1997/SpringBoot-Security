package com.soumya.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/main")
public class MainController {
	
	@GetMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getMain(HttpServletRequest req) {
		
		System.err.println(req.getSession().getId());
		return req.getSession().getId();
	}

}
