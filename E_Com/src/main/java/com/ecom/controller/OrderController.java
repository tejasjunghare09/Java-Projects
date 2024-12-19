package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;
import com.ecom.dto.OrderResDTO;
import com.ecom.pojos.Order;
import com.ecom.service.OrderService;
import com.ecom.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users/orders")
@CrossOrigin(origins = "http://localhost:3000")

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	
	public OrderController() {
		System.out.println("in ctor " + getClass());

	}
	
	@GetMapping
	public ResponseEntity<?> getOrderDetails() 
	{
		System.out.println("get all Order Details");
		List<OrderResDTO> orders= orderService.getAllOrders();
		if (orders.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(orders);
	}
	
	@PostMapping("/{userId}/orders")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId,@RequestBody OrderReqDTO orderReqDTO){
		
		System.out.println("in createOrder " + orderReqDTO);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userId,orderReqDTO));
		}catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
				
	}

}
