package com.soumya.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.soumya.myapp.entity.User;
import com.soumya.myapp.exception.UserNameNotFoundException;
import com.soumya.myapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public User getUserByUserName(String userName) {
		
		return this.userRepository.findByUserName(userName).
								   orElseThrow(() -> new UserNameNotFoundException("Username not found "+userName));
	}
	
	public User addUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return this.userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		
		return this.userRepository.findAll();
	}

}
