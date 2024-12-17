package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.ProductDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductReqDTO;
import com.ecom.dto.ProductRespDTO;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<ProductRespDTO> getAllProducts() {
		return productDao.findAll() //List<CategoryEnt>
				.stream() //Stream<Entity>
				.map(product -> modelMapper.map(product, ProductRespDTO.class))
				.collect(Collectors.toList());
	}
				
	
	@Override
	public ApiResponse addNewProduct(ProductReqDTO dto) {
		
		Product productEntity =modelMapper.map(dto, Product.class);
		Product persistentProduct =productDao.save(productEntity);
		
		
		return new ApiResponse("Added new Product with Id : " +persistentProduct.getId());
	}


	@Override
	public ApiResponse deleteProduct(Long productId) {
		if(productDao.existsById(productId)) {
			productDao.deleteById(productId);
			return new ApiResponse("Deleted Product Details Successfully !");
		}
		return new ApiResponse("Invalid Product Id !!!");
	}



	
	
	

}
