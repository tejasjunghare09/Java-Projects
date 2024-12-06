package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
	
	private String email;
	private String password;
	private User user;
	
	
	public LoginBean() {
		
	}
	



	public LoginBean(String email, String password, User user) {
		super();
		this.email = email;
		this.password = password;
		this.user = user;
	}




	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public void login() {
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(this.email);
			if(dbUser!=null && dbUser.getPassword().equals(this.password)) {
				this.user=dbUser;
			}
			
			else {
				this.user= null;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	

}
