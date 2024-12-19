package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserDTO;
import com.ecom.pojos.User;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse addNewUser(UserDTO dto) {
		User userEntity = modelMapper.map(dto, User.class);
		User persistentUser =  userDao.save(userEntity);
		return new ApiResponse("Added new User with Id : " +persistentUser.getId());
	}

}
