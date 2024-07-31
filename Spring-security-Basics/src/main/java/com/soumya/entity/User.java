package com.soumya.entity;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	private Long id;
	
	private String myUsername;
	
	private String mypassword;
	
	private List<String> roles;

}
