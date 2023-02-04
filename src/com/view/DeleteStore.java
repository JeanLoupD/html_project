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

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

public class DeleteStore extends JFrame {

	private JTextField textfield;
	private JTextField phone_textfield;
	private JButton confirmBtn;
	private JButton selectBtn;
	private DefaultListModel<String> areaModel;
	private JList<String> areaList;
	private DefaultListModel<String> storeModel;
	private JList<String> storeList;
	
	//ComboBox variables
	DefaultComboBoxModel<String> sundayOpenModel;
	DefaultComboBoxModel<String> sundayCloseModel;
	DefaultComboBoxModel<String> mondayOpenModel;
	DefaultComboBoxModel<String> mondayCloseModel;
	DefaultComboBoxModel<String> tuesdayOpenModel;
	DefaultComboBoxModel<String> tuesdayCloseModel;
	DefaultComboBoxModel<String> wednesdayOpenModel;
	DefaultComboBoxModel<String> wednesdayCloseModel;
	DefaultComboBoxModel<String> thursdayOpenModel;
	DefaultComboBoxModel<String> thursdayCloseModel;
	DefaultComboBoxModel<String> fridayOpenModel;
	DefaultComboBoxModel<String> fridayCloseModel;
	DefaultComboBoxModel<String> saturdayOpenModel;
	DefaultComboBoxModel<String> saturdayCloseModel;
	JComboBox<String> sundayOpen_combo;
	JComboBox<String> sundayClose_combo;
	JComboBox<String> mondayOpen_combo;
	JComboBox<String> mondayClose_combo;
	JComboBox<String> tuesdayOpen_combo;
	JComboBox<String> tuesdayClose_combo;
	JComboBox<String> wednesdayOpen_combo;
	JComboBox<String> wednesdayClose_combo;
	JComboBox<String> thursdayOpen_combo;
	JComboBox<String> thursdayClose_combo;
	JComboBox<String> fridayOpen_combo;
	JComboBox<String> fridayClose_combo;
	JComboBox<String> saturdayOpen_combo;
	JComboBox<String> saturdayClose_combo;
	
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
	private JTextField name_textfield;
	private JTextField address_textfield;
	private JTextField textField_3;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public DeleteStore() {

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
		panel_1.setPreferredSize(new Dimension(280, 10));
		panel_1.setBorder(new EmptyBorder(0, 10, 20, 10));
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
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(35, 47, 62));
		panel_3.add(panel_3_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Store");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_3_1.add(lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(35, 47, 62));
		panel_7.setPreferredSize(new Dimension(10, 60));
		panel_7.setBorder(new EmptyBorder(5, 0, 0, 0));
		panel_3.add(panel_7, BorderLayout.SOUTH);
		
		confirmBtn = new JButton("Confirm Delete");
		confirmBtn.setForeground(Color.WHITE);
		confirmBtn.setBackground(new Color(255, 0, 0));
		confirmBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		confirmBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_7.add(confirmBtn);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setPreferredSize(new Dimension(10, 230));
		panel_4.add(panel_1_1, BorderLayout.SOUTH);
		panel_1_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(150, 10));
		panel_1_1.add(panel_10, BorderLayout.WEST);
		
		JPanel panel_10_1 = new JPanel();
		panel_10_1.setPreferredSize(new Dimension(150, 10));
		panel_1_1.add(panel_10_1, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel_1_1.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_8.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6_1 = new JLabel("Delivery Area");
		lblNewLabel_6_1.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_13.add(lblNewLabel_6_1);
		
		JPanel panel_14 = new JPanel();
		panel_8.add(panel_14, BorderLayout.SOUTH);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setColumns(3);
		panel_14.add(textField_1);

		
		JButton addAreaBtn = new JButton("Add");
		addAreaBtn.setBackground(new Color(255, 216, 20));
		addAreaBtn.setForeground(Color.WHITE);
		addAreaBtn.setEnabled(false);
		addAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		addAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_14.add(addAreaBtn);
		
		JButton deleteAreaBtn = new JButton("Delete");
		deleteAreaBtn.setBackground(new Color(255, 0, 0));
		deleteAreaBtn.setForeground(Color.WHITE);
		deleteAreaBtn.setEnabled(false);
		deleteAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_14.add(deleteAreaBtn);
		
		areaModel = new DefaultListModel<String>();
		areaList = new JList<>(areaModel);
		areaList.setEnabled(false);
		areaList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		areaList.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_8.add(areaList, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new EmptyBorder(0, 13, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_5_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_5_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Store name:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 22));
		panel_5_1.add(lblNewLabel);
		
		name_textfield = new JTextField();
		name_textfield.setEnabled(false);
		name_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		name_textfield.setColumns(10);
		name_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_5_1.add(name_textfield);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6_1 = new JPanel();
		panel_6.add(panel_6_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Store address:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_6_1.add(lblNewLabel_2);
		
		address_textfield = new JTextField();
		address_textfield.setEnabled(false);
		address_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		address_textfield.setColumns(10);
		address_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_6_1.add(address_textfield);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone number:");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_1.setBorder(new EmptyBorder(0, 15, 0, 0));
		panel_6_1.add(lblNewLabel_1_1);
		
		phone_textfield = new JTextField();
		phone_textfield.setEnabled(false);
		phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		phone_textfield.setColumns(10);
		phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_6_1.add(phone_textfield);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_3.setColumns(12);
		textField_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		panel_6_1.add(textField_3);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new EmptyBorder(10, 10, 0, 10));
		panel_6.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new GridLayout(8, 3, 25, 5));
		
