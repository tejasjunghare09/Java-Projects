package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.ProductRespDTO;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("https://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController() {
		System.out.println("in ctor " + getClass());

	}
	
	@GetMapping
	public ResponseEntity<?> getProducts() {
		System.out.println("get all");
		List<ProductRespDTO> products = 
				productService.getAllAvailableProducts();
		if (products.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(products);
	}
	
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> addnewProduct
	(Long userID,@RequestBody ProductReqDTO product){
		System.out.println("in add product " + product);// transient category
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.addNewProduct(product,userID));

		
	}
	
	/*
	 * URL -  http://host:port/products?productId=....
	 * Method -  DELETE
	 * payload -  request param
	 * resp success - DTO
	* resp error - DTO
	 * Desc - Hard delete product details
 */

	
	@PutMapping("/{productId}")
	public ResponseEntity<?> deleteProductDetails(@RequestParam Long userId ,@PathVariable Long productId)
	{
		System.out.println("in Delete "+ productId);
		try {
//			invoke service layer method
			return ResponseEntity.ok(productService.deleteProduct(userId,productId));
			
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
		
		
		
	}
	
}
