package com.foodapp.maven.model.request;

public class AuthenticateUserRequest {
	
	private String username;
	private String password;
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public AuthenticateUserRequest() {
		// TODO Auto-generated constructor stub
	}

}
