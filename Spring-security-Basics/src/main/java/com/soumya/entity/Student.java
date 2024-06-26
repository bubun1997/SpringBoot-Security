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
public class Student {
	
	private Long studentId;
	
	private String studentName;
	
	private List<String> email;
	
	private List<Laptop> laptops;
	
	

}
