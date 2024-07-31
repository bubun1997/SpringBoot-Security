package com.soumya.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.soumya.entity.User;

@Service
public class UserService {
	
	
	private final List<User> USERS_LIST;
	
//	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(PasswordEncoder passwordEncoder){
		
//		this.passwordEncoder = passwordEncoder;

		USERS_LIST = new ArrayList<>(List.of(
				
				
		         User.builder().
		              myUsername("soumya").
		              mypassword(passwordEncoder.encode("bubun_1997")).
		              roles(
		            		   List.of(
		            				     "ADMIN",
		            				     "USER"
		            				   
		            				   )
		            	   ).
		              build(),
		              

				         User.builder().
				              myUsername("kunal").
				              mypassword(passwordEncoder.encode("kunal7234")).
				              roles(
				            		   List.of(
				            				    
				            				     "USER"
				            				   
				            				   )
				            	   ).
				              build(),
		          
		          User.builder().
		              myUsername("ram").
		              roles(
		            		   List.of(
		            				     "NORMAL"
		            				   
		            				   )
		            	   ).
		              mypassword(passwordEncoder.encode("ram@123")).build()
		          
		
		
		
		));
		

		
	}
	
	
	public User findUserByUserName(String userName) {
		
		System.err.println("username -> "+userName);
		
	    
		
		User u = this.USERS_LIST.stream().
				    filter( user -> user.getMyUsername().equalsIgnoreCase(userName)).
				    findAny().orElseThrow(() -> new UsernameNotFoundException("User Name not found !!"));
		
		
		System.err.println("returning user !!");
		
		return u;
		
		
	}

}
