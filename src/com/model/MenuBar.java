package com.model;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.control.HomeController;
import com.control.LoginController;

public class MenuBar {
	private JMenuBar menuBarMain;
	
	public JMenuBar createBar() {
		 JMenuBar menuBarFile = new JMenuBar();
	        JMenu menuFile = new JMenu("File//////////////");

	        JMenuItem disconnect_menu = new JMenuItem("Disconnect/////////////");

	        JMenuItem menuItemQuit = new JMenuItem("Quit");

	        //add items to file option
	        menuFile.add(disconnect_menu);
	        menuFile.add(menuItemQuit);

	        //add file restaurant, food menu & delivery menu to admin menu bar
	        menuBarFile.add(menuFile);
	        return menuBarFile;
	}
	
	private JMenuBar createAdminMenu() {
		 JMenuBar menuBarFile = new JMenuBar();
	        JMenu menuFile = new JMenu("File");

	        JMenuItem menuItemDisconnect = new JMenuItem("TESTING");

	        JMenuItem menuItemQuit = new JMenuItem("TESTINT");

	        //add items to file option
	        menuFile.add(menuItemDisconnect);
	        menuFile.add(menuItemQuit);

	        //add file restaurant, food menu & delivery menu to admin menu bar
	        menuBarFile.add(menuFile);
	        return menuBarFile;
	}
	
	public JMenuBar menuLevel() {
		 menuBarMain = new JMenuBar();
	        menuBarMain.add(createBar());
//	        switch (LoginController.userLevel) {
//	            case 1:
//	                menuBarMain.add(createAdminMenu());
//	                break;
//	            case 2:
//	                menuBarMain.add(createManagerMenu());
//	                break;
//	            case 3:
//	                menuBarMain.add(createChefMenu());
//	                break;
//	            case 4:
//	                menuBarMain.add(createDeliveryMenu());
//	                break;
//	            case 5:
//	                menuBarMain.add(createUserMenu());
//	                break;
//	            default:
//	                break;
//	        }

	        return menuBarMain;
	}
}
