package com.soumya.myapp.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

import lombok.Data;


@Data
public class UserNameNotFoundException extends InternalAuthenticationServiceException {

	private String message;

	public UserNameNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	

	
}
