package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.FlowLayout;

public class ClientEditAccount extends JFrame {

	private JTextField username_textfield;
	private JPasswordField old_password;
	private JPasswordField confirm_password;
	private JTextField firstname_textfield;
	private JTextField lastname_textfield;
	private JTextField address_textfield;
	private JTextField email_textfield;
	private JPasswordField new_password;
	private JTextField phone_textfield;
	private JButton saveBtn;
	
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
	public ClientEditAccount() {

		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.getContentPane().add(menuBar, BorderLayout.NORTH);
		
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
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(35, 47, 62));
		panel_1.setBorder(new EmptyBorder(7, 0, 0, 0));
		panel_1.setPreferredSize(new Dimension(10, 75));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblEditClientAccount = new JLabel("Edit Client Account");
		lblEditClientAccount.setForeground(Color.WHITE);
		lblEditClientAccount.setFont(new Font("Dialog", Font.BOLD, 35));
		panel_1.add(lblEditClientAccount);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(35, 47, 62));
		FlowLayout flowLayout = (FlowLayout) panel_1_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1_1.setPreferredSize(new Dimension(10, 75));
		panel_1_1.setBorder(new EmptyBorder(12, 0, 0, 0));
		panel.add(panel_1_1, BorderLayout.SOUTH);
		
		saveBtn = new JButton("Save");
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		saveBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		saveBtn.setBackground(new Color(255, 153, 0));
		panel_1_1.add(saveBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(250, 10));
		panel_3.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(30, 0, 80, 0));
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(9, 2, -130, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_1);
		
		username_textfield = new JTextField();
		username_textfield.setEnabled(false);
		username_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		username_textfield.setColumns(10);
		username_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(username_textfield);
		
		JLabel lblNewLabel_2 = new JLabel("Old Password:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_2);
		
		old_password = new JPasswordField();
		old_password.setFont(new Font("Dialog", Font.PLAIN, 20));
		old_password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(old_password);
		
		JLabel lblNewLabel_2_1 = new JLabel("New Password:");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_2_1);
		
		new_password = new JPasswordField();
		new_password.setFont(new Font("Dialog", Font.PLAIN, 20));
		new_password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(new_password);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);
		
		confirm_password = new JPasswordField();
		confirm_password.setFont(new Font("Dialog", Font.PLAIN, 20));
		confirm_password.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(confirm_password);
		
		JLabel lblNewLabel_4 = new JLabel("First name:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_4);
		
		firstname_textfield = new JTextField();
		firstname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		firstname_textfield.setColumns(10);
		firstname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(firstname_textfield);
		
		JLabel lblNewLabel_5 = new JLabel("Last name:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_5);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		lastname_textfield.setColumns(10);
		lastname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(lastname_textfield);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_6);
		
		address_textfield = new JTextField();
		address_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		address_textfield.setColumns(10);
		address_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(address_textfield);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_7);
		
		email_textfield = new JTextField();
		email_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		email_textfield.setColumns(10);
		email_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_4.add(email_textfield);
		
		JLabel lblNewLabel_8 = new JLabel("Phone number:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_8);
		
		try {
			MaskFormatter telephone = new MaskFormatter("(###)###-####");
			phone_textfield = new JFormattedTextField(telephone);
			phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			phone_textfield.setColumns(10);
			phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			panel_4.add(phone_textfield);
		} catch (ParseException e) {
			System.err.println("Enter your phone number in this format: ###-###-####");
		}
		
		this.setVisible(false);
		
	}

	/*
	 * Getters and Setters
	 * */
	public JTextField getUsername_textfield() {
		return username_textfield;
	}

	public void setUsername_textfield(JTextField username_textfield) {
		this.username_textfield = username_textfield;
	}

	public JPasswordField getOld_password() {
		return old_password;
	}

	public void setOld_password(JPasswordField old_password) {
		this.old_password = old_password;
	}

	public JPasswordField getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(JPasswordField confirm_password) {
		this.confirm_password = confirm_password;
	}

	public JTextField getFirstname_textfield() {
		return firstname_textfield;
	}

	public void setFirstname_textfield(JTextField firstname_textfield) {
		this.firstname_textfield = firstname_textfield;
	}

	public JTextField getLastname_textfield() {
		return lastname_textfield;
	}

	public void setLastname_textfield(JTextField lastname_textfield) {
		this.lastname_textfield = lastname_textfield;
	}

	public JTextField getAddress_textfield() {
		return address_textfield;
	}

	public void setAddress_textfield(JTextField address_textfield) {
		this.address_textfield = address_textfield;
	}

	public JTextField getEmail_textfield() {
		return email_textfield;
	}

	public void setEmail_textfield(JTextField email_textfield) {
		this.email_textfield = email_textfield;
	}

	public JPasswordField getNew_password() {
		return new_password;
	}

	public void setNew_password(JPasswordField new_password) {
		this.new_password = new_password;
	}

	public JTextField getPhone_textfield() {
		return phone_textfield;
	}

	public void setPhone_textfield(JTextField phone_textfield) {
		this.phone_textfield = phone_textfield;
	}

//	public JButton getVerifyBtn() {
//		return verifyBtn;
//	}
//
//	public void setVerifyBtn(JButton verifyBtn) {
//		this.verifyBtn = verifyBtn;
//	}

	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

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
