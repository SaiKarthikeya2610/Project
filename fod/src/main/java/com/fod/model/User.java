package com.fod.model;

public class User 
{
	private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
	public User() {
		super();
	}
	public User(int userId, String userName, String email, String password, String phoneNumber, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public User(String userName, String email, String password, String phoneNumber, String address) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	
	
	
	
	public User(int userId, String userName, String password, String phoneNumber, String address) {

		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	public String getuserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + userName + ", email=" + email + ", password=" + password
				+ ", phonenumber=" + phoneNumber + ", address=" + address + 
				 "]";
	}
    
    
}
