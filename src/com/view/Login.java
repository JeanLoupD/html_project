package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import com.control.LoginController;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class Login extends JFrame {

	//private JFrame frame;
	private JTextField username_textfield;
	private JPasswordField password_textfield;
	private JButton loginBtn;
	private JButton newClientBtn;
	private JButton quitBtn;
	

	/**
	 * Create the application.
	 */
	public Login() {
	
		this.setBounds(100, 100, 1000, 750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(35, 0, 0, 0));
		panel.setBackground(new Color(35, 47, 62));
		panel.setPreferredSize(new Dimension(10, 150));
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Amazon System");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 60));
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setBorder(new EmptyBorder(12, 0, 0, 0));
		panel_1.setBackground(new Color(35, 47, 62));
		panel_1.setPreferredSize(new Dimension(10, 75));
		this.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		loginBtn = new JButton("Login");
		loginBtn.setBackground(new Color(255, 153, 0));
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		loginBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		loginBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(loginBtn);
		
		newClientBtn = new JButton("New Client");
		newClientBtn.setBackground(new Color(255, 216, 20));
		newClientBtn.setForeground(Color.WHITE);
		newClientBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		newClientBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(newClientBtn);
		
		quitBtn = new JButton("Quit");
		quitBtn.setForeground(Color.WHITE);
		quitBtn.setBackground(new Color(255, 0, 0));
		quitBtn.setBorder(UIManager.getBorder("CheckBox.border"));
		quitBtn.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(quitBtn);
		
		JPanel panel_2 = new JPanel();
		this.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 75));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setPreferredSize(new Dimension(10, 7));
		panel_8.setBackground(new Color(255, 153, 0));
		panel_3.add(panel_8, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(35, 47, 62));
		panel_4.setPreferredSize(new Dimension(10, 100));
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setPreferredSize(new Dimension(10, 7));
		panel_8_1.setBackground(new Color(255, 153, 0));
		panel_4.add(panel_8_1, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(250, 10));
		panel_2.add(panel_5, BorderLayout.WEST);
		panel_5.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(250, 10));
		panel_2.add(panel_6, BorderLayout.EAST);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EmptyBorder(80, 0, 20, 0));
		panel_2.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 25));
		panel_7.add(lblNewLabel);
		
		username_textfield = new JTextField();
		username_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		username_textfield.setFont(new Font("Dialog", Font.PLAIN, 25));
		panel_7.add(username_textfield);
		username_textfield.setColumns(13);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 24));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
		panel_7.add(lblNewLabel_1);
		
		password_textfield = new JPasswordField();
		password_textfield.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, Color.BLACK));
		password_textfield.setColumns(13);
		password_textfield.setFont(new Font("Dialog", Font.PLAIN, 25));
		panel_7.add(password_textfield);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	//Creating Getters and Setters
	
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

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getNewClientBtn() {
		return newClientBtn;
	}

	public void setNewClientBtn(JButton newClientBtn) {
		this.newClientBtn = newClientBtn;
	}

	public JButton getQuitBtn() {
		return quitBtn;
	}

	public void setQuitBtn(JButton quitBtn) {
		this.quitBtn = quitBtn;
	}
	
	

}
