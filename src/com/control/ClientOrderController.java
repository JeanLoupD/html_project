package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.model.Database;
import com.model.Inventory;
import com.model.InventoryDatabase;
import com.model.InventoryItems;
import com.model.OrderDatabase;
import com.model.Orders;
import com.model.Store;
import com.model.StoreDatabase;
import com.view.ClientDeleteAccount;
import com.view.ClientEditAccount;
import com.view.ClientHome;
import com.view.ClientOrderHistory;
import com.view.ClientOrderInventory;
import com.view.Login;

public class ClientOrderController {
	private static ClientOrderInventory view;
	
	//Database variables
	private Database model;
	private StoreDatabase storeDb;
	private InventoryDatabase inventoryDb;
	private OrderDatabase orderDb;
	
	//Pages variables
	private LoginController loginCon = new LoginController();
	private Login login;
	private ClientHome clientHome;
	private ClientEditAccount clientEditAccount;
	private ClientDeleteAccount clientDeleteAccount;
	private ClientOrderInventory clientOrderInventory;
	private ClientOrderHistory clientOrderHistory;
	
	//Selected index of the store list
	private int selectedIndex;
	private int selectItemIndex;
	private String storeName;
	private String items;
	private String price;
	
	private String nameTest;
	private int selectedIndexTest;
	
	private double grandTotal;
	
	private String date;
	private String time;
	private String area;
	private String address;
	
	private String allItemsArray = "";
	
