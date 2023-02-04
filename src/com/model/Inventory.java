package com.model;

import java.util.ArrayList;

public class Inventory {
	private String storeName;
	private ArrayList<InventoryItems> inventoryItems;
	private String status;
	
	//Empty Constructor
	public Inventory() {};
	
	//Constructor
	public Inventory(String storeName, ArrayList<InventoryItems> inventoryItems, String status) {
		this.storeName = storeName;
		this.inventoryItems = inventoryItems;
		this.status = status;
	}
	
	/*
	 * Getters and Setters
	 * */
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<InventoryItems> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(ArrayList<InventoryItems> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}
	
	
}
