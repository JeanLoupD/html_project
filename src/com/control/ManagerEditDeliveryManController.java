package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import com.view.ManagerCreateInventory;
import com.view.ManagerDeleteInventory;
import com.view.ManagerEditDeliveryMan;
import com.view.ManagerEditInventory;
import com.view.ManagerEditStore;
import com.view.ManagerHome;

public class ManagerEditDeliveryManController {
	private static ManagerEditDeliveryMan view;
	private static Database model;
	
	//Store Database
	private StoreDatabase storeDb;
	
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	//Pages variables
	private ManagerEditStore managerEditStore;
	private ManagerCreateInventory managerCreateInventory;
	private ManagerEditInventory managerEditInventory;
	private ManagerDeleteInventory managerDeleteInventory;
	private ManagerEditDeliveryMan managerEditDelivery;
	private ManagerHome managerHome;
	private Login login;
	private Home home;
	
	//Selected index of the list
	private int selectedIndex;
	
	//Constructor
	public ManagerEditDeliveryManController(ManagerEditDeliveryMan view, Database model) {
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

		//Key Listener for the delivery area text to be uppercase
		view.getArea_textfield().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String areaText = view.getArea_textfield().getText();
				view.getArea_textfield().setText(areaText.toUpperCase());
			}
		});
				
		//Action Listener to add a new delivery area
		view.getAddBtn().addActionListener(new ActionListener() {
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
		view.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = view.getAreaList().getSelectedIndex();
						
				if (index != -1) {
					view.getAreaModel().remove(index);
				}
			}
		});
				
		//Action Listener for the confirm edit button
		view.getConfirmBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Holding every textfields inside a variables
				String firstname = view.getFirstname_textfield().getText();
				String lastname = view.getLastname_textfield().getText();
				String phone = view.getPhone_textfield().getText();
						
				//Looping through all the delivery man areas
				String allAreas = "";
				for (int i = 0; i < view.getAreaList().getModel().getSize(); i++) {
					allAreas += view.getAreaList().getModel().getElementAt(i) + ",";
				}
						
				if (view.getAreaList().getModel().getSize() == 0 || firstname.equals("") || 
						lastname.equals("") || phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the forms before submitting", "Error", JOptionPane.OK_OPTION);
				} else if (firstname.length() < 3 || lastname.length() < 3) {
					JOptionPane.showMessageDialog(null, "First name and last name must be minimum 3 characters", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Confirm edit?\nFirst name: " + firstname
																	   + "\nLast name: " + lastname
																	   + "\nPhone: " + phone
																	   + "\nAreas covered: " + Arrays.toString(view.getAreaModel().toArray()), 
																	   "Confirm Edit", 
																	   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							
					//Getting the delivery man values that don't need to be updated
					int id = model.getDeliverymansArray().get(selectedIndex).getId();
					String username = model.getDeliverymansArray().get(selectedIndex).getUsername();
					String password = model.getDeliverymansArray().get(selectedIndex).getPassword();
					int level = model.getDeliverymansArray().get(selectedIndex).getLevel();
							
					//Creating a new delivery man object
					DeliveryMan editDelivery = new DeliveryMan(id, username, password, firstname, lastname, phone, allAreas, level, "Active");
							
					//Calling the function to edit inside the array
					model.editDeliveryMan(editDelivery, selectedIndex);
							
					//Successful message after editing a delivery man
					JOptionPane.showMessageDialog(null, firstname + " " + lastname + " has been successfully edited", "Delivery Man Edit", JOptionPane.PLAIN_MESSAGE);
					
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
