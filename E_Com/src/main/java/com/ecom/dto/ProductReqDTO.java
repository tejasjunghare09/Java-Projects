package com.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReqDTO {


	
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int quantity;
	
	
	private boolean isDeleted; 
	
}
