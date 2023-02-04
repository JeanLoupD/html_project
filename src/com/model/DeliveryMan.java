package com.model;

public class DeliveryMan extends Users {
	private String areas;
	
	//Open Constructor
	public DeliveryMan() {};
	
	//Constructor
	public DeliveryMan(
					   int id, 
					   String username,
					   String password,
					   String firstname,
					   String lastname,
					   String phone,
					   String areas,
					   int level,
					   String status) {
		super(id, username, password, firstname, lastname, phone, level, status);
		this.areas = areas;
		this.level = 3;
		
	}

	//Creating Getters and Setters
	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}
	
}
