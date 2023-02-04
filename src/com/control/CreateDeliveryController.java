package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.DeliveryMan;
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
import com.view.Home;
import com.view.Login;

public class CreateDeliveryController {
	private static CreateDeliveryMan view;
	private static Database model;
	
	//Store Database
	private StoreDatabase storeDb;
	
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	//Menu bar variable
	private CreateStore createStore;
	private EditStore editStore;
	private DeleteStore deleteStore;
	private CreateInventory createInventory;
	private EditInventory editInventory;
	private DeleteInventory deleteInventory;
	private CreateDeliveryMan createDelivery;
	private EditDeliveryMan editDelivery;
	private DeleteDeliveryMan deleteDelivery;
	private Login login;
	
	private Home home;
	
	//Creating the constructor
	public CreateDeliveryController(CreateDeliveryMan view, Database model) {
		this.view = view;
		this.model = model;
		
		//Key Listener for the delivery area text to be uppercase
		view.getArea_textfield().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String areaText = view.getArea_textfield().getText();
				view.getArea_textfield().setText(areaText.toUpperCase());
			}
		});
		
		//Action Listener to add a new delivery area
		view.getAddAreaBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String areaText = view.getArea_textfield().getText();
				
				if (areaText.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter a delivery area", "Error", JOptionPane.OK_OPTION);
				} else if (areaText.length() < 3 || areaText.length() > 3) {
					JOptionPane.showMessageDialog(null, "Delivery area must be 3 characters (A#A)", "Error", JOptionPane.OK_OPTION);
				} else {
					//Adding the new area inside the list
					view.getArea().addElement(areaText);
					
					//Clearing the area textfield when user add a new one
					view.getArea_textfield().setText("");
				}
			}
		});
		
		//Action Listener to delete an area inside the area list
		view.getDeleteAreaBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = view.getArea_textarea().getSelectedIndex();
				
				if (selectedIndex != -1) {
					view.getArea().remove(selectedIndex);
				}
			}
		});
		
		//Action Listener for the confirm create button
		view.getConfirmBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Holding every textfields inside a variables
				String firstname = view.getFirstname_textfield().getText();
				String lastname = view.getLastname_textfield().getText();
				String phone = view.getPhone_textfield().getText();
				String username = view.getUsername_textfield().getText();
				String password = view.getPassword_textfield().getText();
				String confirmPassword = view.getConfirm_textfield().getText();
				
				if (view.getArea_textarea().getModel().getSize() == 0 || firstname.equals("") || lastname.equals("") || phone.equals("") ||
						username.equals("") || password.equals("") || confirmPassword.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the forms before submitting", "Error", JOptionPane.OK_OPTION);
				} else if (firstname.length() < 3 || lastname.length() < 3) {
					JOptionPane.showMessageDialog(null, "First name and last name must be minimum 3 characters", "Error", JOptionPane.OK_OPTION);
				} else if (password.length() < 5 || confirmPassword.length() < 5) {
					JOptionPane.showMessageDialog(null, "Password must be at least 5 characters", "Error", JOptionPane.OK_OPTION);
				} else if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match\nPlease try again", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Confirm Information?\nFirst name: " + firstname
															 + "\nLast name: " + lastname
															 + "\nPhone: " + phone
															 + "\nUsername: " + username
															 + "\nArea covered: " + Arrays.toString(view.getArea().toArray()),
															 "Confirm Save",
															 JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					String allAreas = "";
					for (int i = 0; i < view.getArea_textarea().getModel().getSize(); i++) {
						allAreas += view.getArea_textarea().getModel().getElementAt(i) + ",";
					}
					
					//Creating a new delivery man object
					DeliveryMan newDeliveryMan = new DeliveryMan(6, username, password, firstname, lastname, phone, allAreas, 3, "Active");
					
					//Adding the new delivery man inside the arraylist
					model.addDeliveryMan(newDeliveryMan);
					
					//Adding inside the all users arraylist
					model.addInsideUsers(newDeliveryMan);
					
					//Successful message after creating the new delivery man
					JOptionPane.showMessageDialog(null, firstname + " " + lastname + " has been successfully created", "New Delivery Man", JOptionPane.PLAIN_MESSAGE);
					
					//Redirecting the user to the home page
					home = new Home();
					home.setLocationRelativeTo(null);
					home.setVisible(true);
					
					//Creating the login page controller
					HomeController homeController = new HomeController(home);
					
					//Hiding the create delivery man page
					view.setVisible(false);
					
//					ArrayList<DeliveryMan> deliverymansArray = Database.getDeliverymansArray();
//
//					// loop through the deliveryman array
//					for (DeliveryMan deliveryMan : deliverymansArray) {
//					    // print out the content of the array
//					    System.out.println(deliveryMan.getAreas());
//					}
					
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
					
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
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
				
				//Hiding the create delivery man page
				view.setVisible(false);
			}
		});
		
		/********************************END OF DELIVERY MAN MENU SECTION ***********************************/
	}
}
