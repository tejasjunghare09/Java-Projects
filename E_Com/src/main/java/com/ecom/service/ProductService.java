package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.ProductRespDTO;

public interface ProductService {

	List<ProductRespDTO> getAllAvailableProducts();
	ApiResponse addNewProduct(ProductReqDTO user,Long userId);
	ApiResponse deleteProduct(Long userId,Long productId);
}
