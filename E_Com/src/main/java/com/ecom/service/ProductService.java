package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.ProductRespDTO;

public interface ProductService {

	List<ProductRespDTO> getAllProducts();
	ApiResponse addNewProduct(ProductReqDTO user);
}
