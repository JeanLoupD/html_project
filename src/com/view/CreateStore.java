package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;

public class CreateStore extends JFrame {

	private JTextField name_textfield;
	private JTextField address_textfield;
	private JTextField phone_textfield;
	private JTextField area_textfield;
	private JButton createBtn;
	private JButton addAreaBtn;
	private JButton deleteAreaBtn;
	private DefaultListModel<String> areaModel;
	private JList<String> areaList;
	
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

	/**
	 * Create the application.
	 */
	public CreateStore() {

		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 47, 62));
		panel.setPreferredSize(new Dimension(10, 55));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCreateNewStore = new JLabel("Create New Store");
		lblCreateNewStore.setForeground(Color.WHITE);
		lblCreateNewStore.setFont(new Font("Dialog", Font.BOLD, 35));
		panel.add(lblCreateNewStore);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 280));
		this.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(35, 47, 62));
		panel_1.add(panel_7, BorderLayout.SOUTH);
		
		createBtn = new JButton("Create New Store");
		createBtn.setBackground(new Color(255, 153, 0));
		createBtn.setForeground(Color.WHITE);
		createBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		createBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_7.add(createBtn);
		
		JPanel panel_10 = new JPanel();
		panel_10.setPreferredSize(new Dimension(250, 10));
		panel_1.add(panel_10, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		panel_11.setPreferredSize(new Dimension(250, 10));
		panel_1.add(panel_11, BorderLayout.EAST);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(0, 0, 20, 0));
		panel_1.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6_1 = new JLabel("Delivery Area");
		lblNewLabel_6_1.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_13.add(lblNewLabel_6_1);
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.SOUTH);
		
		area_textfield = new JTextField();
		area_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_14.add(area_textfield);
		area_textfield.setColumns(3);
		
		addAreaBtn = new JButton("Add");
		addAreaBtn.setForeground(Color.WHITE);
		addAreaBtn.setBackground(new Color(255, 216, 20));
		addAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		addAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_14.add(addAreaBtn);
		
		deleteAreaBtn = new JButton("Delete");
		deleteAreaBtn.setForeground(Color.WHITE);
		deleteAreaBtn.setBackground(new Color(255, 0, 0));
		deleteAreaBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteAreaBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_14.add(deleteAreaBtn);
		
		areaModel = new DefaultListModel<String>();
		areaList = new JList<>(areaModel);
		areaList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		areaList.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_12.add(areaList, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		this.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 100, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_5.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Store name:");
		lblNewLabel.setBorder(new EmptyBorder(0, 38, 0, 0));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2.add(lblNewLabel);
		
		name_textfield = new JTextField();
		name_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		name_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2.add(name_textfield);
		name_textfield.setColumns(12);
		
		JPanel panel_4 = new JPanel();
		panel_5.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Store address:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_6.add(lblNewLabel_2);
		
		address_textfield = new JTextField();
		address_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		address_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		address_textfield.setColumns(12);
		panel_6.add(address_textfield);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone number:");
		lblNewLabel_1_1.setBorder(new EmptyBorder(0, 15, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_6.add(lblNewLabel_1_1);
		
		try {
			MaskFormatter telephone = new MaskFormatter("(###)###-####");
			phone_textfield = new JFormattedTextField(telephone);
			phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			phone_textfield.setColumns(12);
			panel_6.add(phone_textfield);
		} catch (ParseException e) {
			System.err.println("Enter your phone number in this format: ###-###-####");
		}
		
		JPanel panel_8 = new JPanel();
		panel_8.setPreferredSize(new Dimension(200, 10));
		panel_4.add(panel_8, BorderLayout.WEST);
		
		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(200, 10));
		panel_4.add(panel_9, BorderLayout.EAST);
		
		JPanel panel_15 = new JPanel();
		panel_4.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new GridLayout(8, 3, 25, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Day");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_1);
		
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
		
		//Arrays to populate the Jcombo
		sundayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
								 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
								 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
								 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
								 "22:00", "22:30", "23:00", "23:30"});
		
		sundayOpen_combo = new JComboBox<String>(sundayOpenModel);
		sundayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		sundayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(sundayOpen_combo);
		
		//Arrays to populate the Jcombo
		sundayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
										 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
										 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
										 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
										 "22:00", "22:30", "23:00", "23:30"});
		
		sundayClose_combo = new JComboBox<String>(sundayCloseModel);
		sundayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		sundayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(sundayClose_combo);
		
		JLabel lblNewLabel_6 = new JLabel("Monday:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_6);
		
		//Arrays to populate the Jcombo
		mondayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		mondayOpen_combo = new JComboBox<String>(mondayOpenModel);
		mondayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		mondayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(mondayOpen_combo);
		
		//Arrays to populate the Jcombo
		mondayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		mondayClose_combo = new JComboBox<String>(mondayCloseModel);
		mondayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		mondayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(mondayClose_combo);
		
		JLabel lblNewLabel_7 = new JLabel("Tuesday:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_7);
		
		//Arrays to populate the Jcombo
		tuesdayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		tuesdayOpen_combo = new JComboBox<String>(tuesdayOpenModel);
		tuesdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		tuesdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(tuesdayOpen_combo);
		
		//Arrays to populate the Jcombo
		tuesdayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		tuesdayClose_combo = new JComboBox<String>(tuesdayCloseModel);
		tuesdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		tuesdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(tuesdayClose_combo);
		
		JLabel lblNewLabel_8 = new JLabel("Wednesday:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_8);
		
		//Arrays to populate the Jcombo
		wednesdayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		wednesdayOpen_combo = new JComboBox<String>(wednesdayOpenModel);
		wednesdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		wednesdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(wednesdayOpen_combo);
		
		//Arrays to populate the Jcombo
		wednesdayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		wednesdayClose_combo = new JComboBox<String>(wednesdayCloseModel);
		wednesdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		wednesdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(wednesdayClose_combo);
		
		JLabel lblNewLabel_9 = new JLabel("Thursday:");
		lblNewLabel_9.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_9);
		
		//Arrays to populate the Jcombo
		thursdayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		thursdayOpen_combo = new JComboBox<String>(thursdayOpenModel);
		thursdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		thursdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(thursdayOpen_combo);
		
		//Arrays to populate the Jcombo
		thursdayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		thursdayClose_combo = new JComboBox<String>(thursdayCloseModel);
		thursdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		thursdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(thursdayClose_combo);
		
		JLabel lblNewLabel_10 = new JLabel("Friday:");
		lblNewLabel_10.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_10);
		
		//Arrays to populate the Jcombo
		fridayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		fridayOpen_combo = new JComboBox<String>(fridayOpenModel);
		fridayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		fridayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(fridayOpen_combo);
		
		//Arrays to populate the Jcombo
		fridayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		fridayClose_combo = new JComboBox<String>(fridayCloseModel);
		fridayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		fridayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(fridayClose_combo);
		
		JLabel lblNewLabel_11 = new JLabel("Saturday:");
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(lblNewLabel_11);
		
		//Arrays to populate the Jcombo
		saturdayOpenModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		saturdayOpen_combo = new JComboBox<String>(saturdayOpenModel);
		saturdayOpen_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		saturdayOpen_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(saturdayOpen_combo);
		
		//Arrays to populate the Jcombo
		saturdayCloseModel = new DefaultComboBoxModel<String>(new String[]{"00:00", "00:30", "01:00 ", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", 
												 "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00 ", "10:30", 
												 "11:00", "11:30", "12:00 ", "12:30 ", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", 
												 "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", 
												 "22:00", "22:30", "23:00", "23:30"});
		
		saturdayClose_combo = new JComboBox<String>(saturdayCloseModel);
		saturdayClose_combo.setBorder(UIManager.getBorder("ComboBox.border"));
		saturdayClose_combo.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_15.add(saturdayClose_combo);
		
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
		
		this.setVisible(false);
	}

	/*
	 * Getters and Setters
	 * */
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

	public JTextField getPhone_textfield() {
		return phone_textfield;
	}

	public void setPhone_textfield(JTextField phone_textfield) {
		this.phone_textfield = phone_textfield;
	}

	public JTextField getArea_textfield() {
		return area_textfield;
	}

	public void setArea_textfield(JTextField area_textfield) {
		this.area_textfield = area_textfield;
	}

	public JButton getCreateBtn() {
		return createBtn;
	}

	public void setCreateBtn(JButton createBtn) {
		this.createBtn = createBtn;
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
	
	

}
