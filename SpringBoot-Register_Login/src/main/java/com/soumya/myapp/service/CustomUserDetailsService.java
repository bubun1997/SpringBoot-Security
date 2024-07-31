package com.soumya.myapp.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.soumya.myapp.dto.CustomUserDetails;
import com.soumya.myapp.entity.User;

import lombok.Data;

@Data
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserService userService;
	
	
	public CustomUserDetailsService(UserService userService) {
		
		this.userService = userService;
		System.err.println("User details service");
		System.err.println(userService);
	}

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException  {
		
		System.err.println(username+" inside user details");
		 User user = this.userService.getUserByUserName(username);
		 
		 System.err.println("got user !! "+user);
		
		return new CustomUserDetails(user.getUserName(), 
				                     user.getPassword(), 
				                     user.getRoles().
				                     stream().
				                     map(
				                    		 role -> new SimpleGrantedAuthority(role.getRoleName())
				                    		 
				                    	).collect(Collectors.toList()));
        
		
	}

}