package com.model;

public class Orders {
	private String name;
	private String date;
	private String time;
	private String postal;
	private String items;
	
	//Empty Constructor
	public Orders() {};
	
	public Orders(String name, String date, String time, String postal, String items) {
		this.name = name;
		this.date = date;
		this.time = time;
		this.postal = postal;
		this.items = items;
	}
	
	/*
	 * Getters and Setters
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}
	
	
}
