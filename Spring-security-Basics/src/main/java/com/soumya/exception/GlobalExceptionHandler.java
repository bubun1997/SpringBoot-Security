package com.soumya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> exceptionHandler1(ResourceNotFoundException ex){
		
		System.err.println("excep 1");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> exceptionHandler2(UsernameNotFoundException mssg){
		
		System.err.println("excep 2");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mssg.getMessage());
	}
	
	@ExceptionHandler(AuthorizationDeniedException.class)
	public ResponseEntity<String> exceptionHandler3(AuthorizationDeniedException mssg){
		
		System.err.println("excep 3");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(mssg.getMessage());
	}
	
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<String> exceptionHandler4(NoResourceFoundException mssg){
		
		System.err.println("excep 4");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mssg.getMessage());
	}
	
	
	
	
}
