package com.soumya.myapp.config;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.soumya.myapp.dto.CustomUserDetails;
import com.soumya.myapp.entity.User;
import com.soumya.myapp.service.UserService;

import lombok.Data;

@Data
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserService userService;
	
	private User user;
	
	@Autowired
	public CustomUserDetailsService(UserService userService) {
		
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		 this.user = this.userService.getUserByUserName(username);
		
		return new CustomUserDetails(this.user.getUserName(), 
				                     this.user.getPassword(), 
				                     this.user.getRoles().stream().map(role -> 
				                                                  new SimpleGrantedAuthority(
				                                                		                      role.getRoleName())).
				                     															collect(Collectors.toList()));
        
		
	}

}