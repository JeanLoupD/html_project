package com.model;

public class Manager extends Users {
	private String email;
	private String address;
	
	//Open Constructor
	public Manager() {};
	
	//Constructor
	public Manager(
				   int id,
				   String username,
				   String password,
				   String firstname,
				   String lastname,
				   String email,
				   String phone,
				   String address,
				   int level,
				   String status) {
		super(id, username, password, firstname, lastname, phone, level, status);
		this.email = email;
		this.address = address;
		this.level = 2;
	}

	//Creating Getters And Setters
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
	
	
}
