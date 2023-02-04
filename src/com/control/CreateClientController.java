package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.model.Client;
import com.model.Database;
import com.view.CreateClient;
import com.view.Home;
import com.view.Login;

public class CreateClientController {
	private static CreateClient view;
	private static Database model;
	private Login login;

	
	//Creating empty constructor
	public CreateClientController() {};
	
	public CreateClientController(CreateClient view, Database model) {
		this.view = view;
		this.model = model;
		
		//Action Listener for the verify username button
		view.getVerifyBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean match = false;
				
				//Holding the username inside a variable
				String username = view.getUsername_textfield().getText();
				
				//Looping through the all users to see if there's a match
				for (int i = 0; i < model.getAllUsers().size(); i++) {
					if (model.getAllUsers().get(i).getUsername().equals(username)) {
						match = true;
					} 
				}
				
				//if there is a match that means the username is already taken
				if (match == true) {
					JOptionPane.showMessageDialog(null, "This username is already taken\nPlease try again", "Username Exists", JOptionPane.OK_OPTION);
				}else if (username.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter a username", "Error", JOptionPane.OK_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "This username is available!", "Valid Username", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		//Action listener for the save button
		view.getSaveBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean match = false;
				
				//Holding the username inside a variable
				String username = view.getUsername_textfield().getText();
				
				//Looping through the all users to see if there's a match
				for (int i = 0; i < model.getAllUsers().size(); i++) {
					if (model.getAllUsers().get(i).getUsername().equals(username)) {
						match = true;
					} 
				}
				
				//Holding all the textfields information inside variables
				String password = view.getPassword_textfield().getText();
				String confirmPassword = view.getConfirm_textfield().getText();
				String firstname = view.getFirstname_textfield().getText();
				String lastname = view.getLastname_textfield().getText();
				String address = view.getAddress_textfield().getText();
				String email = view.getEmail_textfield().getText();
				String phone = view.getPhone_textfield().getText();
				
				if (username.equals("") || password.equals("") || confirmPassword.equals("") || firstname.equals("") ||
						lastname.equals("") || address.equals("") || email.equals("") || phone.equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill all the textfields before submitting", "Error", JOptionPane.OK_OPTION);
				} else if (match == true) {
					JOptionPane.showMessageDialog(null, "This username is already taken\nPlease try again", "Username Exists", JOptionPane.OK_OPTION);
				} else if (firstname.length() < 3 || lastname.length() < 3 || username.length() < 3) {
					JOptionPane.showMessageDialog(null, "Firsname,lastname and username must be at least 3 characters", "Error", JOptionPane.OK_OPTION);
				} else if (password.length() < 5 || confirmPassword.length() < 5) {
					JOptionPane.showMessageDialog(null, "Password must be at least 5 characters", "Error", JOptionPane.OK_OPTION);
				} else if (!password.equals(confirmPassword)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match\nPlease try again", "Error", JOptionPane.OK_OPTION);
				} else if (!emailConfirm(email)) {
					JOptionPane.showMessageDialog(null, "Email pattern is not valid\nPlease try again", "Error", JOptionPane.OK_OPTION);
				} else if (JOptionPane.showConfirmDialog(null, "Confirm Information?\nUsername: " + username
																+ "\nFirst name: " + firstname
																+ "\nLast name: " + lastname
																+ "\nAddress: " + address
																+ "\nEmail: " + email
																+ "\nPhone number: " + phone,
																"Confirm Save",
																JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					//Creating a new client object
					Client createClient = new Client(7, username, password, firstname, lastname, email, phone, address, 5, "Active");
					
					//Adding the new client inside the client arraylist
					model.addNewClient(createClient);
					
					//Adding inside the all users arraylist
					model.addInsideUsers(createClient);
					
					//Successful message after creating the new client
					JOptionPane.showMessageDialog(null, firstname + " " + lastname + " has been successfully created\nPlease login", "New Client", JOptionPane.PLAIN_MESSAGE);
					
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
		
		//Action Listener for the return button
		this.view.getReturnBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the login page
				login = new Login();
				login.setLocationRelativeTo(null);
				login.setVisible(true);
				
				//Creating the login page controller
				LoginController loginController = new LoginController(login, model);
				
				//Hiding the create client page
				view.setVisible(false);
				
			}
		});
		
		//Action Listener for the quit button
		view.getQuitBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	//Method to validate the email entry
	public static boolean emailConfirm(String email) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPattern.matcher(email);
		return matcher.find();
	}
}
