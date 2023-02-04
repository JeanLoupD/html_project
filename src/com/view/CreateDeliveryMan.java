package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JList;

public class CreateDeliveryMan extends JFrame {
	private JTextField firstname_textfield;
	private JTextField phone_textfield;
	private JTextField username_textfield;
	private JPasswordField password_textfield;
	private JPasswordField confirm_textfield;
	private JTextField area_textfield;
	private JTextField lastname_textfield;
	private JButton confirmBtn;
	private JButton addAreaBtn;
	private JButton deleteAreaBtn;
	private DefaultListModel<String> area;
	private JList<String> area_textarea;
	
	//Menu bar variables
	private JMenuItem disconnect_menu;
	private JMenuItem quit_menu;
	private JMenuItem create_store;
	private JMenuItem edit_store;
	private JMenuItem delete_store;
	private JMenuItem create_inventory;
	private JMenuItem edit_inventory;
	private JMenuItem delete_inventory;
	private JMenuItem create_delivery;
	private JMenuItem edit_delivery;
	private JMenuItem delete_delivery;

	/**
	 * Create the application.
	 */
	public CreateDeliveryMan() {
	
		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu file_menu = new JMenu("File");
		menuBar.add(file_menu);
		
		disconnect_menu = new JMenuItem("Disconnect");
		file_menu.add(disconnect_menu);
		
		quit_menu = new JMenuItem("Quit");
		file_menu.add(quit_menu);
		
		JMenu store_menu = new JMenu("Store");
		menuBar.add(store_menu);
		
		create_store = new JMenuItem("Create Store");
		store_menu.add(create_store);
		
		edit_store = new JMenuItem("Edit Store");
		store_menu.add(edit_store);
		
		delete_store = new JMenuItem("Delete Store");
		store_menu.add(delete_store);
		
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
		
		create_delivery = new JMenuItem("Create Delivery Man");
		delivery_menu.add(create_delivery);
		
		edit_delivery = new JMenuItem("Edit Delivery Man");
		delivery_menu.add(edit_delivery);
		
		delete_delivery = new JMenuItem("Delete Delivery Man");
		delivery_menu.add(delete_delivery);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 47, 62));
		panel.setBorder(new EmptyBorder(7, 0, 0, 0));
		panel.setPreferredSize(new Dimension(10, 75));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Create Delivery Man");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 35));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		getContentPane().add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(35, 47, 62));
		panel_9.setPreferredSize(new Dimension(10, 75));
		panel_2.add(panel_9, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(250, 10));
		getContentPane().add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(35, 47, 62));
		panel_10.setPreferredSize(new Dimension(10, 75));
		panel_3.add(panel_10, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_5.setPreferredSize(new Dimension(10, 300));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(6, 2, -130, 20));
		
		JLabel lblNewLabel_1 = new JLabel("First name:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_1);
		
		firstname_textfield = new JTextField();
		firstname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		firstname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(firstname_textfield);
		firstname_textfield.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Last name:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_7);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		lastname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lastname_textfield);
		lastname_textfield.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone number:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_2);
		
		try {
			MaskFormatter telephone = new MaskFormatter("(###)###-####");
			phone_textfield = new JFormattedTextField(telephone);
			phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			phone_textfield.setText("(  )  -");
			phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			panel_5.add(phone_textfield);
			phone_textfield.setColumns(10);
		} catch (ParseException e) {
			System.err.println("Enter your phone number in this format: ###-###-####");
		}
		
		JLabel lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_3);
		
		username_textfield = new JTextField();
		username_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		username_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(username_textfield);
		username_textfield.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_4);
		
		password_textfield = new JPasswordField();
		password_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		password_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(password_textfield);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm password:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(lblNewLabel_5);
		
		confirm_textfield = new JPasswordField();
		confirm_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		confirm_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_5.add(confirm_textfield);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(35, 47, 62));
		panel_1.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_1.setPreferredSize(new Dimension(10, 75));
		panel_4.add(panel_1, BorderLayout.SOUTH);
		
		confirmBtn = new JButton("Confirm Create");
		confirmBtn.setBackground(new Color(255, 153, 0));
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		confirmBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(confirmBtn);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 0, 50, 0));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("Delivery Area");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_7.add(lblNewLabel_6);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(7, 0, 0, 0));
		panel_8.setPreferredSize(new Dimension(10, 60));
		panel_6.add(panel_8, BorderLayout.SOUTH);
		
		area_textfield = new JTextField();
		area_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(area_textfield);
		area_textfield.setColumns(3);
		
		addAreaBtn = new JButton("Add");
		addAreaBtn.setBackground(new Color(255, 216, 20));
		addAreaBtn.setForeground(Color.WHITE);
		addAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		addAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_8.add(addAreaBtn);
		
		deleteAreaBtn = new JButton("Delete");
		deleteAreaBtn.setBackground(new Color(255, 0, 0));
		deleteAreaBtn.setForeground(Color.WHITE);
		deleteAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		deleteAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_8.add(deleteAreaBtn);
		
		area = new DefaultListModel<String>();
		area_textarea = new JList<>(area);
		area_textarea.setFont(new Font("Dialog", Font.PLAIN, 20));
		area_textarea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_6.add(area_textarea, BorderLayout.CENTER);
		
		this.setVisible(true);
	}

	/*
	 * Getters and Setters
	 * */
	public JTextField getFirstname_textfield() {
		return firstname_textfield;
	}

	public void setFirstname_textfield(JTextField firstname_textfield) {
		this.firstname_textfield = firstname_textfield;
	}

	public JTextField getPhone_textfield() {
		return phone_textfield;
	}

	public void setPhone_textfield(JTextField phone_textfield) {
		this.phone_textfield = phone_textfield;
	}

	public JTextField getUsername_textfield() {
		return username_textfield;
	}

	public void setUsername_textfield(JTextField username_textfield) {
		this.username_textfield = username_textfield;
	}

	public JPasswordField getPassword_textfield() {
		return password_textfield;
	}

	public void setPassword_textfield(JPasswordField password_textfield) {
		this.password_textfield = password_textfield;
	}

	public JPasswordField getConfirm_textfield() {
		return confirm_textfield;
	}

	public void setConfirm_textfield(JPasswordField confirm_textfield) {
		this.confirm_textfield = confirm_textfield;
	}

	public JTextField getArea_textfield() {
		return area_textfield;
	}

	public void setArea_textfield(JTextField area_textfield) {
		this.area_textfield = area_textfield;
	}

	public JTextField getLastname_textfield() {
		return lastname_textfield;
	}

	public void setLastname_textfield(JTextField lastname_textfield) {
		this.lastname_textfield = lastname_textfield;
	}

	public JButton getConfirmBtn() {
		return confirmBtn;
	}

	public void setConfirmBtn(JButton confirmBtn) {
		this.confirmBtn = confirmBtn;
	}

	public JButton getAddAreaBtn() {
		return addAreaBtn;
	}

	public void setAddAreaBtn(JButton addAreaBtn) {
		this.addAreaBtn = addAreaBtn;
	}

	public JButton getDeleteAreaBtn() {
		return deleteAreaBtn;
	}

	public void setDeleteAreaBtn(JButton deleteAreaBtn) {
		this.deleteAreaBtn = deleteAreaBtn;
	}

	public DefaultListModel<String> getArea() {
		return area;
	}

	public void setArea(DefaultListModel<String> area) {
		this.area = area;
	}

	public JList<String> getArea_textarea() {
		return area_textarea;
	}

	public void setArea_textarea(JList<String> area_textarea) {
		this.area_textarea = area_textarea;
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

	public JMenuItem getCreate_store() {
		return create_store;
	}

	public void setCreate_store(JMenuItem create_store) {
		this.create_store = create_store;
	}

	public JMenuItem getEdit_store() {
		return edit_store;
	}

	public void setEdit_store(JMenuItem edit_store) {
		this.edit_store = edit_store;
	}

	public JMenuItem getDelete_store() {
		return delete_store;
	}

	public void setDelete_store(JMenuItem delete_store) {
		this.delete_store = delete_store;
	}

	public JMenuItem getCreate_inventory() {
		return create_inventory;
	}

	public void setCreate_inventory(JMenuItem create_inventory) {
		this.create_inventory = create_inventory;
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

	public JMenuItem getCreate_delivery() {
		return create_delivery;
	}

	public void setCreate_delivery(JMenuItem create_delivery) {
		this.create_delivery = create_delivery;
	}

	public JMenuItem getEdit_delivery() {
		return edit_delivery;
	}

	public void setEdit_delivery(JMenuItem edit_delivery) {
		this.edit_delivery = edit_delivery;
	}

	public JMenuItem getDelete_delivery() {
		return delete_delivery;
	}

	public void setDelete_delivery(JMenuItem delete_delivery) {
		this.delete_delivery = delete_delivery;
	}

	
	
}
