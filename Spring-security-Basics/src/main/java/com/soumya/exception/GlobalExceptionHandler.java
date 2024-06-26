package com.soumya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
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

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<String> exceptionHandler2(NoResourceFoundException ex){
		
		System.err.println(ex.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
	}
	
	@ExceptionHandler(AuthorizationDeniedException.class)
	public ResponseEntity<String> exceptionHandler3(AuthorizationDeniedException ex){
		
		System.err.println(ex.getMessage());

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> exceptionHandler4(UserNotFoundException ex){
		
		System.err.println(ex.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());

	}
	
	
	
}
