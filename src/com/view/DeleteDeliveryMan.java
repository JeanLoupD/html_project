package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class DeleteDeliveryMan extends JFrame {

	private JTextField firstname_textfield;
	private JTextField phone_textfield;
	private JTextField textField_2;
	private JTextField lastname_textfield;
	private JButton selectBtn;
	private JButton deleteBtn;
	private DefaultListModel<String> deliveryManModel;
	private JList<String> deliveryManList;
	private DefaultListModel<String> areaModel;
	private JList<String> areaList;
	
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
	public DeleteDeliveryMan() {

		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 47, 62));
		panel.setBorder(new EmptyBorder(0, 10, 10, 10));
		panel.setPreferredSize(new Dimension(350, 10));
		this.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(35, 47, 62));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Delivery Man");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(lblNewLabel);
		
		selectBtn = new JButton("Select");
		selectBtn.setPreferredSize(new Dimension(59, 50));
		selectBtn.setForeground(Color.WHITE);
		selectBtn.setBackground(new Color(255, 216, 20));
		selectBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel.add(selectBtn, BorderLayout.SOUTH);
		
		deliveryManModel = new DefaultListModel<String>();
		deliveryManList = new JList<>(deliveryManModel);
		deliveryManList.setFont(new Font("Dialog", Font.PLAIN, 20));
		deliveryManList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel.add(deliveryManList, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		this.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(35, 47, 62));
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Delivery Man");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(75, 10));
		panel_2.add(panel_4, BorderLayout.WEST);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(35, 47, 62));
		panel_12.setPreferredSize(new Dimension(10, 60));
		panel_4.add(panel_12, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(75, 10));
		panel_2.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(35, 47, 62));
		panel_13.setPreferredSize(new Dimension(10, 60));
		panel_5.add(panel_13, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setPreferredSize(new Dimension(10, 200));
		panel_8.setBorder(new EmptyBorder(25, 0, 25, 0));
		panel_6.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new GridLayout(3, 2, -150, 20));
		
		JLabel lblNewLabel_2 = new JLabel("First name:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_2);
		
		firstname_textfield = new JTextField();
		firstname_textfield.setEnabled(false);
		firstname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		firstname_textfield.setColumns(10);
		firstname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_8.add(firstname_textfield);
		
		JLabel lblNewLabel_5 = new JLabel("Last name:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_5);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setEnabled(false);
		lastname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		lastname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lastname_textfield);
		lastname_textfield.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone number:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_3);
		
		phone_textfield = new JTextField();
		phone_textfield.setEnabled(false);
		phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		phone_textfield.setColumns(10);
		phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_8.add(phone_textfield);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(35, 47, 62));
		panel_7.setPreferredSize(new Dimension(10, 60));
		panel_7.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_6.add(panel_7, BorderLayout.SOUTH);
		
		deleteBtn = new JButton("Delete Delivery Man");
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setBackground(new Color(255, 0, 0));
		deleteBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		deleteBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_7.add(deleteBtn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(0, 0, 50, 0));
		panel_6.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Delivery Area");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_10.add(lblNewLabel_4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(10, 60));
		panel_11.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_9.add(panel_11, BorderLayout.SOUTH);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_2.setColumns(3);
		panel_11.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(255, 216, 20));
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_2.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_11.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_11.add(btnNewButton_3);
		
		areaModel = new DefaultListModel<String>();
		areaList = new JList<>(areaModel);
		areaList.setEnabled(false);
		areaList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		areaList.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_9.add(areaList, BorderLayout.CENTER);
		
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
		
		this.setVisible(false);
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

	public JTextField getLastname_textfield() {
		return lastname_textfield;
	}

	public void setLastname_textfield(JTextField lastname_textfield) {
		this.lastname_textfield = lastname_textfield;
	}

	public JButton getSelectBtn() {
		return selectBtn;
	}

	public void setSelectBtn(JButton selectBtn) {
		this.selectBtn = selectBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public DefaultListModel<String> getDeliveryManModel() {
		return deliveryManModel;
	}

	public void setDeliveryManModel(DefaultListModel<String> deliveryManModel) {
		this.deliveryManModel = deliveryManModel;
	}

	public JList<String> getDeliveryManList() {
		return deliveryManList;
	}

	public void setDeliveryManList(JList<String> deliveryManList) {
		this.deliveryManList = deliveryManList;
	}

	public DefaultListModel<String> getAreaModel() {
		return areaModel;
	}

	public void setAreaModel(DefaultListModel<String> areaModel) {
		this.areaModel = areaModel;
	}

	public JList<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(JList<String> areaList) {
		this.areaList = areaList;
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
