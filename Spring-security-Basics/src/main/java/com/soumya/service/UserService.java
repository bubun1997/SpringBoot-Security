package com.soumya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.soumya.entity.User;
import com.soumya.exception.UserNotFoundException;

@Service
public class UserService {
	
	
	private final List<User> USERS_LIST;
	
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(PasswordEncoder passwordEncoder){
		
//		this.passwordEncoder = passwordEncoder;

		USERS_LIST = new ArrayList<>(List.of(
				
				
		         User.builder().
		              userName("soumya").
		              password(passwordEncoder.encode("bubun_1997")).
		              roles(
		            		   List.of(
		            				     "ADMIN",
		            				     "USER"
		            				   
		            				   )
		            	   ).
		              build(),
		          
		          User.builder().
		              userName("ram").
		              roles(
		            		   List.of(
		            				     "NORMAL"
		            				   
		            				   )
		            	   ).
		              password(passwordEncoder.encode("ram@123")).build()
		          
		
		
		
		));
		
		
	}
	
	
	public User findUserByUserName(String userName) {
		
		System.err.println("username -> "+userName);
		
	    
		
		return this.USERS_LIST.stream().
				    filter( user -> user.getUserName().equalsIgnoreCase(userName)).
				    findAny().orElseThrow(() -> UserNotFoundException.builder().
				    		     				message("Invaled username : "+userName).
				    		     				build());
		
		
	}

}
