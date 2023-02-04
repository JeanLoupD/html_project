package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.model.Database;
import com.model.OrderDatabase;
import com.model.Orders;
import com.model.Store;
import com.model.StoreDatabase;
import com.view.ClientDeleteAccount;
import com.view.ClientEditAccount;
import com.view.ClientOrderHistory;
import com.view.ClientOrderInventory;
import com.view.Login;

public class ClientOrderHistoryController {
	private static ClientOrderHistory view;
	private static StoreDatabase storeDb;
	
	//Page variables
	private Login login;
	private ClientEditAccount clientEditAccount;
	private ClientDeleteAccount clientDeleteAccount;
	private ClientOrderInventory clientOrderInventory;
	private ClientOrderHistory clientOrderHistory;
	
	//Database variables
	private OrderDatabase orderDb;
	private static Database model;
	
	private String nameStore;
	private String date;
	private String time;
	private String postal;
	private String items;
	
	//Constructor
	public ClientOrderHistoryController(ClientOrderHistory view, StoreDatabase storeDb) {
		this.view = view;
		this.storeDb = storeDb;
		
		//To load all the stores inside the list when the page load
		for (Store s : storeDb.getStoresArray()) {
			String name = s.getName();
			
			view.getStoreModel().addElement(name);
		}
		
		//List Listener when a client change store to empty the order history
		view.getStoreList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getHistoryModel().removeAllElements();
			}
		});
		
		//Action Listener for the select button
		view.getSelectBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameStore = view.getStoreList().getSelectedValue();
				boolean match = false;
				int index = 0;
				System.out.println(nameStore);
				
				for (int i = 0; i < view.getStoreList().getModel().getSize() - 1; i++) {
					if (orderDb.getAllOrders().get(i).getName().equals(nameStore)) {
						match = true;
						index = i;
						System.out.println("There is a match");
					}
				}
				
				if (match == true) {
					date = orderDb.getAllOrders().get(index).getDate();
					time = orderDb.getAllOrders().get(index).getTime();
					postal = orderDb.getAllOrders().get(index).getPostal();
					items = orderDb.getAllOrders().get(index).getItems();
					
					//Printing the values in the correct textfields
					view.getDate_textfield().setText(date);
					view.getTimeModel().setSelectedItem(time);
					view.getArea_textfield().setText(postal);
					
					//Splitting the items as an array
					String[] itemArray = items.split("[,]");
					
					//Filling the order history list
					for (String i : itemArray) {
						view.getHistoryModel().addElement(i);
					}
				} else {
					String noHistory = "No history found for this store";
					
					view.getHistoryModel().addElement(noHistory);
					
					view.getDate_textfield().setText("");
					view.getTimeModel().setSelectedItem("00:00");
					view.getArea_textfield().setText("");
				}
				
			}
		});
		
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
