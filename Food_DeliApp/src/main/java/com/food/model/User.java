package com.food.model;

import java.util.Date;



public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private String address;
    private String role;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int l) {
		this.userID = l;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public User(int userID, String username, String password, String email, String address, String role) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}
	

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + "]";
	}
	
}
