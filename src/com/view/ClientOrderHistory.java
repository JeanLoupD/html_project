package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class ClientOrderHistory extends JFrame {

	private JTextField area_textfield;
	private JTextField date_textfield;
	private JButton selectBtn;
	private DefaultComboBoxModel<String> timeModel;
	private JComboBox<String> time_combo;
	private DefaultListModel<String> storeModel;
	private JList<String> storeList;
	private DefaultListModel<String> historyModel;
	private JList<String> historyList;
	
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
	public ClientOrderHistory() {

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
		panel_1.setPreferredSize(new Dimension(350, 10));
		panel_1.setBorder(new EmptyBorder(0, 10, 10, 10));
		panel_1.setBackground(new Color(35, 47, 62));
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
		selectBtn.setPreferredSize(new Dimension(59, 46));
		selectBtn.setForeground(Color.WHITE);
		selectBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		selectBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		selectBtn.setBackground(new Color(255, 216, 20));
		panel_1.add(selectBtn, BorderLayout.SOUTH);
		
		storeModel = new DefaultListModel<String>();
		storeList = new JList<>(storeModel);
		storeList.setFont(new Font("Dialog", Font.PLAIN, 20));
		storeList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_1.add(storeList, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(35, 47, 62));
		panel_3.add(panel_3_1, BorderLayout.NORTH);
		
		JLabel title_label = new JLabel("Orders History");
		title_label.setForeground(Color.WHITE);
		title_label.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_3_1.add(title_label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(35, 47, 62));
		panel_4.setPreferredSize(new Dimension(10, 55));
		panel_3.add(panel_4, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(10, 150));
		panel_5.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(80, 10));
		panel_6.add(panel_7, BorderLayout.WEST);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setPreferredSize(new Dimension(80, 10));
		panel_6.add(panel_7_1, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setPreferredSize(new Dimension(290, 10));
		panel_8_1.setBorder(new EmptyBorder(15, 0, 15, 0));
		panel_8.add(panel_8_1, BorderLayout.WEST);
		panel_8_1.setLayout(new GridLayout(3, 1, 0, 5));
		
		JLabel lblNewLabel = new JLabel("Delivery date: (yyyy/mm/dd)");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Delivery time:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Postal code: (A#A)");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8_1.add(lblNewLabel_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(180, 10));
		panel_9.setBorder(new EmptyBorder(15, 0, 15, 10));
		panel_8.add(panel_9, BorderLayout.EAST);
		panel_9.setLayout(new GridLayout(3, 1, 0, 5));
		
		try {
			MaskFormatter date = new MaskFormatter("####-##-##");
			date_textfield = new JFormattedTextField(date);
			date_textfield.setEnabled(false);
			date_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			date_textfield.setColumns(10);
			date_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			panel_9.add(date_textfield);
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
		time_combo.setEnabled(false);
		time_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		time_combo.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_9.add(time_combo);
		
		area_textfield = new JTextField();
		area_textfield.setEnabled(false);
		area_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		area_textfield.setColumns(10);
		area_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_9.add(area_textfield);
		
		JPanel panel_10 = new JPanel();
		panel_5.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(10, 20));
		panel_10.add(panel_11, BorderLayout.NORTH);
		
		JPanel panel_12 = new JPanel();
		panel_12.setPreferredSize(new Dimension(10, 75));
		panel_10.add(panel_12, BorderLayout.SOUTH);
		
		JPanel panel_13 = new JPanel();
		panel_13.setPreferredSize(new Dimension(80, 10));
		panel_10.add(panel_13, BorderLayout.WEST);
		
		JPanel panel_13_1 = new JPanel();
		panel_13_1.setPreferredSize(new Dimension(80, 10));
		panel_10.add(panel_13_1, BorderLayout.EAST);
		
		historyModel = new DefaultListModel<String>();
		historyList = new JList<>(historyModel);
		historyList.setEnabled(false);
		historyList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		historyList.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_10.add(historyList, BorderLayout.CENTER);
		
		this.setVisible(false);
	}

	/*
	 * Getters and Setters
	 * */
	public JButton getSelectBtn() {
		return selectBtn;
	}

	public JTextField getArea_textfield() {
		return area_textfield;
	}

	public void setArea_textfield(JTextField area_textfield) {
		this.area_textfield = area_textfield;
	}

	public void setSelectBtn(JButton selectBtn) {
		this.selectBtn = selectBtn;
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

	public DefaultListModel<String> getHistoryModel() {
		return historyModel;
	}

	public void setHistoryModel(DefaultListModel<String> historyModel) {
		this.historyModel = historyModel;
	}

	public JList<String> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(JList<String> historyList) {
		this.historyList = historyList;
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

	public JTextField getDate_textfield() {
		return date_textfield;
	}

	public void setDate_textfield(JTextField date_textfield) {
		this.date_textfield = date_textfield;
	}

	
}
