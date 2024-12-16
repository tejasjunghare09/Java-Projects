package com.ecom.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
@ToString(callSuper = true)  //exclude
public class Product extends BaseEntity{
	
	@Column(name = "product_name" ,length = 50)
	private String name;
	
	private String description;
	@Column( length = 10,nullable = false )
	private double price;
	@Column(length = 10)
	private int quantity;
	
	@Column(name = "is_deleted")
	private boolean isDeleted; 
	
	
	

}
