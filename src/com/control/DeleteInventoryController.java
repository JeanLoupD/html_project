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

public class DeleteInventoryController {
	private DeleteInventory view;
	private InventoryDatabase inventoryDb;
	
	//Store database
	private StoreDatabase storeDb;
	
	//User Database
	private Database model;
		
	//Menu bar variables
	private CreateStore createStore;
	private EditStore editStore;
	private DeleteStore deleteStore;
	private CreateInventory createInventory;
	private EditInventory editInventory;
	private DeleteInventory deleteInventory;
	private CreateDeliveryMan createDelivery;
	private EditDeliveryMan editDelivery;
	private DeleteDeliveryMan deleteDelivery;
		
	private Home home;
	private Login login;
		
	//Selected index of the store list
	private int selectedIndex;
		
	//Selected index of the item list
	private int selectItemIndex;
	
	private InventoryItems priceItem;
	
	//Constructor
	public DeleteInventoryController(DeleteInventory view, InventoryDatabase inventoryDb) {
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
					home = new Home();
					home.setLocationRelativeTo(null);
					home.setVisible(true);
					
					//Creating the login page controller
					HomeController homeController = new HomeController(home);
					
					//Hiding the edit delivery man page
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
		
		//Action Listener for the create store page
		view.getCreate_store().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the create store page
				createStore = new CreateStore();
				createStore.setLocationRelativeTo(null);
				createStore.setVisible(true);
				
				//Creating the create store controller
				CreateStoreController createStoreController = new CreateStoreController(createStore, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the edit store page
		view.getEdit_store().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit store page
				editStore = new EditStore();
				editStore.setLocationRelativeTo(null);
				editStore.setVisible(true);
				
				//Creating the edit store controller
				EditStoreController editStoreController = new EditStoreController(editStore, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the delete store page
		view.getDelete_store().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit store page
				deleteStore = new DeleteStore();
				deleteStore.setLocationRelativeTo(null);
				deleteStore.setVisible(true);
				
				//Creating the delete store controller
				DeleteStoreController deleteStoreController = new DeleteStoreController(deleteStore, storeDb);
				
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
				createInventory = new CreateInventory();
				createInventory.setLocationRelativeTo(null);
				createInventory.setVisible(true);
				
				//Creating the create inventory controller
				CreateInventoryController createInventoryController = new CreateInventoryController(createInventory, inventoryDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the edit inventory page
		view.getEdit_inventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit inventory page
				editInventory = new EditInventory();
				editInventory.setLocationRelativeTo(null);
				editInventory.setVisible(true);
				
				//Creating the edit inventory controller
				EditInventoryController editInventoryController = new EditInventoryController(editInventory, inventoryDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the delete inventory page
		view.getDelete_inventory().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the delete inventory page
				deleteInventory = new DeleteInventory();
				deleteInventory.setLocationRelativeTo(null);
				deleteInventory.setVisible(true);
				
				//Creating the delete inventory controller
				DeleteInventoryController deleteInventoryController = new DeleteInventoryController(deleteInventory, inventoryDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/*********************************** END OF INVENTORY MENU SECTION ***********************************/
		
		
		/************************************ DELIVERY MAN MENU SECTION **************************************/
		
		//Action Listener for the create delivery man page
		view.getCreate_delivery().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the create delivery man page
				createDelivery = new CreateDeliveryMan();
				createDelivery.setLocationRelativeTo(null);
				createDelivery.setVisible(true);
				
				//Creating the controller for the create delivery man page
				CreateDeliveryController deliveryController = new CreateDeliveryController(createDelivery, model);
					
				//Hiding the home page
				view.setVisible(false);

			}
		});
		
		//Action Listener for the edit delivery man page
		view.getEdit_delivery().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the edit delivery man page
				editDelivery = new EditDeliveryMan();
				editDelivery.setLocationRelativeTo(null);
				editDelivery.setVisible(true);
				
				//Creating the controller for the edit delivery man page
				EditDeliveryController editDeliveryController = new EditDeliveryController(editDelivery, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the delete delivery man page
		view.getDelete_delivery().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the delete delivery man page
				deleteDelivery = new DeleteDeliveryMan();
				deleteDelivery.setLocationRelativeTo(null);
				deleteDelivery.setVisible(true);
				
				//Creating the controller for the delete delivery page
				DeleteDeliveryController deleteDeliveryController = new DeleteDeliveryController(deleteDelivery, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/********************************END OF DELIVERY MAN MENU SECTION ***********************************/
	}
}
