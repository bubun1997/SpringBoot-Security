package com.soumya.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
	
	private String uname;
	
	private String pass;
	
	private List<GrantedAuthority> authorities;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.pass;
	
	}
	@Override
	public String getUsername() {
		return this.uname;
	}

}

