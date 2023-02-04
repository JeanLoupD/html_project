package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

public class ManagerHome extends JFrame {

	//Menu Bar Variables
	private JMenuItem disconnect_menu;
	private JMenuItem quit_menu;
	private JMenuItem edit_store;
	private JMenuItem edit_inventory;
	private JMenuItem delete_inventory;
	private JMenuItem edit_delivery;
	private JMenuItem vieworder_menu;
	private JMenuItem create_inventory;


	/**
	 * Create the application.
	 */
	public ManagerHome() {
	
		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu file_menu = new JMenu("File");
		menuBar.add(file_menu);
		
		disconnect_menu = new JMenuItem("Disconnect");
		file_menu.add(disconnect_menu);
		
		quit_menu = new JMenuItem("Quit");
		file_menu.add(quit_menu);
		
		JMenu store_menu = new JMenu("Store");
		menuBar.add(store_menu);
		
		edit_store = new JMenuItem("Edit Store");
		store_menu.add(edit_store);
		
		vieworder_menu = new JMenuItem("View Store Order");
		store_menu.add(vieworder_menu);
		
		JMenu inventory_menu = new JMenu("Inventory");
		menuBar.add(inventory_menu);
		
		create_inventory = new JMenuItem("Create Inventory");
		inventory_menu.add(create_inventory);
		
		edit_inventory = new JMenuItem("Edit Inventory");
		inventory_menu.add(edit_inventory);
		
		delete_inventory = new JMenuItem("Delete Inventory");
		inventory_menu.add(delete_inventory);
		
		JMenu delivery_menu = new JMenu("Delivery Man");
		menuBar.add(delivery_menu);
		
		edit_delivery = new JMenuItem("Edit Delivery Man");
		delivery_menu.add(edit_delivery);
		
		JPanel title_panel = new JPanel();
		title_panel.setPreferredSize(new Dimension(10, 100));
		title_panel.setBorder(new EmptyBorder(10, 0, 0, 0));
		this.getContentPane().add(title_panel, BorderLayout.CENTER);
		
		JLabel home_title = new JLabel("Manager Home Page");
		home_title.setFont(new Font("Dialog", Font.BOLD, 60));
		title_panel.add(home_title);
		
		this.setVisible(false);
	}

	/*
	 * Getters and Setters
	 * */
	public JMenuItem getDisconnect_menu() {
		return disconnect_menu;
	}


	public void setDisconnect_menu(JMenuItem disconnect_menu) {
		this.disconnect_menu = disconnect_menu;
	}


	public JMenuItem getQuit_menu() {
		return quit_menu;
	}


	public void setQuit_menu(JMenuItem quit_menu) {
		this.quit_menu = quit_menu;
	}


	public JMenuItem getEdit_store() {
		return edit_store;
	}


	public void setEdit_store(JMenuItem edit_store) {
		this.edit_store = edit_store;
	}


	public JMenuItem getEdit_inventory() {
		return edit_inventory;
	}


	public void setEdit_inventory(JMenuItem edit_inventory) {
		this.edit_inventory = edit_inventory;
	}


	public JMenuItem getDelete_inventory() {
		return delete_inventory;
	}


	public void setDelete_inventory(JMenuItem delete_inventory) {
		this.delete_inventory = delete_inventory;
	}


	public JMenuItem getEdit_delivery() {
		return edit_delivery;
	}


	public void setEdit_delivery(JMenuItem edit_delivery) {
		this.edit_delivery = edit_delivery;
	}


	public JMenuItem getVieworder_menu() {
		return vieworder_menu;
	}


	public void setVieworder_menu(JMenuItem vieworder_menu) {
		this.vieworder_menu = vieworder_menu;
	}

	public JMenuItem getCreate_inventory() {
		return create_inventory;
	}

	public void setCreate_inventory(JMenuItem create_inventory) {
		this.create_inventory = create_inventory;
	}
	
	

}
