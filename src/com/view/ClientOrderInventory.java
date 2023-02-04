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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;

public class ClientOrderInventory extends JFrame {

	private JTextField date_textfield;
	private JTextField postal_textfield;
	private JTextField item_textfield;
	private JTextField price_textfield;
	private JTextField quantity_textfield;
	private JTextField total_textfield;
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton orderBtn;
	private DefaultComboBoxModel<String> timeModel;
	private JComboBox<String> time_combo;
	private DefaultListModel<String> storeModel;
	private JList<String> storeList;
	private DefaultListModel<String> inventoryModel;
	private JList<String> inventoryList;
	private DefaultListModel<String> orderModel;
	private JList<String> orderList;
	
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
	public ClientOrderInventory() {

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
		
		JLabel lblOrderInventory = new JLabel("Order Inventory");
		lblOrderInventory.setForeground(Color.WHITE);
		lblOrderInventory.setFont(new Font("Dialog", Font.BOLD, 35));
		panel_1.add(lblOrderInventory);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 150));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(250, 10));
		panel_3.add(panel_5, BorderLayout.WEST);
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(250, 10));
		panel_3.add(panel_6, BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(15, 0, 15, 0));
		panel_8.setPreferredSize(new Dimension(305, 10));
		panel_7.add(panel_8, BorderLayout.WEST);
		panel_8.setLayout(new GridLayout(3, 1, 0, 5));
		
		JLabel lblNewLabel = new JLabel("Delivery date: (yyyy/mm/dd)");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delivery time:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Postal code: (A#A)");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(15, 0, 15, 10));
		panel_9.setPreferredSize(new Dimension(180, 10));
		panel_7.add(panel_9, BorderLayout.EAST);
		panel_9.setLayout(new GridLayout(3, 1, 0, 5));
		
		try {
			MaskFormatter date = new MaskFormatter("####-##-##");
			date_textfield = new JFormattedTextField(date);
			date_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			date_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			panel_9.add(date_textfield);
			date_textfield.setColumns(10);
		} catch (ParseException e) {
			System.err.println("Enter your date in this format: ####-##-##");
		}	
		
		//Array to populate the time combobox
		timeModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
				 										  "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
				 										  "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
				 										  "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
				 										  "22:00", "22:30", "23:00", "23:30"});
		
		time_combo = new JComboBox<String>(timeModel);
		time_combo.setBorder(UIManager.getBorder("CheckBox.border"));
		time_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_9.add(time_combo);
		
		try {
			MaskFormatter postal = new MaskFormatter("U#U");
			postal_textfield = new JFormattedTextField(postal);
			postal_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			postal_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			panel_9.add(postal_textfield);
			postal_textfield.setColumns(10);
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(10, 150));
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_20.setPreferredSize(new Dimension(250, 10));
		panel_4.add(panel_20, BorderLayout.WEST);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(35, 47, 62));
		panel_25.setPreferredSize(new Dimension(10, 100));
		panel_20.add(panel_25, BorderLayout.SOUTH);
		
		JPanel panel_21 = new JPanel();
		panel_21.setPreferredSize(new Dimension(250, 10));
		panel_4.add(panel_21, BorderLayout.EAST);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(35, 47, 62));
		panel_26.setPreferredSize(new Dimension(10, 100));
		panel_21.add(panel_26, BorderLayout.SOUTH);
		
		JPanel panel_22 = new JPanel();
		panel_4.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new EmptyBorder(10, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_23.getLayout();
		panel_22.add(panel_23, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("Total (no taxes):");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_23.add(lblNewLabel_9);
		
		total_textfield = new JTextField();
		total_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		total_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_23.add(total_textfield);
		total_textfield.setColumns(7);
		
		JLabel lblNewLabel_10 = new JLabel("$");
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_23.add(lblNewLabel_10);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(35, 47, 62));
		panel_24.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_22.add(panel_24, BorderLayout.CENTER);
		
		orderBtn = new JButton("Order");
		orderBtn.setBackground(new Color(255, 153, 0));
		orderBtn.setForeground(Color.WHITE);
		orderBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		orderBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_24.add(orderBtn);
		
		JPanel panel_10 = new JPanel();
		panel_2.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(500, 10));
		panel_10.add(panel_11, BorderLayout.WEST);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(0, 15, 0, 0));
		panel_12.setPreferredSize(new Dimension(250, 10));
		panel_11.add(panel_12, BorderLayout.WEST);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Store");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_12.add(lblNewLabel_3, BorderLayout.NORTH);
		
		storeModel = new DefaultListModel<String>();
		storeList = new JList<>(storeModel);
		storeList.setFont(new Font("Dialog", Font.PLAIN, 20));
		storeList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_12.add(storeList, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setPreferredSize(new Dimension(240, 10));
		panel_11.add(panel_13, BorderLayout.EAST);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Inventory");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_13.add(lblNewLabel_4, BorderLayout.NORTH);
		
		inventoryModel = new DefaultListModel<String>();
		inventoryList = new JList<>(inventoryModel);
		inventoryList.setFont(new Font("Dialog", Font.PLAIN, 20));
		inventoryList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_13.add(inventoryList, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_10.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new EmptyBorder(0, 0, 0, 15));
		panel_15.setPreferredSize(new Dimension(250, 10));
		panel_14.add(panel_15, BorderLayout.EAST);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("Order");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_15.add(lblNewLabel_5, BorderLayout.NORTH);
		
		orderModel = new DefaultListModel<String>();
		orderList = new JList<>(orderModel);
		orderList.setFont(new Font("Dialog", Font.PLAIN, 15));
		orderList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_15.add(orderList, BorderLayout.CENTER);
		
		JPanel panel_16 = new JPanel();
		panel_14.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_17 = new JPanel();
		panel_17.setPreferredSize(new Dimension(10, 60));
		panel_16.add(panel_17, BorderLayout.NORTH);
		
		JPanel panel_18 = new JPanel();
		panel_16.add(panel_18, BorderLayout.SOUTH);
		
		addBtn = new JButton("Add");
		addBtn.setForeground(Color.WHITE);
		addBtn.setBackground(new Color(255, 216, 20));
		addBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		addBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_18.add(addBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setForeground(Color.WHITE);
		deleteBtn.setBackground(new Color(255, 0, 0));
		deleteBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		deleteBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_18.add(deleteBtn);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new EmptyBorder(75, 10, 15, 10));
		panel_16.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new GridLayout(0, 2, 0, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Item:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(lblNewLabel_6);
		
		item_textfield = new JTextField();
		item_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		item_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(item_textfield);
		item_textfield.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Price:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(lblNewLabel_7);
		
		price_textfield = new JTextField();
		price_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		price_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(price_textfield);
		price_textfield.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Qty(Max 10)");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(lblNewLabel_8);
		
		quantity_textfield = new JTextField();
		quantity_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		quantity_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_19.add(quantity_textfield);
		quantity_textfield.setColumns(10);
		
		this.setVisible(false);
	}

	/*
	 * Getters and Setters
	 * */
	public JTextField getDate_textfield() {
		return date_textfield;
	}

	public void setDate_textfield(JTextField date_textfield) {
		this.date_textfield = date_textfield;
	}

	public JTextField getPostal_textfield() {
		return postal_textfield;
	}

	public void setPostal_textfield(JTextField postal_textfield) {
		this.postal_textfield = postal_textfield;
	}

	public JTextField getItem_textfield() {
		return item_textfield;
	}

	public void setItem_textfield(JTextField item_textfield) {
		this.item_textfield = item_textfield;
	}

	public JTextField getPrice_textfield() {
		return price_textfield;
	}

	public void setPrice_textfield(JTextField price_textfield) {
		this.price_textfield = price_textfield;
	}

	public JTextField getQuantity_textfield() {
		return quantity_textfield;
	}

	public void setQuantity_textfield(JTextField quantity_textfield) {
		this.quantity_textfield = quantity_textfield;
	}

	public JTextField getTotal_textfield() {
		return total_textfield;
	}

	public void setTotal_textfield(JTextField total_textfield) {
		this.total_textfield = total_textfield;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getOrderBtn() {
		return orderBtn;
	}

	public void setOrderBtn(JButton orderBtn) {
		this.orderBtn = orderBtn;
	}

	public DefaultComboBoxModel<String> getTimeModel() {
		return timeModel;
	}

	public void setTimeModel(DefaultComboBoxModel<String> timeModel) {
		this.timeModel = timeModel;
	}

	public JComboBox<String> getTime_combo() {
		return time_combo;
	}

	public void setTime_combo(JComboBox<String> time_combo) {
		this.time_combo = time_combo;
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

	public DefaultListModel<String> getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(DefaultListModel<String> orderModel) {
		this.orderModel = orderModel;
	}

	public JList<String> getOrderList() {
		return orderList;
	}

	public void setOrderList(JList<String> orderList) {
		this.orderList = orderList;
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