		JLabel lblNewLabel_1_2 = new JLabel("Day");
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Opening Time");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Closing Time");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Sunday:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_5);
		
		//Arrays to populate the JCombo
		sundayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		sundayOpen_combo = new JComboBox<String>(sundayOpenModel);
		sundayOpen_combo.setEnabled(false);
		sundayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(sundayOpen_combo);
		
		//Arrays to populate the JCombo
		sundayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		sundayClose_combo = new JComboBox<String>(sundayCloseModel);
		sundayClose_combo.setEnabled(false);
		sundayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		sundayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(sundayClose_combo);
		
		JLabel lblNewLabel_6 = new JLabel("Monday:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_6);
		
		//Arrays to populate the JCombo
		mondayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		mondayOpen_combo = new JComboBox<String>(mondayOpenModel);
		mondayOpen_combo.setEnabled(false);
		mondayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		mondayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(mondayOpen_combo);
		
		//Arrays to populate the JCombo
		mondayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		mondayClose_combo = new JComboBox<String>(mondayCloseModel);
		mondayClose_combo.setEnabled(false);
		mondayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		mondayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(mondayClose_combo);
		
		JLabel lblNewLabel_7 = new JLabel("Tuesday:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_7);
		
		//Arrays to populate the JCombo
		tuesdayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		tuesdayOpen_combo = new JComboBox<String>(tuesdayOpenModel);
		tuesdayOpen_combo.setEnabled(false);
		tuesdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		tuesdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(tuesdayOpen_combo);
		
		//Arrays to populate the JCombo
		tuesdayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		tuesdayClose_combo = new JComboBox<String>(tuesdayCloseModel);
		tuesdayClose_combo.setEnabled(false);
		tuesdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		tuesdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(tuesdayClose_combo);
		
		JLabel lblNewLabel_8 = new JLabel("Wednesday:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_8);
		
		//Arrays to populate the JCombo
		wednesdayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		wednesdayOpen_combo = new JComboBox<String>(wednesdayOpenModel);
		wednesdayOpen_combo.setEnabled(false);
		wednesdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		wednesdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(wednesdayOpen_combo);
		
		//Arrays to populate the JCombo
		wednesdayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		wednesdayClose_combo = new JComboBox<String>(wednesdayCloseModel);
		wednesdayClose_combo.setEnabled(false);
		wednesdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		wednesdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(wednesdayClose_combo);
		
		JLabel lblNewLabel_9 = new JLabel("Thursday:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_9);
		
		//Arrays to populate the JCombo
		thursdayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		thursdayOpen_combo = new JComboBox<String>(thursdayOpenModel);
		thursdayOpen_combo.setEnabled(false);
		thursdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		thursdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(thursdayOpen_combo);
		
		//Arrays to populate the JCombo
		thursdayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		thursdayClose_combo = new JComboBox<String>(thursdayCloseModel);
		thursdayClose_combo.setEnabled(false);
		thursdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		thursdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(thursdayClose_combo);
		
		JLabel lblNewLabel_10 = new JLabel("Friday:");
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_10);
		
		//Arrays to populate the JCombo
		fridayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		fridayOpen_combo = new JComboBox<String>(fridayOpenModel);
		fridayOpen_combo.setEnabled(false);
		fridayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		fridayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(fridayOpen_combo);
		
		//Arrays to populate the JCombo
		fridayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		fridayClose_combo = new JComboBox<String>(fridayCloseModel);
		fridayClose_combo.setEnabled(false);
		fridayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		fridayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(fridayClose_combo);
		
		JLabel lblNewLabel_11 = new JLabel("Saturday:");
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_11);
		
		//Arrays to populate the JCombo
		saturdayOpenModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		saturdayOpen_combo = new JComboBox<String>(saturdayOpenModel);
		saturdayOpen_combo.setEnabled(false);
		saturdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		saturdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(saturdayOpen_combo);
		
		//Arrays to populate the JCombo
		saturdayCloseModel = new DefaultComboBoxModel<String>(new String[] {"00:00"});
		
		saturdayClose_combo = new JComboBox<String>(saturdayCloseModel);
		saturdayClose_combo.setEnabled(false);
		saturdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		saturdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		panel_15.add(saturdayClose_combo);
		
		this.setVisible(false);
	}
	
	/*
	 * Getters and Setters
	 * */
	public JTextField getTextfield() {
		return textfield;
	}

	public void setTextfield(JTextField textfield) {
		this.textfield = textfield;
	}

	public JTextField getPhone_textfield() {
		return phone_textfield;
	}

	public void setPhone_textfield(JTextField phone_textfield) {
		this.phone_textfield = phone_textfield;
	}

	public JButton getConfirmBtn() {
		return confirmBtn;
	}

	public void setConfirmBtn(JButton confirmBtn) {
		this.confirmBtn = confirmBtn;
	}

	public JButton getSelectBtn() {
		return selectBtn;
	}

	public void setSelectBtn(JButton selectBtn) {
		this.selectBtn = selectBtn;
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

	public DefaultComboBoxModel<String> getSundayOpenModel() {
		return sundayOpenModel;
	}

	public void setSundayOpenModel(DefaultComboBoxModel<String> sundayOpenModel) {
		this.sundayOpenModel = sundayOpenModel;
	}

	public DefaultComboBoxModel<String> getSundayCloseModel() {
		return sundayCloseModel;
	}

	public void setSundayCloseModel(DefaultComboBoxModel<String> sundayCloseModel) {
		this.sundayCloseModel = sundayCloseModel;
	}

	public DefaultComboBoxModel<String> getMondayOpenModel() {
		return mondayOpenModel;
	}

	public void setMondayOpenModel(DefaultComboBoxModel<String> mondayOpenModel) {
		this.mondayOpenModel = mondayOpenModel;
	}

	public DefaultComboBoxModel<String> getMondayCloseModel() {
		return mondayCloseModel;
	}

	public void setMondayCloseModel(DefaultComboBoxModel<String> mondayCloseModel) {
		this.mondayCloseModel = mondayCloseModel;
	}

	public DefaultComboBoxModel<String> getTuesdayOpenModel() {
		return tuesdayOpenModel;
	}

	public void setTuesdayOpenModel(DefaultComboBoxModel<String> tuesdayOpenModel) {
		this.tuesdayOpenModel = tuesdayOpenModel;
	}

	public DefaultComboBoxModel<String> getTuesdayCloseModel() {
		return tuesdayCloseModel;
	}

	public void setTuesdayCloseModel(DefaultComboBoxModel<String> tuesdayCloseModel) {
		this.tuesdayCloseModel = tuesdayCloseModel;
	}

	public DefaultComboBoxModel<String> getWednesdayOpenModel() {
		return wednesdayOpenModel;
	}

	public void setWednesdayOpenModel(DefaultComboBoxModel<String> wednesdayOpenModel) {
		this.wednesdayOpenModel = wednesdayOpenModel;
	}

	public DefaultComboBoxModel<String> getWednesdayCloseModel() {
		return wednesdayCloseModel;
	}

	public void setWednesdayCloseModel(DefaultComboBoxModel<String> wednesdayCloseModel) {
		this.wednesdayCloseModel = wednesdayCloseModel;
	}

	public DefaultComboBoxModel<String> getThursdayOpenModel() {
		return thursdayOpenModel;
	}

	public void setThursdayOpenModel(DefaultComboBoxModel<String> thursdayOpenModel) {
		this.thursdayOpenModel = thursdayOpenModel;
	}

	public DefaultComboBoxModel<String> getThursdayCloseModel() {
		return thursdayCloseModel;
	}

	public void setThursdayCloseModel(DefaultComboBoxModel<String> thursdayCloseModel) {
		this.thursdayCloseModel = thursdayCloseModel;
	}

	public DefaultComboBoxModel<String> getFridayOpenModel() {
		return fridayOpenModel;
	}

	public void setFridayOpenModel(DefaultComboBoxModel<String> fridayOpenModel) {
		this.fridayOpenModel = fridayOpenModel;
	}

	public DefaultComboBoxModel<String> getFridayCloseModel() {
		return fridayCloseModel;
	}

	public void setFridayCloseModel(DefaultComboBoxModel<String> fridayCloseModel) {
		this.fridayCloseModel = fridayCloseModel;
	}

	public DefaultComboBoxModel<String> getSaturdayOpenModel() {
		return saturdayOpenModel;
	}

	public void setSaturdayOpenModel(DefaultComboBoxModel<String> saturdayOpenModel) {
		this.saturdayOpenModel = saturdayOpenModel;
	}

	public DefaultComboBoxModel<String> getSaturdayCloseModel() {
		return saturdayCloseModel;
	}

	public void setSaturdayCloseModel(DefaultComboBoxModel<String> saturdayCloseModel) {
		this.saturdayCloseModel = saturdayCloseModel;
	}

	public JComboBox<String> getSundayOpen_combo() {
		return sundayOpen_combo;
	}

	public void setSundayOpen_combo(JComboBox<String> sundayOpen_combo) {
		this.sundayOpen_combo = sundayOpen_combo;
	}

	public JComboBox<String> getSundayClose_combo() {
		return sundayClose_combo;
	}

	public void setSundayClose_combo(JComboBox<String> sundayClose_combo) {
		this.sundayClose_combo = sundayClose_combo;
	}

	public JComboBox<String> getMondayOpen_combo() {
		return mondayOpen_combo;
	}

	public void setMondayOpen_combo(JComboBox<String> mondayOpen_combo) {
		this.mondayOpen_combo = mondayOpen_combo;
	}

	public JComboBox<String> getMondayClose_combo() {
		return mondayClose_combo;
	}

	public void setMondayClose_combo(JComboBox<String> mondayClose_combo) {
		this.mondayClose_combo = mondayClose_combo;
	}

	public JComboBox<String> getTuesdayOpen_combo() {
		return tuesdayOpen_combo;
	}

	public void setTuesdayOpen_combo(JComboBox<String> tuesdayOpen_combo) {
		this.tuesdayOpen_combo = tuesdayOpen_combo;
	}

	public JComboBox<String> getTuesdayClose_combo() {
		return tuesdayClose_combo;
	}

	public void setTuesdayClose_combo(JComboBox<String> tuesdayClose_combo) {
		this.tuesdayClose_combo = tuesdayClose_combo;
	}

	public JComboBox<String> getWednesdayOpen_combo() {
		return wednesdayOpen_combo;
	}

	public void setWednesdayOpen_combo(JComboBox<String> wednesdayOpen_combo) {
		this.wednesdayOpen_combo = wednesdayOpen_combo;
	}

	public JComboBox<String> getWednesdayClose_combo() {
		return wednesdayClose_combo;
	}

	public void setWednesdayClose_combo(JComboBox<String> wednesdayClose_combo) {
		this.wednesdayClose_combo = wednesdayClose_combo;
	}

	public JComboBox<String> getThursdayOpen_combo() {
		return thursdayOpen_combo;
	}

	public void setThursdayOpen_combo(JComboBox<String> thursdayOpen_combo) {
		this.thursdayOpen_combo = thursdayOpen_combo;
	}

	public JComboBox<String> getThursdayClose_combo() {
		return thursdayClose_combo;
	}

	public void setThursdayClose_combo(JComboBox<String> thursdayClose_combo) {
		this.thursdayClose_combo = thursdayClose_combo;
	}

	public JComboBox<String> getFridayOpen_combo() {
		return fridayOpen_combo;
	}

	public void setFridayOpen_combo(JComboBox<String> fridayOpen_combo) {
		this.fridayOpen_combo = fridayOpen_combo;
	}

	public JComboBox<String> getFridayClose_combo() {
		return fridayClose_combo;
	}

	public void setFridayClose_combo(JComboBox<String> fridayClose_combo) {
		this.fridayClose_combo = fridayClose_combo;
	}

	public JComboBox<String> getSaturdayOpen_combo() {
		return saturdayOpen_combo;
	}

	public void setSaturdayOpen_combo(JComboBox<String> saturdayOpen_combo) {
		this.saturdayOpen_combo = saturdayOpen_combo;
	}

	public JComboBox<String> getSaturdayClose_combo() {
		return saturdayClose_combo;
	}

	public void setSaturdayClose_combo(JComboBox<String> saturdayClose_combo) {
		this.saturdayClose_combo = saturdayClose_combo;
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

	public JTextField getName_textfield() {
		return name_textfield;
	}

	public void setName_textfield(JTextField name_textfield) {
		this.name_textfield = name_textfield;
	}

	public JTextField getAddress_textfield() {
		return address_textfield;
	}

	public void setAddress_textfield(JTextField address_textfield) {
		this.address_textfield = address_textfield;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	
}
