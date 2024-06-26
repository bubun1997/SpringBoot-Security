package com.soumya.myapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public String userNameNotFoundExceptionHandler (UserNameNotFoundException ex,Model model) {
		
		model.addAttribute("mssg", ex.getMessage());
		
		System.err.println("exception caught");
		
		return "invalid";
	}

}
