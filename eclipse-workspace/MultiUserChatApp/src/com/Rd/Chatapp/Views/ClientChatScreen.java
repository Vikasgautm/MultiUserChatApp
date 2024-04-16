package com.Rd.Chatapp.Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.Rd.Chatapp.network.Client;
import com.Rd.Chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class ClientChatScreen extends JFrame {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private Client client;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					try {
						ClientChatScreen frame = new ClientChatScreen();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(IOException e) {
						e.printStackTrace();
					}
					
	}
	private void sendIt() {
		String message=textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME+"_"+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		setFont(new Font("Dialog",Font.BOLD,10));
//		textArea=new JTextArea();
//		client=new Client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(7,6,495,237);
		contentPane.add(scrollPane);
		
		
//		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
//		textArea.setBounds(5, 3, 500, 230);
//		scrollPane.setViewportView(textArea);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 255, 368, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton sendIt = new JButton("Send Message");
		sendIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendIt.setFont(new Font("Tahoma",Font.BOLD,10));
		sendIt.setBounds(380, 256, 107, 23);
		contentPane.add(sendIt);
		textArea=new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		client=new Client(textArea);
		textArea.setFont(new Font("Monospaced",Font.ITALIC,16));
		textArea.setBounds(7, 6, 495, 237);
		setVisible(true);
	}
}
