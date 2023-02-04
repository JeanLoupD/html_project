package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

public class CreateStoreController {
	private static CreateStore view;
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
	public CreateStoreController(CreateStore view, StoreDatabase storeDb) {
		this.view = view;
		this.storeDb = storeDb;
		
		//Key Listener for the delivery area text to be uppercase
		view.getArea_textfield().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String areaText = view.getArea_textfield().getText();
				view.getArea_textfield().setText(areaText.toUpperCase());
			}
		});
		
		//Action Listener to add new area button
		view.getAddAreaBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String areaText = view.getArea_textfield().getText();
				
				if (areaText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a delivery area", "Error", JOptionPane.OK_OPTION);
				} else if (areaText.length() < 3 || areaText.length() > 3) {
					JOptionPane.showMessageDialog(null, "Delivery area must be 3 characters (A#A)", "Error", JOptionPane.OK_OPTION);
				} else {
					//Adding the new area inside the list
					view.getAreaModel().addElement(areaText);
					
					//Clearing the area textfield when user add a new one
					view.getArea_textfield().setText("");
				}
			}
		});
		
		//Action Listener to delete an area inside the area list
		view.getDeleteAreaBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getAreaList().getSelectedIndex();
				
				if (index != -1) {
					view.getAreaModel().remove(index);
				}
			}
		});
		
		//Action Listener for the create new store button
		view.getCreateBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Holding every textfields inside variables
				String name = view.getName_textfield().getText();
				String address = view.getAddress_textfield().getText();
				String phone = view.getPhone_textfield().getText();
				
				String sundayOpen = view.getSundayOpen_combo().getSelectedItem().toString();
				String sundayClose = view.getSundayClose_combo().getSelectedItem().toString();
				String mondayOpen = view.getMondayOpen_combo().getSelectedItem().toString();
				String mondayClose = view.getMondayClose_combo().getSelectedItem().toString();
				String tuesdayOpen = view.getTuesdayOpenModel().getSelectedItem().toString();
				String tuesdayClose = view.getTuesdayClose_combo().getSelectedItem().toString();
				String wednesdayOpen = view.getWednesdayOpen_combo().getSelectedItem().toString();
				String wednesdayClose = view.getWednesdayClose_combo().getSelectedItem().toString();
				String thursdayOpen = view.getThursdayOpen_combo().getSelectedItem().toString();
				String thursdayClose = view.getThursdayClose_combo().getSelectedItem().toString();
				String fridayOpen = view.getFridayOpen_combo().getSelectedItem().toString();
				String fridayClose = view.getFridayClose_combo().getSelectedItem().toString();
				String saturdayOpen = view.getSaturdayOpen_combo().getSelectedItem().toString();
				String saturdayClose = view.getSaturdayClose_combo().getSelectedItem().toString();
				
				//Looping to get all areas inside the list
				String allAreas = "";
				for (int i = 0; i < view.getAreaList().getModel().getSize(); i++) {
					allAreas += view.getAreaList().getModel().getElementAt(i) + ",";
				}
				
				if (view.getAreaList().getModel().getSize() == 0 || name.equals("") || address.equals("") || phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the forms before submitting", "Error", JOptionPane.OK_OPTION);
				} else if (name.length() < 2) {
					JOptionPane.showMessageDialog(null, "Store name must be at least 2 characters", "Error", JOptionPane.OK_OPTION);
				} else if (sundayOpen.equals("00:00") && sundayClose.equals("00:00") && 
							mondayOpen.equals("00:00") && mondayClose.equals("00:00") &&
							tuesdayOpen.equals("00:00") && tuesdayClose.equals("00:00") && 
							wednesdayOpen.equals("00:00") && wednesdayClose.equals("00:00") &&
							thursdayOpen.equals("00:00") && thursdayClose.equals("00:00") && 
							fridayOpen.equals("00:00") && fridayClose.equals("00:00") &&
							saturdayOpen.equals("00:00") && saturdayClose.equals("00:00")){
					JOptionPane.showMessageDialog(null, "Please enter at least one opening and closing hours", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Confirm Information?\nStore name: " + name
																+ "\nStore address: " + address
																+ "\nPhone number: " + phone
																+ "\n Areas covered: " + allAreas
																+ "\n\nStore Schedule"
																+ "\nSunday: " + sundayOpen + " - " + sundayClose
																+ "\nMonday: " + mondayOpen + " - " + mondayClose
																+ "\nThuesday: " + tuesdayOpen + " - " + tuesdayClose
																+ "\nWednesday: " + wednesdayOpen + " - " + wednesdayClose
																+ "\nThursday: " + thursdayOpen + " - " + thursdayClose
																+ "\nFriday: " + fridayOpen + " - " + fridayClose
																+ "\nSaturday: " + saturdayOpen + " - " + saturdayClose,
																"Confirm Edit",
																JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					//Creating a new store object
					Store store = new Store(name, address, phone, allAreas, sundayOpen, sundayClose, mondayOpen, mondayClose,
												tuesdayOpen, tuesdayClose, wednesdayOpen, wednesdayClose, thursdayOpen, thursdayClose,
												fridayOpen, fridayClose, saturdayOpen, saturdayClose, "Active");
					
					//Calling the function to edit the store
					storeDb.addStore(store);
					
					//Successful message after editing a store
					JOptionPane.showMessageDialog(null, name + " has been successfully created", "Store Created", JOptionPane.PLAIN_MESSAGE);
					
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
