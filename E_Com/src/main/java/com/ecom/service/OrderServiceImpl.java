package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.custom_exceptions.ResourceNotFoundException;
import com.ecom.dao.OrderDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderReqDTO;
import com.ecom.dto.OrderResDTO;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.UserDTO;
import com.ecom.pojos.Order;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private ModelMapper modelMapper;	
	
	@Override
	public List<OrderResDTO> getAllOrders() {
		

		
		return orderDao.findAll()
				.stream()
				.map(orders -> modelMapper.map(orders, OrderResDTO.class))
				.collect(Collectors.toList());
		
	}

	
	
	@Override
	public ApiResponse createOrder(Long userId,OrderReqDTO orderReqDTO) {
		//1.get Products by  its id
		Product product=productDao.findById(orderReqDTO.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Invalid Product ID !!!"));
		//2.get customer by its id 
		User user =userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id !!!"));
		
		if(product.getStock()<orderReqDTO.getQuantity())
		{
			throw new ResourceNotFoundException("Insufficient stock for product: " + product.getId());
			
		}
		Double totalAmount = (product.getPrice())* (orderReqDTO.getQuantity());
		product.setStock(product.getStock()-orderReqDTO.getQuantity());
		Order entity = modelMapper.map(orderReqDTO, Order.class);
		entity.setOrderProduct(product);
		entity.setUserOrder(user);		
		entity.setTotalAmount(totalAmount);
		orderDao.save(entity);
		 
		
//		//3.Confirm Role
//		if(user.getUserRole()==UserRole.CUSTOMER) {
//		//4.Map dto -> entity
//			Order entity=modelMapper.map(orderReqDTO, Order.class);
//		
//		}
		
		return new ApiResponse("Order placed with Id : " + entity.getId()) ;
	}

}
