package com.realeigenvalue.jmsg_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private ClientModel model;
	private ClientView view;
	private PrintWriter output;
	private BufferedReader input;
	public Client() {
		model = new ClientModel();
		while(true) {
			String[] ret = ClientView.startDialog();
			model.setIpAdress(ret[0]);
			model.setUserName(ret[2]);
			if((model.setPortNumber(ret[1])) == true) {
				break;
			}
		}
		view = new ClientView();
		try {
			Socket client_socket = new Socket(model.getIpAdress(), model.getPortNumber());
			output = new PrintWriter (client_socket.getOutputStream(), true);
			input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			view.getSendButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					output.println(model.getUserName() + ": " + view.getTextField().getText());
				}
			});
			String line;
			try {
				while((line = input.readLine()) != null) {
					view.getDisplayArea().append(line + "\n"); //client stays connected
				}
			} catch (IOException e) {
			}
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}
	}
}