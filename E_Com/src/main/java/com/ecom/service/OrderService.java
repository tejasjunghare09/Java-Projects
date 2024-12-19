package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;
import com.ecom.dto.OrderResDTO;

public interface OrderService {

	 List<OrderResDTO> getAllOrders();

	ApiResponse createOrder(Long userId,OrderReqDTO orderReqDTO);

}
