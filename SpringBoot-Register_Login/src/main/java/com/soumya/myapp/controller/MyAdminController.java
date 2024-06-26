package com.soumya.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soumya.myapp.entity.User;
import com.soumya.myapp.service.UserService;

@RestController
public class MyAdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add/admin")
	public ResponseEntity<User> addAdminUser(@RequestBody User user){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.addUser(user));
	}

}
