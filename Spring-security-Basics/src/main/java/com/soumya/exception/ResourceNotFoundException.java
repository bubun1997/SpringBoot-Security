package com.soumya.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResourceNotFoundException extends RuntimeException {
	
	private String message;
	
    
}
