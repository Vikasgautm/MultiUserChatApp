package com.Rd.Chatapp.Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.Rd.Chatapp.dao.UserDAO;
import com.Rd.Chatapp.dto.UserDTO;
import com.Rd.Chatapp.utils.UserInfo;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

 

	public static void main(String[] args) {
					UserScreen window = new UserScreen();
	}
	UserDAO userDAO=new UserDAO();
	 private void doLogin() throws Exception {
		 String userid=useridtxt.getText();
			char [] password=passwordField.getPassword();
			UserDTO userDTO=new UserDTO(userid, password);
			try {
				String message="";
				if(userDAO.isLogin(userDTO)){
					message ="Welcome "+userid;
					UserInfo.USER_NAME=userid;
					JOptionPane.showMessageDialog(this, message);
					setVisible(false);
					dispose();
					DashBoard dashBoard=new DashBoard(message);
					dashBoard.setVisible(true);
				}
				else {
					message="Invalid Userid or Password";
					JOptionPane.showMessageDialog(this, message);
				}
				//JOptionPane.showMessageDialog(this, message);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	private void register() {
		String userid=useridtxt.getText();
		char [] password=passwordField.getPassword();
		UserDTO userDTO=new UserDTO(userid, password);
		try {
		int result =userDAO.add(userDTO);
		if(result>0) {
			JOptionPane.showMessageDialog(this, "Register Successfully");
			//System.out.println("Record Added...");
		}
		else {
			//System.out.println("Record not added..");
			JOptionPane.showMessageDialog(this, "Register fail");

		}
		}
		catch(ClassNotFoundException |SQLException ex) {
			System.out.println("DB Issue.. ");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic exception Raised..");
			ex.printStackTrace();
		}
		System.out.println("userid "+userid+" Password "+password);
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 11, 147, 49);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(216, 60, 161, 20);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel Userid = new JLabel("UserId");
		Userid.setFont(new Font("Tahoma", Font.BOLD, 15));
		Userid.setHorizontalAlignment(SwingConstants.CENTER);
		Userid.setBounds(83, 60, 73, 20);
		getContentPane().add(Userid);
		
		JLabel Pwdlbl = new JLabel("Password");
		Pwdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		Pwdlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		Pwdlbl.setBounds(83, 108, 73, 20);
		getContentPane().add(Pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(221, 110, 156, 20);
		getContentPane().add(passwordField);
		
		JButton Loginbt = new JButton("Login");
		Loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					try {
						doLogin();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}	
		});
		//Loginbt.addActionListener(new ActionListener() 
		Loginbt.setFont(new Font("Tahoma", Font.BOLD, 15));
		Loginbt.setBounds(83, 178, 89, 34);
		getContentPane().add(Loginbt);
	
		
		JButton Registerbt = new JButton("Register");
		Registerbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		Registerbt.setFont(new Font("Tahoma", Font.BOLD, 15));
		Registerbt.setBounds(235, 178, 106, 34);
		getContentPane().add(Registerbt);
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 511, 282);
		setSize(600,390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
