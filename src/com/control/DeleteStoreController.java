package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.model.Database;
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

public class DeleteStoreController {
	private static DeleteStore view;
	private static StoreDatabase storeDb;
	
	//Users database
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
		
	//Selected index of the list
	private int selectedIndex;
	
	//Constructor
	public DeleteStoreController(DeleteStore view, StoreDatabase storeDb) {
		this.view = view;
		this.storeDb = storeDb;
		
		//To load the store list when the page load
		for (Store s : storeDb.getStoresArray()) {
			String name = s.getName();
			
			view.getStoreModel().addElement(name);
		}
		
		//Action Listener for the select button
		view.getSelectBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex = view.getStoreList().getSelectedIndex();
				
				//Getting the values of the selected store
				String name = storeDb.getStoresArray().get(selectedIndex).getName();
				String address = storeDb.getStoresArray().get(selectedIndex).getAddress();
				String phone = storeDb.getStoresArray().get(selectedIndex).getPhone();
				String areas = storeDb.getStoresArray().get(selectedIndex).getAreas();
				String[] test = areas.split("[,]");
				String sundayOpen = storeDb.getStoresArray().get(selectedIndex).getSundayOpen();
				String sundayClose = storeDb.getStoresArray().get(selectedIndex).getSundayClose();
				String mondayOpen = storeDb.getStoresArray().get(selectedIndex).getMondayOpen();
				String mondayClose = storeDb.getStoresArray().get(selectedIndex).getMondayClose();
				String tuesdayOpen = storeDb.getStoresArray().get(selectedIndex).getTuesdayOpen();
				String tuesdayClose = storeDb.getStoresArray().get(selectedIndex).getTuesdayClose();
				String wednesdayOpen = storeDb.getStoresArray().get(selectedIndex).getWednesdayOpen();
				String wednesdayClose = storeDb.getStoresArray().get(selectedIndex).getWednesdayClose();
				String thursdayOpen = storeDb.getStoresArray().get(selectedIndex).getThursdayOpen();
				String thursdayClose = storeDb.getStoresArray().get(selectedIndex).getThursdayClose();
				String fridayOpen = storeDb.getStoresArray().get(selectedIndex).getFridayOpen();
				String fridayClose = storeDb.getStoresArray().get(selectedIndex).getFridayClose();
				String saturdayOpen = storeDb.getStoresArray().get(selectedIndex).getSaturdayOpen();
				String saturdayClose = storeDb.getStoresArray().get(selectedIndex).getSaturdayClose();
				
				//Outprint the values in the textfields
				view.getName_textfield().setText(name);
				view.getAddress_textfield().setText(address);
				view.getPhone_textfield().setText(phone);
				
				view.getSundayOpenModel().setSelectedItem(sundayOpen);
				view.getSundayCloseModel().setSelectedItem(sundayClose);
				view.getMondayOpenModel().setSelectedItem(mondayOpen);
				view.getMondayCloseModel().setSelectedItem(mondayClose);
				view.getTuesdayOpenModel().setSelectedItem(tuesdayOpen);
				view.getTuesdayCloseModel().setSelectedItem(tuesdayClose);
				view.getWednesdayOpenModel().setSelectedItem(wednesdayOpen);
				view.getWednesdayCloseModel().setSelectedItem(wednesdayClose);
				view.getThursdayOpenModel().setSelectedItem(thursdayOpen);
				view.getThursdayCloseModel().setSelectedItem(thursdayClose);
				view.getFridayOpenModel().setSelectedItem(fridayOpen);
				view.getFridayCloseModel().setSelectedItem(fridayClose);
				view.getSaturdayOpenModel().setSelectedItem(saturdayOpen);
				view.getSaturdayCloseModel().setSelectedItem(saturdayClose);
				
				//Adding the areas inside the areas list
				for (String t : test) {
					view.getAreaModel().addElement(t);
				}
				
			}
		});
		
		//Action Listener for the confirm delete store button
		view.getConfirmBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = view.getName_textfield().getText();
				
				if (name.equals("")) {
					JOptionPane.showMessageDialog(null, "Please select a Store to delete", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + name + " ?", 
							"Confirm Edit", 
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					//Calling the function to delete inside the store object arraylist
					storeDb.deleteStore(selectedIndex);
					
					//Successful message after deleting the delivery man
					JOptionPane.showMessageDialog(null, name + " has been successfully deleted", "Store Delete", JOptionPane.PLAIN_MESSAGE);
					
					//Redirecting the user to the home page
					home = new Home();
					home.setLocationRelativeTo(null);
					home.setVisible(true);
					
					//Creating the login page controller
					HomeController homeController = new HomeController(home);
					
					//Hiding the delete delivery man page
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
