package com.model;

public class InventoryItems {
	private String item;
	private String price;
	
	//Empty Constructor
	public InventoryItems() {};
	
	//Constructor
	public InventoryItems(String item, String price) {
		this.item = item;
		this.price = price;
	}
	
	/*
	 * Getters and Setters
	 * */
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
