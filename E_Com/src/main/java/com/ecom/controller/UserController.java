package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.UserDTO;
import com.ecom.pojos.BaseEntity;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("https://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("in ctor " + getClass());

	}
	
	@PostMapping
	public ResponseEntity<?> addnewUser
	(@RequestBody UserDTO user){
		System.out.println("in add user " + user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.addNewUser(user));

		
	}

}
