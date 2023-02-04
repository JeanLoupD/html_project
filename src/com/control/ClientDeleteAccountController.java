package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.model.Database;
import com.model.InventoryDatabase;
import com.model.StoreDatabase;
import com.view.ClientDeleteAccount;
import com.view.ClientEditAccount;
import com.view.ClientOrderHistory;
import com.view.ClientOrderInventory;
import com.view.Login;

public class ClientDeleteAccountController {
	private static ClientDeleteAccount view;
	private static Database model;
	
	//Page variables
	private Login login;
	private ClientEditAccount clientEditAccount;
	private ClientDeleteAccount clientDeleteAccount;
	private ClientOrderInventory clientOrderInventory;
	private ClientOrderHistory clientOrderHistory;
	
	//Store Database
	private StoreDatabase storeDb;
		
	//Inventory Database
	private InventoryDatabase inventoryDb;
	
	private LoginController loginCon = new LoginController();
	private int index;
	private String username = "";
	private String firstname = "";
	private String lastname = "";
	private String oldPassword = "";
	private String address = "";
	private String email = "";
	private String phone = "";
	
	//Constructor
	public ClientDeleteAccountController(ClientDeleteAccount view, Database model) {
		this.view = view;
		this.model = model;
		
		boolean match = false;
				
		//Holding the username inside a variable
		username = loginCon.currentUser;
				
		//Looping through the all users to see if there's a match	
		for (int i = 0; i < model.getClientsArray().size(); i++) {
			if (model.getClientsArray().get(i).getUsername().equals(username)) {
				match = true;
						
				index = i;
				firstname = model.getClientsArray().get(i).getFirstname();
				lastname = model.getClientsArray().get(i).getLastname();
				oldPassword = model.getClientsArray().get(i).getPassword();
				address = model.getClientsArray().get(i).getAddress();
				email = model.getClientsArray().get(i).getEmail();
				phone = model.getClientsArray().get(i).getPhone();

			}
		}
				
		if (match != true) {
			JOptionPane.showMessageDialog(null, "Username dont exist please try again", "Error", JOptionPane.OK_OPTION);
		} else {
			view.getUsername_textfield().setText(username);
			view.getFirstname_textfield().setText(firstname);
			view.getLastname_textfield().setText(lastname);
			view.getAddress_textfield().setText(address);
			view.getEmail_textfield().setText(email);
			view.getPhone_textfield().setText(phone);
		}

		
		//Action Listener for the delete account button
		view.getDeleteBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (view.getFirstname_textfield().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please select your profile before deleting", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?",
																"Delete Profile",
																JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					//Calling the function to delete the client
					model.deleteClient(index);
					
					//Looping to find the client inside the all users account
					for (int i = 0; i < model.getAllUsers().size(); i++) {
						if (model.getAllUsers().get(i).getUsername().equals(username)) {
							//Calling the function to delete client inside all user arraylist
							model.deleteInsideUsers(i);
						}
					}
					
					//Successful message after creating the new client
					JOptionPane.showMessageDialog(null, "Your profile has been successfully deleted", "Delete Account", JOptionPane.PLAIN_MESSAGE);
					
					//Redirecting the user to the home page
					login = new Login();
					login.setLocationRelativeTo(null);
					login.setVisible(true);
					
					//Creating the login page controller
					LoginController loginController = new LoginController(login, model);
					
					//Hiding the create delivery man page
					view.setVisible(false);
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
