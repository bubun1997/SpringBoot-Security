package com.soumya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Laptop {
	
	private Long laptopId;
	
	private String laptopBrand;
	
	private Double laptopPrice;
	
	

}
