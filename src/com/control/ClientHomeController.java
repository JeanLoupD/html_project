package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.model.Database;
import com.model.InventoryDatabase;
import com.model.StoreDatabase;
import com.view.ClientDeleteAccount;
import com.view.ClientEditAccount;
import com.view.ClientHome;
import com.view.ClientOrderHistory;
import com.view.ClientOrderInventory;
import com.view.Login;

public class ClientHomeController {
	private static ClientHome view;
	private static Database model;
	
	//Page variables
	private Login login;
	private ClientEditAccount clientEditAccount;
	private ClientDeleteAccount clientDeleteAccount;
	private ClientOrderInventory clientOrderInventory;
	private ClientOrderHistory clientOrderHistory;
	
	//Store Database
	private StoreDatabase storeDb;
		
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	public ClientHomeController(ClientHome view) {
		this.view = view;
		
		/*********************** File Menu *************************/
		
		//Action Listener for the disconnect button
		view.getDisconnect_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the login page
				login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				
				//Creating the login page controller
				LoginController loginController = new LoginController(login, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the quit button
		view.getQuit_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});   
		
		/********************* End File Menu ***********************/
		
		/********************* Account Menu ************************/
		
		//Action listener for the edit account menu button
		view.getEditAccount_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the client edit account page
				clientEditAccount = new ClientEditAccount();
				clientEditAccount.setLocationRelativeTo(null);
				clientEditAccount.setVisible(true);
				
				//Creating the edit account controller
				ClientEditAccountController clientEditAccountController = new ClientEditAccountController(clientEditAccount, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the delete account menu button
		view.getCloseAccount_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientDeleteAccount = new ClientDeleteAccount();
				clientDeleteAccount.setLocationRelativeTo(null);
				clientDeleteAccount.setVisible(true);
				
				//Creating the delete account controller
				ClientDeleteAccountController clientDeleteAccountController = new ClientDeleteAccountController(clientDeleteAccount, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/******************* End Account Menu **********************/
		
		/********************** Shop Menu **************************/
		
		//Action Listener for the order inventory page
		view.getOrderItem_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrderInventory = new ClientOrderInventory();
				clientOrderInventory.setLocationRelativeTo(null);
				clientOrderInventory.setVisible(true);
				
				//Creating the client order inventory controller
				ClientOrderController clientOrderController = new ClientOrderController(clientOrderInventory, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the order history page
		view.getOrderHistory_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrderHistory = new ClientOrderHistory();
				clientOrderHistory.setLocationRelativeTo(null);
				clientOrderHistory.setVisible(true);
				
				//Creating the client order history controller
				ClientOrderHistoryController clientOrderHistoryController = new ClientOrderHistoryController(clientOrderHistory, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/******************** End Shop Menu ************************/
	}
	
}
