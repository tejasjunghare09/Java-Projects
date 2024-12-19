package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.custom_exceptions.ResourceNotFoundException;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.ProductRespDTO;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProductRespDTO> getAllAvailableProducts() {
		return productDao.findByStatusFalse()
				.stream().map(product -> modelMapper.map(product,ProductRespDTO.class))
				.collect(Collectors.toList());
				
	}
				
	
	@Override
	public ApiResponse addNewProduct(ProductReqDTO productReqDTO,Long userId) {
		User user = userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
		if(user.getUserRole().equals(UserRole.ADMIN)) {
			
			productReqDTO.setStatus(false);
			Product productEntity =modelMapper.map(productReqDTO, Product.class);
			Product persistentProduct =productDao.save(productEntity);
			return new ApiResponse("Added new Product with Id : " +persistentProduct.getId());

		}

		return new ApiResponse("userID Not Found !!!");
		
		
		
	}


	@Override
	public ApiResponse deleteProduct(Long userId,Long productId) {
		User user= userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User Not Found !!!"));
		
		if(user.getUserRole().equals(UserRole.ADMIN)) {
			if(productDao.existsById(productId)) {
				Product product = productDao.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product Not Found !!!"));
				product.setStatus(true);
				productDao.save(product);
				return new ApiResponse("Product Soft Deleted Successfully!!!");
			}
		}
		
		return new ApiResponse("Invalid User Id !!!");
	}



	
	
	

}
