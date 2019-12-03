package com.realeigenvalue.jmsg_client;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ClientView extends JFrame {
	private JTextField textField;
	private JButton sendButton;
	private JTextArea displayArea;
	public ClientView() {
		textField = new JTextField("Enter Text");
		textField.setPreferredSize(new Dimension(400, 64));
		sendButton = new JButton("SEND");
		displayArea = new JTextArea(10, 64);
		displayArea.setEditable(false);		
		JScrollPane displayScrollPane = new JScrollPane(displayArea);
		displayScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel mainPanel = new JPanel();
		mainPanel.add(textField);
		mainPanel.add(sendButton);
		mainPanel.add(displayScrollPane);
		this.setContentPane(mainPanel);
		this.pack();
		this.setTitle("jmsg-client");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public JTextField getTextField() {
		return textField;
	}
	public JButton getSendButton() {
		return sendButton;
	}
	public JTextArea getDisplayArea() {
		return displayArea;
	}
	public static String[] startDialog() {
		JTextField ipAddress = new JTextField();
		JTextField portNumber = new JTextField();
		JTextField userName = new JTextField();
		Object[] message = {
				"IP:", ipAddress,
				"PORT:", portNumber,
				"USERNAME:", userName
		};
		Object[] options = {"CONNECT"};	
		int option = JOptionPane.showOptionDialog(null, message, "jmsg-client", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);
		if(option == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		String[] ret = {ipAddress.getText(), portNumber.getText(), userName.getText()};
		return ret;
	}
}