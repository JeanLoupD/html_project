package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.model.Database;
import com.model.InventoryDatabase;
import com.model.StoreDatabase;
import com.view.CreateDeliveryMan;
import com.view.CreateInventory;
import com.view.CreateStore;
import com.view.DeleteDeliveryMan;
import com.view.DeleteInventory;
import com.view.DeleteStore;
import com.view.EditDeliveryMan;
import com.view.EditInventory;
import com.view.EditStore;
import com.view.Login;
import com.view.ManagerCreateInventory;
import com.view.ManagerDeleteInventory;
import com.view.ManagerEditDeliveryMan;
import com.view.ManagerEditInventory;
import com.view.ManagerEditStore;
import com.view.ManagerHome;

public class ManagerHomeController {
	private static ManagerHome view;
	private static Database model;
	
	//Pages variables
	private ManagerEditStore managerEditStore;
	private ManagerCreateInventory managerCreateInventory;
	private ManagerEditInventory managerEditInventory;
	private ManagerDeleteInventory managerDeleteInventory;
	private ManagerEditDeliveryMan managerEditDelivery;
	private Login login;
	
	//Store Database
	private StoreDatabase storeDb;
	
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	//Creating the constructor
	public ManagerHomeController(ManagerHome view) {
		this.view = view;
		
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
				
		/**************************************** STORE MENU SECTION *****************************************/
				
		//Action Listener for the edit store page
		view.getEdit_store().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit store page
				managerEditStore = new ManagerEditStore();
				managerEditStore.setLocationRelativeTo(null);
				managerEditStore.setVisible(true);
						
				//Creating the edit store controller
				ManagerEditStoreController managerEditStoreController = new ManagerEditStoreController(managerEditStore, storeDb);
						
				//Hiding the home page
				view.setVisible(false);
			}
		});
				
		/************************************* END OF STORE MENU SECTION *************************************/
				
				
		/************************************** INVENTORY MENU SECTION ***************************************/
				
		//Action Listener for the create inventory page
		view.getCreate_inventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the create inventory page
				managerCreateInventory = new ManagerCreateInventory();
				managerCreateInventory.setLocationRelativeTo(null);
				managerCreateInventory.setVisible(true);
						
				//Creating the create inventory controller
				ManagerCreateInventoryController managerCreateInventoryController = new ManagerCreateInventoryController(managerCreateInventory, inventoryDb);
						
				//Hiding the home page
				view.setVisible(false);
			}
		});
				
		//Action Listener for the edit inventory page
		view.getEdit_inventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit inventory page
				managerEditInventory = new ManagerEditInventory();
				managerEditInventory.setLocationRelativeTo(null);
				managerEditInventory.setVisible(true);
						
				//Creating the edit inventory controller
				ManagerEditInventoryController managerEditInventoryController = new ManagerEditInventoryController(managerEditInventory, inventoryDb);
						
				//Hiding the home page
				view.setVisible(false);
			}
		});
				
		//Action Listener for the delete inventory page
		view.getDelete_inventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the delete inventory page
				managerDeleteInventory = new ManagerDeleteInventory();
				managerDeleteInventory.setLocationRelativeTo(null);
				managerDeleteInventory.setVisible(true);
						
				//Creating the delete inventory controller
				ManagerDeleteInventoryController managerDeleteInventoryController = new ManagerDeleteInventoryController(managerDeleteInventory, inventoryDb);
						
				//Hiding the home page
				view.setVisible(false);
			}
		});
				
		/*********************************** END OF INVENTORY MENU SECTION ***********************************/
				
				
		/************************************ DELIVERY MAN MENU SECTION **************************************/
				
		//Action Listener for the edit delivery man page
		view.getEdit_delivery().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit delivery man page
				managerEditDelivery = new ManagerEditDeliveryMan();
				managerEditDelivery.setLocationRelativeTo(null);
				managerEditDelivery.setVisible(true);
						
				//Creating the controller for the edit delivery man page
				ManagerEditDeliveryManController managerEditDeliveryController = new ManagerEditDeliveryManController(managerEditDelivery, model);
						
				//Hiding the home page
				view.setVisible(false);
			}
		});

		/********************************END OF DELIVERY MAN MENU SECTION ***********************************/
	}
}
