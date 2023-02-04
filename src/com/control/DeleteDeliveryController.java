package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.DeliveryMan;
import com.model.InventoryDatabase;
import com.model.StoreDatabase;
import com.model.Users;
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


public class DeleteDeliveryController {
	private static DeleteDeliveryMan view;
	private static Database model;
	
	//Store Database
	private StoreDatabase storeDb;
	
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
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
	private Login login;
	
	private Home home;
	
	//Selected index of the list
	private int selectedIndex;
	
	//Creating the constructor
	public DeleteDeliveryController(DeleteDeliveryMan view, Database model) {
		this.view = view;
		this.model = model;
		
		//To load the Delivery man list when the user load the page
		for (DeliveryMan a : model.getDeliverymansArray()) {
			String name = a.getFirstname() + " " + a.getLastname();
			
			if (a.getStatus().equals("Active")) {
				view.getDeliveryManModel().addElement(name);
			}
		
		}
		
		//Add Action Listener for the select btn
		view.getSelectBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedIndex = view.getDeliveryManList().getSelectedIndex();
				
				System.out.println(selectedIndex);
				
				//Getting the values of the selected delivery man
				String firstname = model.getDeliverymansArray().get(selectedIndex).getFirstname();
				String lastname = model.getDeliverymansArray().get(selectedIndex).getLastname();
				String phone = model.getDeliverymansArray().get(selectedIndex).getPhone();
				String areas = model.getDeliverymansArray().get(selectedIndex).getAreas();
				String[] test = areas.split("[,]");
				
				//Outprint the values in the textfields
				view.getFirstname_textfield().setText(firstname);
				view.getLastname_textfield().setText(lastname);
				view.getPhone_textfield().setText(phone);
				
				//Adding the areas inside the areas list
				for (String t : test) {
					view.getAreaModel().addElement(t);
				}
	
			}
		});
		
		//Add Action Listener for the delete delivery man button
		view.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Holding every textfields inside a variables
				String firstname = view.getFirstname_textfield().getText();
				String lastname = view.getLastname_textfield().getText();
				
				if (firstname.equals("")) {
					JOptionPane.showMessageDialog(null, "Please select a Delivery Man to delete", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + firstname + " " + lastname + " ?", 
						   									"Confirm Edit", 
						   									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					
					//Getting the delivery man values that don't need to be updated
					int id = model.getDeliverymansArray().get(selectedIndex).getId();
					String username = model.getDeliverymansArray().get(selectedIndex).getUsername();
					String password = model.getDeliverymansArray().get(selectedIndex).getPassword();
					String phone = model.getDeliverymansArray().get(selectedIndex).getPhone();
					String allAreas = model.getDeliverymansArray().get(selectedIndex).getAreas();
					int level = model.getDeliverymansArray().get(selectedIndex).getLevel();
					
					//Create a new delivery man object
					DeliveryMan deleteDeliveryMan = new DeliveryMan(id, username, password, firstname, lastname, phone, allAreas, 3, "Inactive");
					
					//Calling the function to edit inside the delivery man array list
					model.editDeliveryMan(deleteDeliveryMan, selectedIndex);
			
					//Looping to edit inside the all users array list
					for (int i = 0; i < model.getAllUsers().size(); i++) {
						if (model.getAllUsers().get(i).getUsername().equals(username)) {
							model.editInsideUsers(deleteDeliveryMan, i);
					
						}
					}
					
					//Successful message after deleting the delivery man
					JOptionPane.showMessageDialog(null, firstname + " " + lastname + " has been successfully deleted", "Delivery Man Delete", JOptionPane.PLAIN_MESSAGE);
					
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
