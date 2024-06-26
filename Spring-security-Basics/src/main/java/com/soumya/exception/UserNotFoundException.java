package com.soumya.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserNotFoundException extends InternalAuthenticationServiceException {

	private String message;
	
	public UserNotFoundException(String message) {
		
		super(message);
		this.message = message;
		
		
	}
	
	

}
