package com.model;

import java.util.ArrayList;

public class OrderDatabase {
	//Creating the arraylist that will hold every order
	private static ArrayList<Orders> allOrders;
	
	//Constructor
	public OrderDatabase() {
		allOrders = new ArrayList<>();
	}
	
	//Add inside the all orders arraylist
	public static void addAllOrders(Orders order) {
		allOrders.add(order);
	}
	
	//Edit inside the all orders arraylist
	public static void editAllOrder(Orders order, int index) {
		allOrders.set(index, order);
	}
	
	//Delete inside the all orders arraylist
	public static void deleteAllOrder(int index) {
		allOrders.remove(index);
	}

	/*
	 * Getters and Setters
	 * */
	public static ArrayList<Orders> getAllOrders() {
		return allOrders;
	}

	public static void setAllOrders(ArrayList<Orders> allOrders) {
		OrderDatabase.allOrders = allOrders;
	}
	
	
}
