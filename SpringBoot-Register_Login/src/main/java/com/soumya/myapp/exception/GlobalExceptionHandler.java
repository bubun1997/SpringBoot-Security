package com.soumya.myapp.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public String userNameNotFoundExceptionHandler (UsernameNotFoundException ex) {
			
		System.err.println("exception caught");
		
		return "Invalid";
	}

}
