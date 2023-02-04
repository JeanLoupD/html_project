package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.InventoryDatabase;
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

public class ManagerEditStoreController {
	private static ManagerEditStore view;
	private static StoreDatabase storeDb;
	
	//Users database
	private Database model;
	
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	//Pages variables
	private ManagerEditStore managerEditStore;
	private ManagerCreateInventory managerCreateInventory;
	private ManagerEditInventory managerEditInventory;
	private ManagerDeleteInventory managerDeleteInventory;
	private ManagerEditDeliveryMan managerEditDelivery;
	private ManagerHome managerHome;
	private Home home;
	private Login login;
	
	//Selected index of the list
	private int selectedIndex;
	
	//Constructor
	public ManagerEditStoreController(ManagerEditStore view, StoreDatabase storeDb) {
		this.view = view;
		this.storeDb = storeDb;
		
		//To load all the stores inside the list when the page load
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
				
		//Key Listener for the delivery area text to be uppercase
		view.getArea_textfield().addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String areaText = view.getArea_textfield().getText();
				view.getArea_textfield().setText(areaText.toUpperCase());
			}
		});
				
		//Action Listener to add a new area
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
				
		//Action Listener for the confirm edit button
		view.getConfirmBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Holding every textfields information inside variables
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
						
				//Getting the store status
				String status = storeDb.getStoresArray().get(selectedIndex).getStatus();
						
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
				} else if (JOptionPane.showConfirmDialog(null, "Confirm edit?\nStore name: " + name
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
											fridayOpen, fridayClose, saturdayOpen, saturdayClose, status);
							
					//Calling the function to edit the store
					storeDb.editStoreObject(store, selectedIndex);

					//Successful message after editing a store
					JOptionPane.showMessageDialog(null, name + " has been successfully edited", "Store Edit", JOptionPane.PLAIN_MESSAGE);
							
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
