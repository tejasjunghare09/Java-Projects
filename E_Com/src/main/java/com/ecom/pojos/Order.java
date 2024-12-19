package com.ecom.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Order extends BaseEntity{

	
	private double totalAmount;
	
	private int quantity;
	
	
	
	@ManyToOne
	@JoinColumn(name = "user_id" ,nullable = false)
	private User userOrder;
	
	@ManyToOne
	@JoinColumn(name = "product_id" ,nullable = false)
	private Product  orderProduct;
	

	public Order(double totalAmount, int quantity) {
		super();
		System.out.println("Cons oRder called");
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		
		
	}
	
	
	
	
	

}