	//Constructor
	public ClientOrderController(ClientOrderInventory view, StoreDatabase storeDb) {
		this.view = view;
		this.storeDb = storeDb;
		
		//To load all the stores inside the list when the page load
		for (Store s : storeDb.getStoresArray()) {
			String name = s.getName();
			
			view.getStoreModel().addElement(name);
		}
		
		//List listener to fill the inventory list based on the selected store
		view.getStoreList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				nameTest = view.getStoreList().getSelectedValue();
				view.getInventoryModel().removeAllElements();
				if (!e.getValueIsAdjusting()) {
					String selectedStore = view.getStoreList().getSelectedValue();
					view.getInventoryModel().clear();

					// Find the selected store in the inventoryArray
					for (Inventory inventory : inventoryDb.getInventoryArray()) {
						if (inventory.getStoreName().equals(selectedStore)) {
							for (InventoryItems item : inventory.getInventoryItems()) {
								view.getInventoryModel().addElement(item.getItem() + " - " + item.getPrice());
			                }
						}
					}
				}
				
			
			}
		});
		
		//List listener to fill the item and price textfield based on the selected item
		view.getInventoryList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
				    //String selectedStore = view.getInventoryList().getSelectedValue();
				    selectedIndexTest = view.getInventoryList().getSelectedIndex();

				    // Find the selected store in the inventoryArray
				    for (Inventory inventory : inventoryDb.getInventoryArray()) {
				        if (inventory.getStoreName().equals(nameTest)) {
				            for (InventoryItems item : inventory.getInventoryItems()) {
				                if (inventory.getInventoryItems().indexOf(item) == selectedIndexTest) {
				                    view.getItem_textfield().setText(item.getItem());
				                    view.getPrice_textfield().setText(item.getPrice());
				                }
				            }
				        }
				    }
				}
				
			}
		});
		
		//Action Listener for the add button
		view.getAddBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qty = view.getQuantity_textfield().getText();
				String item = view.getItem_textfield().getText();
				String price = view.getPrice_textfield().getText();
				
				if (item.equals("") || price.equals("") || qty.equals("")) {
					JOptionPane.showMessageDialog(null, "Please select an item and enter the quantity you want to order", "Error", JOptionPane.OK_OPTION);
				} else if (Integer.valueOf(qty) < 1 || Integer.valueOf(qty) > 10) {
					JOptionPane.showMessageDialog(null, "Quantity must be between 1 and 10", "Error", JOptionPane.OK_OPTION);
				} else {
					//Getting the total for the item
					double total = Integer.valueOf(qty) * Double.valueOf(price);
					
					//Keeping the total of everything
					grandTotal += total;
					
					//Printing the total in the textfield
					view.getTotal_textfield().setText(Double.toString(grandTotal));
					
					//Printing the selected item inside the jlist
					view.getOrderModel().addElement(item + " " + price + " Quantity: " + qty + " Total: " + total);
					
					//Clearing all textfields
					view.getItem_textfield().setText("");
					view.getPrice_textfield().setText("");
					view.getQuantity_textfield().setText("");
				}
				
			}
		});
		
		//Action listener for the delete button
		view.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int delIndex = view.getOrderList().getSelectedIndex();
				
				view.getItem_textfield().setText("");
				view.getPrice_textfield().setText("");
				view.getQuantity_textfield().setText("");
				
				String wtv = view.getOrderList().getSelectedValue();
				String wtv2[] = wtv.split(" ");
				double wtv3 = Double.valueOf(wtv2[5]);
				
				grandTotal -= wtv3;		
				
				//Reprinting the new grand total
				view.getTotal_textfield().setText(String.valueOf(grandTotal));

				if (selectItemIndex != -1) {
					view.getOrderModel().remove(delIndex);
				}
			}
		});
		
		//Action Listener for the order button
		view.getOrderBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				date = view.getDate_textfield().getText();
				time = view.getTime_combo().getSelectedItem().toString();
				area = view.getPostal_textfield().getText();
				
				String allItems = "";
				for (int i = 0; i < view.getOrderList().getModel().getSize(); i++) {
					allItems += view.getOrderList().getModel().getElementAt(i) + "\n";
					allItemsArray += view.getOrderList().getModel().getElementAt(i) + ",";
				}
				
				if (date.equals("") || time.equals("") || area.equals("") || view.getOrderList().getModel().getSize() == 0) {
					JOptionPane.showMessageDialog(null, "Please enter the date, the time, the area and add the items you want to order", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Confirm Order?\nItems: " + allItems, "Confirm Order", 
																JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					//Input the user for his address
					address = JOptionPane.showInputDialog(null, "Enter the delivery address:");
					
					if (JOptionPane.showConfirmDialog(null, "Delivery Information\nDate: " + date + " " + time + " EST"
															+ "\nPostal code: " + area
															+ "\nAddress: " + address
															+ "\nWould you like the order to be delivered at this address?",
															"Delivery Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						
						JOptionPane.showMessageDialog(null, "The amount due is: " + grandTotal + "$");
						
						//Creating the order object
						Orders newOrder = new Orders(nameTest, date, time, area, allItemsArray);
						
						//Calling the function to add the order object inside the all orders arraylist
						orderDb.addAllOrders(newOrder);
						
						//Redirecting the user to the client home page
						clientHome = new ClientHome();
						clientHome.setLocationRelativeTo(null);
						clientHome.setVisible(true);
						
						//Calling the home controller
						ClientHomeController clientHomeController = new ClientHomeController(clientHome);
						
						//Hiding the order inventory page
						view.setVisible(false);
					}
				}
			}
		});
		
	/*********************** File Menu *************************/
		
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
		
		/********************* End File Menu ***********************/
		
		/********************* Account Menu ************************/
		
		//Action listener for the edit account menu button
		view.getEditAccount_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the client edit account page
				clientEditAccount = new ClientEditAccount();
				clientEditAccount.setLocationRelativeTo(null);
				clientEditAccount.setVisible(true);
				
				//Creating the edit account controller
				ClientEditAccountController clientEditAccountController = new ClientEditAccountController(clientEditAccount, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the delete account menu button
		view.getCloseAccount_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientDeleteAccount = new ClientDeleteAccount();
				clientDeleteAccount.setLocationRelativeTo(null);
				clientDeleteAccount.setVisible(true);
				
				//Creating the delete account controller
				ClientDeleteAccountController clientDeleteAccountController = new ClientDeleteAccountController(clientDeleteAccount, model);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/******************* End Account Menu **********************/
		
		/********************** Shop Menu **************************/
		
		//Action Listener for the order inventory page
		view.getOrderItem_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrderInventory = new ClientOrderInventory();
				clientOrderInventory.setLocationRelativeTo(null);
				clientOrderInventory.setVisible(true);
				
				//Creating the client order inventory controller
				ClientOrderController clientOrderController = new ClientOrderController(clientOrderInventory, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		//Action Listener for the order history page
		view.getOrderHistory_menu().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientOrderHistory = new ClientOrderHistory();
				clientOrderHistory.setLocationRelativeTo(null);
				clientOrderHistory.setVisible(true);
				
				//Creating the client order history controller
				ClientOrderHistoryController clientOrderHistoryController = new ClientOrderHistoryController(clientOrderHistory, storeDb);
				
				//Hiding the home page
				view.setVisible(false);
			}
		});
		
		/******************** End Shop Menu ************************/
	}
}
