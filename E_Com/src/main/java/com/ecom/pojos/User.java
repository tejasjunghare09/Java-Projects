package com.ecom.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * admin adding product    user
 * 
 * 
 */
//user 1---->* orders
//products * -----> * orders

/*


Entities - user(a_dmin|customer) , products , orders
Identify the associations correctly.

Add 1 admin n 2 customer records using insert query or service layer test case.

Requirements
1. Admin should be able to add a product


 */


@Entity
@NoArgsConstructor
@Getter 
@Setter
@Table(name = "users")
@ToString(callSuper = true ,exclude = "password")  //exclude check
public class User extends BaseEntity{
	
	@Column(name = "first_name" , length = 30)
	private String firstName;
	@Column(name = "last_name" , length = 30)
	private String lastName;
	@Column(unique = true , length = 30)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private UserRole userRole;
	

	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.userRole = userRole;
	}
	
	
	

}
