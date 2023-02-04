package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

public class ManagerEditInventoryController {
	private static ManagerEditInventory view;
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

	//Selected index of the store list
	private int selectedIndex;
	
	//Selected index of the item list
	private int selectItemIndex;
	
	private InventoryItems priceItem;
	
	private ArrayList<InventoryItems> storeInventory;
	private String nameTest;
	private int selectedIndexTest;
	
	//Constructor
	public ManagerEditInventoryController(ManagerEditInventory view, InventoryDatabase inventoryDb) {
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
				nameTest = view.getStoreList().getSelectedValue();
				
				//Changing the title to see which store the user is editing
				String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
				String title = "Editing inventory for: " + storeName;
				
				//Changing the title so user can see which store inventory he's editing
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
		
		//List listener to fill the textfield when the user click on an item
		view.getInventoryList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {	
				
				if (!e.getValueIsAdjusting()) {
				   
				    selectedIndexTest = view.getInventoryList().getSelectedIndex();

				    // Find the selected store in the inventoryArray
				    for (Inventory inventory : inventoryDb.getInventoryArray()) {
				        if (inventory.getStoreName().equals(nameTest)) {
				            for (InventoryItems item : inventory.getInventoryItems()) {
				                if (inventory.getInventoryItems().indexOf(item) == selectedIndexTest) {
				                    view.getName_textfield().setText(item.getItem());
				                    view.getPrice_textfield().setText(item.getPrice());
				                }
				            }
				        }
				    }
				}
			    	
			}
		});
		
		//Action Listener for the add item button
		view.getAddItemBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
				String itemName = view.getName_textfield().getText();
				String itemPrice = view.getPrice_textfield().getText();
				String numRegex = "^\\d+(\\.\\d+)*$";
						
				if (itemName.equals("") || itemPrice.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter an item name and a price", "Error", JOptionPane.OK_OPTION);
				} else if (!itemPrice.matches(numRegex)) {
					JOptionPane.showMessageDialog(null, "Please enter a price with only numbers and dot (#.##)", "Error", JOptionPane.OK_OPTION);
				} else if (view.getTitleLabel().getText().equals("Edit Inventory")) {
					JOptionPane.showMessageDialog(null, "Please select a store before adding new items", "Error", JOptionPane.OK_OPTION);
				} else {
					//Adding the item and price inside the jlist
					view.getInventoryModel().addElement(itemName + " - " + itemPrice);
							
					//Creating a new inventory item object
					priceItem = new InventoryItems(itemName, itemPrice);
							
					//Adding the object inside his arraylist
					inventoryDb.addPriceItem(priceItem);
							
					//Clearing the textfield after adding an item
					view.getName_textfield().setText("");
					view.getPrice_textfield().setText("");
							
				}
						
			}
		});
		
		//Action Listener for the edit item button
		view.getEditItemBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemName = view.getName_textfield().getText();
				String itemPrice = view.getPrice_textfield().getText();
				String numRegex = "^\\d+(\\.\\d+)*$";
				String letterRegex = "^[a-zA-Z]*$";
				
				if (itemName.equals("") || itemPrice.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter an item name and a price", "Error", JOptionPane.OK_OPTION);
				} else if (!itemPrice.matches(numRegex)) {
					JOptionPane.showMessageDialog(null, "Please enter a price with only numbers and dot (#.##)", "Error", JOptionPane.OK_OPTION);
				} else if (!itemName.matches(letterRegex)) {
					JOptionPane.showMessageDialog(null, "Please enter a item name with only letters", "Error", JOptionPane.OK_OPTION);
				} else if (view.getTitleLabel().getText().equals("Edit Inventory")) {
					JOptionPane.showMessageDialog(null, "Please select a store before adding new items", "Error", JOptionPane.OK_OPTION);
				} else {
					//Adding the item and price inside the jlist
					view.getInventoryModel().setElementAt(itemName + " - " + itemPrice, selectedIndexTest);
					
					//Creating a new inventory item object
					priceItem = new InventoryItems(itemName, itemPrice);
					
					//Editing the object inside his arraylist
					inventoryDb.editPriceItem(priceItem, selectedIndexTest);
					
					//Clearing the textfield after adding an item
					view.getName_textfield().setText("");
					view.getPrice_textfield().setText("");
					
				}
			}
		});
		
		//Action Listener for the delete item button
		view.getDeleteItemBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getInventoryList().getSelectedIndex();
				String itemName = view.getName_textfield().getText();
				String itemPrice = view.getPrice_textfield().getText();
				
				if (itemName.equals("") || itemPrice.equals("")) {
					JOptionPane.showMessageDialog(null, "Please select an item before deleting", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item: " + itemName + " - " + itemPrice, 
															"Confirm Delete", 
															JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION) {
					
					//Calling the delete function
					inventoryDb.deletePriceItem(selectItemIndex);
					
					//Removing the item from the jlist
					if (index != -1) {
						view.getInventoryModel().removeElementAt(index);
					
					}
					
					//Clearing the textfield after adding an item
					view.getName_textfield().setText("");
					view.getPrice_textfield().setText("");
					
				}
			}
		});
		
		//Action Listener for the confirm edit button
		view.getEditBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String storeName = storeDb.getStoresArray().get(selectedIndex).getName();
				String allItems = "";
				//Looping inside the jlist to get every items
				for (int i = 0; i < view.getInventoryList().getModel().getSize(); i++) {
					allItems += view.getInventoryList().getModel().getElementAt(i) + "\n";
				}
				
				if (view.getInventoryList().getModel().getSize() == 0) {
					JOptionPane.showMessageDialog(null, "Please add at least one item before confirming", "Error", JOptionPane.OK_OPTION);
				}  else if (JOptionPane.showConfirmDialog(null, "Confirm edit?\nItems:\n " + allItems, 
																"Confirm Delete", 
																JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION) {
					
					
					//for (int i = 0; i < inventoryDb.getItemPriceArray().size() - 1; i++) {
						//Creating an inventory object
						//Inventory editInventory = new Inventory(storeName, inventoryDb.getItemPriceArray(), "Active");
						
						//inventoryDb.addInventory(editInventory);
						
						//Calling the edit all inventory function
						//inventoryDb.editInventory(editInventory, selectedIndex);
					//}
					
					//Successful message after editing a delivery man
					JOptionPane.showMessageDialog(null, "Inventory of: " + storeName + " has been successfully edited", "Inventory Edit", JOptionPane.PLAIN_MESSAGE);
					
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
