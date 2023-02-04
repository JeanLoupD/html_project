package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClientHome extends JFrame {
	
	//Menu bar variables
	private JMenuItem disconnect_menu;
	private JMenuItem quit_menu;
	private JMenuItem editAccount_menu;
	private JMenuItem closeAccount_menu;
	private JMenuItem orderItem_menu;
	private JMenuItem orderHistory_menu;
	
	/**
	 * Create the application.
	 */
	public ClientHome() {

		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		disconnect_menu = new JMenuItem("Disconnect");
		mnNewMenu.add(disconnect_menu);
		
		quit_menu = new JMenuItem("Quit");
		mnNewMenu.add(quit_menu);
		
		JMenu mnNewMenu_1 = new JMenu("Account");
		menuBar.add(mnNewMenu_1);
		
		editAccount_menu = new JMenuItem("Edit Account");
		mnNewMenu_1.add(editAccount_menu);
		
		closeAccount_menu = new JMenuItem("Close Account");
		mnNewMenu_1.add(closeAccount_menu);
		
		JMenu shop_menu = new JMenu("Shop");
		menuBar.add(shop_menu);
		
		orderItem_menu = new JMenuItem("Order Items");
		shop_menu.add(orderItem_menu);
		
		orderHistory_menu = new JMenuItem("Order History");
		shop_menu.add(orderHistory_menu);
		
		JLabel lblNewLabel = new JLabel("Client Home Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 60));
		this.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
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

	public JMenuItem getEditAccount_menu() {
		return editAccount_menu;
	}

	public void setEditAccount_menu(JMenuItem editAccount_menu) {
		this.editAccount_menu = editAccount_menu;
	}

	public JMenuItem getCloseAccount_menu() {
		return closeAccount_menu;
	}

	public void setCloseAccount_menu(JMenuItem closeAccount_menu) {
		this.closeAccount_menu = closeAccount_menu;
	}

	public JMenuItem getOrderItem_menu() {
		return orderItem_menu;
	}

	public void setOrderItem_menu(JMenuItem orderItem_menu) {
		this.orderItem_menu = orderItem_menu;
	}

	public JMenuItem getOrderHistory_menu() {
		return orderHistory_menu;
	}

	public void setOrderHistory_menu(JMenuItem orderHistory_menu) {
		this.orderHistory_menu = orderHistory_menu;
	}
	
	

}
