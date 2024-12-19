package com.ecom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ProductRespDTO extends BaseDTO {


	private String name;
	
	private String description;
	
	private double price;
	
	
	private boolean status;
	
	private int stock;
	

}
