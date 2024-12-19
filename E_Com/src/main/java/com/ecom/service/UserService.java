package com.ecom.service;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.UserDTO;

public interface UserService {

	ApiResponse addNewUser(UserDTO user);

}
