package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.Inventory;
import com.model.InventoryDatabase;
import com.model.InventoryItems;
import com.model.Store;
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
import com.view.Home;
import com.view.Login;
import com.view.ManagerCreateInventory;
import com.view.ManagerDeleteInventory;
import com.view.ManagerEditDeliveryMan;
import com.view.ManagerEditInventory;
import com.view.ManagerEditStore;
import com.view.ManagerHome;

public class ManagerCreateInventoryController {
	private static ManagerCreateInventory view;
	private static InventoryDatabase inventoryDb;
	
	//Store database
		private StoreDatabase storeDb;
		
		//User database
		private Database model;
		
		//Pages variables
		private ManagerEditStore managerEditStore;
		private ManagerCreateInventory managerCreateInventory;
		private ManagerEditInventory managerEditInventory;
		private ManagerDeleteInventory managerDeleteInventory;
		private ManagerEditDeliveryMan managerEditDelivery;
		private Login login;
		private Home home;
		private ManagerHome managerHome;
		
		//Selected index of the list
		private int selectedIndex;
		
		private ArrayList<InventoryItems> newArray;
		private InventoryItems priceItem;
		
		//Constructor
		public ManagerCreateInventoryController(ManagerCreateInventory view, InventoryDatabase inventoryDb) {
			this.view = view;
			this.inventoryDb = inventoryDb;
			
			inventoryDb.addToGeneralStore();
			
			//To load all the store inside the jlist when the page load
			for (Store s : storeDb.getStoresArray()) {
				String name = s.getName();
				
				view.getStoreModel().addElement(name);
			}
			
			//Action Listener for the select button
			view.getSelectBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selectedIndex = view.getStoreList().getSelectedIndex();
					
					String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
					String title = "Creating inventory for: " + storeName;
					
					//Changing the title so user can see which store inventory he's creating
					view.getTitle_label().setText(title);
				}
			});
			
			//Action Listener for the add item button
			view.getAddItemBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String item = view.getName_textfield().getText();
					String price = view.getPrice_textfield().getText();
					String numRegex = "^\\d+(\\.\\d+)*$";
					
					if (item.equals("") || price.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter an item name and a price", "Error", JOptionPane.OK_OPTION);
					} else if (!price.matches(numRegex)) {
						JOptionPane.showMessageDialog(null, "Please enter a price with only numbers and dot (#.##)", "Error", JOptionPane.OK_OPTION);
					} else if (view.getTitle_label().getText().equals("Create Inventory")) {
						JOptionPane.showMessageDialog(null, "Please select a store before adding new items", "Error", JOptionPane.OK_OPTION);
					} else {
						//Adding the item and price inside the jlist
						view.getInventoryModel().addElement(item + " - " + price);
						
						//Creating a new inventory item object
						InventoryItems priceItem = new InventoryItems(item, price);
						
						//Adding the object inside his arraylist
						inventoryDb.addPriceItem(priceItem);
						
						//Clearing the textfield after adding an item
						view.getName_textfield().setText("");
						view.getPrice_textfield().setText("");
						
					}
					
				}
			});
			
			//Action Listener for the create button
			view.getCreateBtn().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String allItems = "";
					//Looping inside the jlist to get every items
					for (int i = 0; i < view.getInventoryList().getModel().getSize(); i++) {
						allItems += view.getInventoryList().getModel().getElementAt(i) + "\n";
					}
					
					if (view.getInventoryModel().getSize() == 0) {
						JOptionPane.showMessageDialog(null, "Please enter items before creating the inventory", "Error", JOptionPane.OK_OPTION);
					} else if (JOptionPane.showConfirmDialog(null, "Confirm information?\nItems:\n " + allItems,
																	"Confirmation",
																	JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						
						String storeName = view.getStoreList().getSelectedValue();
						
						Inventory inventoryObj = new Inventory(storeName, inventoryDb.getItemPriceArray(), "Active");
							
						inventoryDb.addInventory(inventoryObj);
						
						
						//Successful message after editing a delivery man
						JOptionPane.showMessageDialog(null, "Inventory of: " + storeName + " has been successfully created", "Inventory Create", JOptionPane.PLAIN_MESSAGE);
						
						//Redirecting the user to the home page
						managerHome = new ManagerHome();
						managerHome.setLocationRelativeTo(null);
						managerHome.setVisible(true);
								
						//Creating the login page controller
						ManagerHomeController managerHomeController = new ManagerHomeController(managerHome);
								
						//Hiding the edit edit store page
						view.setVisible(false);

					}
				}
			});
			

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
