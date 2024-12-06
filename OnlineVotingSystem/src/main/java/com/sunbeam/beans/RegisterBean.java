package com.sunbeam.beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {
	
	String firstName;
	String lastName;
	String email;
	String password;
	String dob; 
	int save;
	

	
	public RegisterBean() {
		
	}


	


	public RegisterBean(String firstName, String lastName, String email, String password, String dob, int save) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.save = save;
	}





	public int getSave() {
		return save;
	}





	public void setSave(int save) {
		this.save = save;
	}





	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public void register()  {
		
		try(UserDao userDao = new UserDaoImpl()){
			Date date =Date.valueOf(dob);
			User u = new User(0,firstName,lastName,email,password,date,0,"voter");
			int count=userDao.save(u);
					save=count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	
	
	
}
