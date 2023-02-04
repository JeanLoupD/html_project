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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class EditInventory extends JFrame {

	private JLabel titleLabel;
	private JTextField name_textfield;
	private JTextField price_textfield;
	private JButton selectBtn;
	private JButton editBtn;
	private JButton addItemBtn;
	private JButton editItemBtn;
	private JButton deleteItemBtn;
	private DefaultListModel<String> storeModel;
	private JList<String> storeList;
	private DefaultListModel<String> inventoryModel;
	private JList<String> inventoryList;
	
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
	public EditInventory() {

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
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(35, 47, 62));
		panel_1.setPreferredSize(new Dimension(350, 10));
		panel_1.setBorder(new EmptyBorder(0, 10, 17, 10));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(35, 47, 62));
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setForeground(Color.WHITE);
		lblStore.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_2.add(lblStore);
		
		selectBtn = new JButton("Select");
		selectBtn.setForeground(Color.WHITE);
		selectBtn.setBackground(new Color(255, 216, 20));
		selectBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		selectBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.add(selectBtn, BorderLayout.SOUTH);
		
		storeModel = new DefaultListModel<String>();
		storeList = new JList<>(storeModel);
		storeList.setFont(new Font("Dialog", Font.PLAIN, 20));
		storeList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_1.add(storeList, BorderLayout.CENTER);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1, BorderLayout.CENTER);
		panel_2_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(35, 47, 62));
		panel_2_1.add(panel_3, BorderLayout.NORTH);
		
		titleLabel = new JLabel("Edit Inventory");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_3.add(titleLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 250));
		panel_2_1.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		editBtn = new JButton("Edit Inventory");
		editBtn.setForeground(Color.WHITE);
		editBtn.setBackground(new Color(255, 153, 0));
		editBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		editBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_5.add(editBtn);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblEditItem = new JLabel("Edit Item");
		lblEditItem.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_7.add(lblEditItem);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(35, 47, 62));
		panel_8.setBorder(new EmptyBorder(0, 0, 10, 0));
		panel_6.add(panel_8, BorderLayout.SOUTH);
		
		addItemBtn = new JButton("Add Item");
		addItemBtn.setBackground(new Color(255, 153, 0));
		addItemBtn.setForeground(Color.WHITE);
		addItemBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		addItemBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_8.add(addItemBtn);
		
		editItemBtn = new JButton("Edit Item");
		editItemBtn.setBackground(new Color(255, 216, 20));
		editItemBtn.setForeground(Color.WHITE);
		editItemBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		editItemBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_8.add(editItemBtn);
		
		deleteItemBtn = new JButton("Delete Item");
		deleteItemBtn.setBackground(new Color(255, 0, 0));
		deleteItemBtn.setForeground(Color.WHITE);
		deleteItemBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteItemBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_8.add(deleteItemBtn);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(81, 10));
		panel_6.add(panel_9, BorderLayout.WEST);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setPreferredSize(new Dimension(81, 10));
		panel_6.add(panel_9_1, BorderLayout.EAST);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new EmptyBorder(15, 0, 10, 0));
		panel_6.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(2, 2, -150, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Item:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_10.add(lblNewLabel_2);
		
		name_textfield = new JTextField();
		name_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		name_textfield.setColumns(10);
		name_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_10.add(name_textfield);
		
		JLabel lblNewLabel_3 = new JLabel("Price $:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_10.add(lblNewLabel_3);
		
		price_textfield = new JTextField();
		price_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		price_textfield.setColumns(10);
		price_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_10.add(price_textfield);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setPreferredSize(new Dimension(163, 10));
		panel_2_1.add(panel_4_1, BorderLayout.WEST);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setPreferredSize(new Dimension(163, 10));
		panel_2_1.add(panel_4_1_1, BorderLayout.EAST);
		
		inventoryModel = new DefaultListModel<String>();
		inventoryList = new JList<>(inventoryModel);
		inventoryList.setFont(new Font("Dialog", Font.PLAIN, 20));
		inventoryList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_2_1.add(inventoryList, BorderLayout.CENTER);
		
		this.setVisible(false);
	}
	
	/*
	 * Getters and Setters
	 * */
	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public JTextField getName_textfield() {
		return name_textfield;
	}

	public void setName_textfield(JTextField name_textfield) {
		this.name_textfield = name_textfield;
	}

	public JTextField getPrice_textfield() {
		return price_textfield;
	}

	public void setPrice_textfield(JTextField price_textfield) {
		this.price_textfield = price_textfield;
	}

	public JButton getSelectBtn() {
		return selectBtn;
	}

	public void setSelectBtn(JButton selectBtn) {
		this.selectBtn = selectBtn;
	}

	public JButton getEditBtn() {
		return editBtn;
	}

	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}

	public JButton getAddItemBtn() {
		return addItemBtn;
	}

	public void setAddItemBtn(JButton addItemBtn) {
		this.addItemBtn = addItemBtn;
	}

	public JButton getEditItemBtn() {
		return editItemBtn;
	}

	public void setEditItemBtn(JButton editItemBtn) {
		this.editItemBtn = editItemBtn;
	}

	public JButton getDeleteItemBtn() {
		return deleteItemBtn;
	}

	public void setDeleteItemBtn(JButton deleteItemBtn) {
		this.deleteItemBtn = deleteItemBtn;
	}

	public DefaultListModel<String> getStoreModel() {
		return storeModel;
	}

	public void setStoreModel(DefaultListModel<String> storeModel) {
		this.storeModel = storeModel;
	}

	public JList<String> getStoreList() {
		return storeList;
	}

	public void setStoreList(JList<String> storeList) {
		this.storeList = storeList;
	}

	public DefaultListModel<String> getInventoryModel() {
		return inventoryModel;
	}

	public void setInventoryModel(DefaultListModel<String> inventoryModel) {
		this.inventoryModel = inventoryModel;
	}

	public JList<String> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(JList<String> inventoryList) {
		this.inventoryList = inventoryList;
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
