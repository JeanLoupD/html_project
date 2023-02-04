package com.model;

import java.util.ArrayList;

public class StoreDatabase {
	//Creating the arraylist that will hold all the stores
	private static ArrayList<Store> storesArray = new ArrayList<>();
	
	//Creating a store
	Store storeObj = new Store("General Store", "904 Bernard Street", "(514)286-4039", "A1A", "11:00", "16:30", "09:00", "17:00", 
								"09:00", "17:00", "09:00", "17:00", "09:00", "17:00", "09:00", "17:00", "11:00", "16:30", "Active");
	
	//Constructor
	public StoreDatabase() {		
		//Adding the store object arraylist inside the all store arraylist
		storesArray.add(storeObj);
	}
	
	//Add inside the store arraylist
	public static void addStore(Store newStore) {
		storesArray.add(newStore);
	}
	
	//Edit the store arraylist
	public static void editStoreObject(Store newStore, int index) {
		storesArray.set(index, newStore);
	}
	
	//Delete a store inside store arraylist
	public static void deleteStore(int index) {
		storesArray.remove(index);
	}

	/*
	 * Getters and Setters
	 * */
	public static ArrayList<Store> getStoresArray() {
		return storesArray;
	}

	public static void setStoresArray(ArrayList<Store> storesArray) {
		StoreDatabase.storesArray = storesArray;
	}	
	
}
