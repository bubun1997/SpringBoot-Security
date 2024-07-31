package com.soumya.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soumya.myapp.entity.User;
import com.soumya.myapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public User getUserByUserName(String userName) {
		
		System.err.println(userName+" fetched inside service ");
		
		User user = this.userRepository.
						 findByUserName(userName).
								   orElseThrow(() -> { 
									   System.err.println("Username not found !!");
									   return new UsernameNotFoundException("Username not found "+userName);
									   });
		
		System.err.println("returning user "+user.getUserName()+" "+user.getPassword());
		return user;
	}
	
	@Transactional
	public User addUser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		return this.userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		
		return this.userRepository.findAll();
	}

}
