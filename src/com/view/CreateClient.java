package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.control.CreateClientController;

import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.UIManager;

public class CreateClient extends JFrame {

	//private JFrame frame;
	private JTextField username_textfield;
	private JPasswordField password_textfield;
	private JPasswordField confirm_textfield;
	private JTextField firstname_textfield;
	private JTextField lastname_textfield;
	private JTextField address_textfield;
	private JTextField email_textfield;
	private JTextField phone_textfield;
	private JButton saveBtn;
	private JButton returnBtn;
	private JButton quitBtn;
	private JButton verifyBtn;

	/**
	 * Create the application.
	 */
	public CreateClient() {
	
		//frame = new JFrame();
		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(7, 0, 0, 0));
		panel.setPreferredSize(new Dimension(10, 75));
		panel.setBackground(new Color(35, 47, 62));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Create New Client");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 35));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(35, 47, 62));
		panel_1.setBorder(new EmptyBorder(12, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setPreferredSize(new Dimension(10, 75));
		this.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		saveBtn = new JButton("Save");
		saveBtn.setForeground(Color.WHITE);
		saveBtn.setBackground(new Color(255, 153, 0));
		saveBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		saveBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(saveBtn);
		
		returnBtn = new JButton("Return");
		returnBtn.setForeground(Color.WHITE);
		returnBtn.setBackground(new Color(255, 216, 20));
		returnBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		returnBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(returnBtn);
		
		quitBtn = new JButton("Quit");
		quitBtn.setForeground(Color.WHITE);
		quitBtn.setBackground(new Color(255, 0, 0));
		quitBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		quitBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(quitBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(250, 10));
		this.getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(28, 0, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setPreferredSize(new Dimension(250, 10));
		this.getContentPane().add(panel_3, BorderLayout.EAST);
		
		verifyBtn = new JButton("Verify");
		verifyBtn.setForeground(Color.WHITE);
		verifyBtn.setBackground(new Color(255, 153, 0));
		verifyBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		verifyBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_3.add(verifyBtn);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(30, 0, 100, 0));
		this.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(8, 2, -130, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_1);
		
		username_textfield = new JTextField();
		username_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		username_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(username_textfield);
		username_textfield.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_2);
		
		password_textfield = new JPasswordField();
		password_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		password_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(password_textfield);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_3);
		
		confirm_textfield = new JPasswordField();
		confirm_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		confirm_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(confirm_textfield);
		
		JLabel lblNewLabel_4 = new JLabel("First name:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_4);
		
		firstname_textfield = new JTextField();
		firstname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		firstname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(firstname_textfield);
		firstname_textfield.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Last name:");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_5);
		
		lastname_textfield = new JTextField();
		lastname_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		lastname_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lastname_textfield);
		lastname_textfield.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_6);
		
		address_textfield = new JTextField();
		address_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		address_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(address_textfield);
		address_textfield.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_7);
		
		email_textfield = new JTextField();
		email_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		email_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(email_textfield);
		email_textfield.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Phone number:");
		lblNewLabel_8.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_8);
		
		try {
			MaskFormatter telephone = new MaskFormatter("(###)###-####");
			phone_textfield = new JFormattedTextField(telephone);
			phone_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
			phone_textfield.setFont(new Font("Dialog", Font.PLAIN, 20));
			panel_4.add(phone_textfield);
			phone_textfield.setColumns(10);
		} catch (ParseException e) {
			System.err.println("Enter your phone number in this format: ###-###-####");
		}
		
		this.setVisible(false);
	}

	/*
	 * Getters and Setters
	 * */
	public JButton getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(JButton saveBtn) {
		this.saveBtn = saveBtn;
	}

	public JButton getReturnBtn() {
		return returnBtn;
	}

	public void setReturnBtn(JButton returnBtn) {
		this.returnBtn = returnBtn;
	}

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public void setQuitBtn(JButton quitBtn) {
		this.quitBtn = quitBtn;
	}

	public JButton getVerifyBtn() {
		return verifyBtn;
	}

	public void setVerifyBtn(JButton verifyBtn) {
		this.verifyBtn = verifyBtn;
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

	public JTextField getPhone_textfield() {
		return phone_textfield;
	}

	public void setPhone_textfield(JTextField phone_textfield) {
		this.phone_textfield = phone_textfield;
	}

	
	
}
