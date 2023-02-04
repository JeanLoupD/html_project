package com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.model.Admin;
import com.model.Database;
import com.model.Users;
import com.view.ClientHome;
import com.view.CreateClient;
import com.view.EditStore;
import com.view.Home;
import com.view.Login;
import com.view.ManagerHome;

public class LoginController {
	//Pages Variables
	private static Login view;
	private static Database model;
	private Home home;
	private CreateClient createClient;
	private ClientHome clientHome;
	private ManagerHome managerHome;
	
	
	public static int userLevel;
	
	public static String currentUser;
	
	//Creating empty constructor
	public LoginController() {};
	
	//Creating the constructor
	public LoginController(Login view, Database model) {
		this.view = view;
		this.model = model;
		
		//Action listener for the login button
		this.view.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = view.getPassword_textfield().getText();
				String username = view.getUsername_textfield().getText();
				
				//holding the username for other pages
				currentUser = username;
				
				//If username or password textfields are empty
				if (username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password to login", "Error", JOptionPane.OK_OPTION);
				} else {			
					//Calling the login function
					loginUser(username, password);
				}
				
			}
		});
		
		//Action Listener to call the new client page
		this.view.getNewClientBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Calling the create new client page
				createClient = new CreateClient();
				createClient.setLocationRelativeTo(null);
				createClient.setVisible(true);
				
				//Creating the controller for the create client page
				CreateClientController createClientController = new CreateClientController(createClient, model);
				
				//Hiding the login
				view.setVisible(false);
			}
		});
		
		//Action Listener for the quit button on the login page
		this.view.getQuitBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	//Function to login
	public void loginUser(String username, String password) {
		boolean match = false;
		
		//Looping through the array of admins
		for (Users a : model.getAllUsers()) {
			if (a.getUsername().equals(username) && a.getPassword().equals(password) && a.getStatus().equals("Active")) {
				userLevel = a.getLevel();
				match = true;

			}
		}
		
		if (match == true) {
			//Greeting the user
			JOptionPane.showMessageDialog(null, "Welcome " + username + " !", "Welcome", JOptionPane.PLAIN_MESSAGE);
			
			if (userLevel == 1) {
				//Bringing the user to the home page
				home = new Home();
				home.setLocationRelativeTo(null);
				home.setVisible(true);
				
				//Calling the home controller
				HomeController homeController = new HomeController(home);
				
				//Hiding the login page
				view.setVisible(false);
			} else if (userLevel == 2) {
				//Bringing the manager to the manager home page
				managerHome = new ManagerHome();
				managerHome.setLocationRelativeTo(null);
				managerHome.setVisible(true);
				
				//Creating the manger home page controller
				ManagerHomeController managerHomeController = new ManagerHomeController(managerHome);
				
				//Hiding the login page
				view.setVisible(false);
			} else if (userLevel == 5) {
				//Bringing the client to the client home page
				clientHome = new ClientHome();
				clientHome.setLocationRelativeTo(null);
				clientHome.setVisible(true);
				
				//Creating the client home page controller
				ClientHomeController clientHomeController = new ClientHomeController(clientHome);
				
				//Hiding the login page
				view.setVisible(false);
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Password and username don't match\nPlease try again", "Error", JOptionPane.OK_OPTION);
	
		}
	}
	
}
