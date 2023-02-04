package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.Inventory;
import com.model.InventoryDatabase;
import com.model.InventoryItems;
import com.model.Store;
import com.model.StoreDatabase;
import com.view.Home;
import com.view.Login;
import com.view.ManagerCreateInventory;
import com.view.ManagerDeleteInventory;
import com.view.ManagerEditDeliveryMan;
import com.view.ManagerEditInventory;
import com.view.ManagerEditStore;
import com.view.ManagerHome;

public class ManagerDeleteInventoryController {
	private static ManagerDeleteInventory view;
	private static InventoryDatabase inventoryDb;
	
	//Store database
	private StoreDatabase storeDb;
		
	//User Database
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
	
	//Selected index of the store list
	private int selectedIndex;
		
	//Selected index of the item list
	private int selectItemIndex;
	
	private InventoryItems priceItem;
	
	//Constructor
	public ManagerDeleteInventoryController(ManagerDeleteInventory view, InventoryDatabase inventoryDb) {
		this.view = view;
		this.inventoryDb = inventoryDb;
		
		//To load all the store inside the jlist when the page load
		for (Store s : storeDb.getStoresArray()) {
			String name = s.getName();
			
			view.getStoreModel().addElement(name);
		}
		
		//Action Listener for the select store button
		view.getSelectBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex = view.getStoreList().getSelectedIndex();
				
				String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
				
				//Changing the title to see which store inventory the user is deleting
				String title = "Deleting inventory for: " + storeName;
				view.getTitleLabel().setText(title);
				
				//Clear the list when user select another store
				view.getInventoryModel().removeAllElements();
				
				//To print the store items based on the selected store
				for (Inventory inventory : inventoryDb.getInventoryArray()) {
				    if (inventory.getStoreName().equals(storeName)) {
				        for (InventoryItems item : inventory.getInventoryItems()) {
				            String itemName = item.getItem();
				            String itemPrice = item.getPrice();

				            view.getInventoryModel().addElement(itemName + " - " + itemPrice);
				        }
				    }
				}
			}
		});
		
		//Action Listener for the delete menu button
		view.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
				if (view.getInventoryModel().getSize() == 0) {
					JOptionPane.showMessageDialog(null, "Please select a store before deleting", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this inventory?", 
															   "Delete Inventory Confirmation", 
															   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					
					//Calling the function to delete inside the price/item arraylist
					for (int i = inventoryDb.getItemPriceArray().size() - 1; i >= 0; i--) {
						inventoryDb.deletePriceItem(i);
						System.out.println(i);
					}
					
					//Successful message after editing a delivery man
					JOptionPane.showMessageDialog(null, "The inventory of: " + storeName + " has been deleted successfully", "Menu Deleted", JOptionPane.PLAIN_MESSAGE);
					
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
