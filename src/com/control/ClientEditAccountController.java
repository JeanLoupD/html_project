package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.model.Client;
import com.model.Database;
import com.model.InventoryDatabase;
import com.model.StoreDatabase;
import com.view.ClientDeleteAccount;
import com.view.ClientEditAccount;
import com.view.ClientOrderHistory;
import com.view.ClientOrderInventory;
import com.view.Login;

public class ClientEditAccountController {
	private static ClientEditAccount view;
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
	private String editUsername = "";
	private String firstname = "";
	private String lastname = "";
	private String oldPassword = "";
	private String address = "";
	private String email = "";
	private String phone = "";
	
	//Constructor
	public ClientEditAccountController(ClientEditAccount view, Database model) {
		this.view = view;
		this.model = model;
		
		//Load all the textfields when client load edit account page
		boolean match = false;
				
		//Holding the username inside a variable
		username = loginCon.currentUser;
		
		//Looping through the all users to see if there's a match	
		for (int i = 0; i < model.getClientsArray().size(); i++) {
			if (model.getClientsArray().get(i).getUsername().equals(username)) {
				match = true;
						
				index = i;
				editUsername = model.getClientsArray().get(i).getUsername();
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
			view.getUsername_textfield().setText(editUsername);
			view.getFirstname_textfield().setText(firstname);
			view.getLastname_textfield().setText(lastname);
			view.getAddress_textfield().setText(address);
			view.getEmail_textfield().setText(email);
			view.getPhone_textfield().setText(phone);
		}

		
		//Action Listener for the save button
		view.getSaveBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String editOldPassword = view.getOld_password().getText();
				String newPassword = view.getNew_password().getText();
				String confirmPassword = view.getConfirm_password().getText();
				String editFirstname = view.getFirstname_textfield().getText();
				String editLastname = view.getLastname_textfield().getText();
				String editAddress = view.getAddress_textfield().getText();
				String editEmail = view.getEmail_textfield().getText();
				String editPhone = view.getPhone_textfield().getText();
				
				if (editFirstname.equals("") || editLastname.equals("") || editAddress.equals("") || editEmail.equals("") || editPhone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the textfields before submitting", "Error", JOptionPane.OK_OPTION);
				} else if (!editOldPassword.equals(oldPassword)) {
					JOptionPane.showMessageDialog(null, "Your current password is incorrect", "Error", JOptionPane.OK_OPTION);
				} else if (firstname.length() < 3 || lastname.length() < 3) {
					JOptionPane.showMessageDialog(null, "Firsname and lastname must be at least 3 characters", "Error", JOptionPane.OK_OPTION);
				} else if (newPassword.length() < 5 || confirmPassword.length() < 5) {
					JOptionPane.showMessageDialog(null, "Password must be at least 5 characters", "Error", JOptionPane.OK_OPTION);
				} else if (!newPassword.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match\nPlease try again", "Error", JOptionPane.OK_OPTION);
				} else if (!emailConfirm(editEmail)) {
					JOptionPane.showMessageDialog(null, "Email pattern is not valid\nPlease try again", "Error", JOptionPane.OK_OPTION);
				} else if (editOldPassword.equals("") && newPassword.equals("") && confirmPassword.equals("")) {
					editOldPassword = oldPassword;
				} else if (JOptionPane.showConfirmDialog(null, "Confirm Edit Information?\nFirst name " + editFirstname
																+ "\nLast name: " + editLastname
																+ "\nAddress: " + editAddress
																+ "\nEmail: " + editEmail
																+ "\nPhone number: " + editPhone,
																"Confirm Edit Information",
																JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					

					//Create a new client object
					Client editClient = new Client(7, username, confirmPassword, editFirstname, editLastname, editEmail, editPhone, editAddress, 5, "Active");
					
					//Calling the edit client function
					model.editClient(editClient, index);
					
					//Looping to edit inside the all users array list
					for (int i = 0; i < model.getAllUsers().size(); i++) {
						if (model.getAllUsers().get(i).getUsername().equals(username)) {
							model.editInsideUsers(editClient, i);

						}
					}
					
					//Successful message after creating the new client
					JOptionPane.showMessageDialog(null, editFirstname + " " + editLastname + "  profile has been successfully edited\nPlease login", "Edit Client", JOptionPane.PLAIN_MESSAGE);
					
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
	
	//Method to validate the email entry
	public static boolean emailConfirm(String email) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(email);
		return matcher.find();
	}
}
