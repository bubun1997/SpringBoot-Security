package com.soumya.config;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soumya.entity.CustomUserDetails;
import com.soumya.entity.User;
import com.soumya.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserService userService;
	
	@Autowired
	public CustomUserDetailsService(UserService userService) {
		
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userService.findUserByUserName(username);
        
		System.err.println("got user "+user);
		
		UserDetails userDetails = new CustomUserDetails(
				
				        user.getMyUsername(),
				        user.getMypassword(),
				        
				        user.getRoles().
				             stream().
				             map( role -> new SimpleGrantedAuthority(role)).
				             collect(Collectors.toList())

				
				);
		
		System.err.println("returning userdetails");
		
		return userDetails;
	}

}
