package com.ecom.dto;

import java.time.LocalDate;

import com.ecom.pojos.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDTO extends BaseDTO{

	@NotEmpty
	private String firstName;
	
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Past
	private LocalDate dob;
	
	private UserRole userRole =UserRole.CUSTOMER;
	
}
