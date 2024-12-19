package com.ecom.dto;

import com.ecom.pojos.Product;
import com.ecom.pojos.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class OrderResDTO extends BaseDTO {

	private double totalAmount;

	private int quantity;
	
	

	private User userId;

	private Product productId;

}
