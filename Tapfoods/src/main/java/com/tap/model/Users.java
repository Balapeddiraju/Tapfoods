package com.tap.model;

import java.sql.Date;

public class Users {
	private int  userId;
	private String name;
	private String email;
	private int phoneNo;
	private String Address ;
	private String username;
	private String password;
	private String role;
	private Date createDate;
	private Date lastLogin;
	
	public Users()
	{
		
	}
	public Users(int userId, String name, String email, int phoneNo2, String Address, String username,
			String password, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo2;
		this.Address = Address;
		this.username = username;
		this.password = password;
		this.role=role;
		
		
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public void setphoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public void setrole(String role) {
		this.role = role;
	}
	public int getuserId() {
		return userId;
	}
	public String getname() {
		return name;
	}
	public String getemail() {
		return email;
	}
	public int getphoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return Address;
	}
	public String getusername() {
		return username;
	}
	public String getpassword() {
		return password;
	}
	public String getrole() {
		return role;
	}
	
	
	

}
