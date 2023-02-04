package com.model;

import java.util.ArrayList;

public class InventoryDatabase {
	//Creating the arraylist that will hold all the items
	private static ArrayList<Inventory> inventoryArray;
	
	//Creating the arraylist for the item and price
	private static ArrayList<InventoryItems> itemPriceArray;
	
	//Creating an inventory item object
	InventoryItems inventoryItemPrice;

	
	//Constructor
	public InventoryDatabase() {
		inventoryArray = new ArrayList<>();
		itemPriceArray = new ArrayList<>();
		
	}
	
	/**************************** Item/Price Arraylist ****************************/
	
	//Add inside the item/price arraylist
	public static void addPriceItem(InventoryItems inventoryItem) {
		itemPriceArray.add(inventoryItem);
	}
	
	//Edit inside the item/price arraylist
	public static void editPriceItem(InventoryItems inventoryItem, int index) {
		itemPriceArray.set(index, inventoryItem);
	}
	
	//Delete inside the item/price arraylist
	public static void deletePriceItem(int index) {
		itemPriceArray.remove(index);
	}
	
	/************************ End of Item/Price Arraylist *************************/
	
	/************************** All Inventory Arraylist **************************/
	
	//Add inside the inventory arraylist
	public static void addInventory(Inventory newInventory) {
		inventoryArray.add(newInventory);
	}
	
	//Edit inside the inventory arraylist
	public static void editInventory(Inventory newInventory, int index) {
		inventoryArray.set(index, newInventory);
	}
	
	//Delete an inventory inside the arraylist
	public static void deleteInventory(int index) {
		inventoryArray.remove(index);
	}
	
	public static void addToGeneralStore() {
		 //Creating the arraylist for the item and price
	    ArrayList<InventoryItems> itemPriceArray = new ArrayList<>();
	    
	    //Adding the predetermined item
	    itemPriceArray.add(new InventoryItems("Paper", "9.99"));
	    
	    //creating a new store
	    Inventory generalStore = new Inventory("General Store", itemPriceArray, "Active");
	    inventoryArray.add(generalStore);
	}
	
	/************************ End of All Inventory Arraylist ************************/

	/*
	 * Getters and Setters
	 * */
	public static ArrayList<Inventory> getInventoryArray() {
		return inventoryArray;
	}

	public static void setInventoryArray(ArrayList<Inventory> inventoryArray) {
		InventoryDatabase.inventoryArray = inventoryArray;
	}

	public static ArrayList<InventoryItems> getItemPriceArray() {
		return itemPriceArray;
	}

	public static void setItemPriceArray(ArrayList<InventoryItems> itemPriceArray) {
		InventoryDatabase.itemPriceArray = itemPriceArray;
	}
	
	public static ArrayList<InventoryItems> getStoreInventory(String storeName) {
	    for (Inventory inventory : inventoryArray) {
	        if (inventory.getStoreName().equals(storeName)) {
	            return inventory.getInventoryItems();
	        }
	    }
	    return null;
	}
	
	
}
