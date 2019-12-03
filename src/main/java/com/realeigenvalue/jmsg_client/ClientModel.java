package com.realeigenvalue.jmsg_client;

import java.net.Socket;

public class ClientModel {
	private String ipAdress;
	private int portNumber;
	private String userName;
	public ClientModel() {
		this.ipAdress = "";
		this.portNumber = -1;
		this.userName = "";
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public boolean setPortNumber(String portNumber) {
		try {
			this.portNumber = Integer.parseInt(portNumber);
			return true;
		} catch(Exception e) {
			this.portNumber = -1;
			return false;
		}
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean exists(String ipAddress, int portNumber) {
		Socket test = null; boolean ret = false;
		try {
			test = new Socket(ipAddress, portNumber);
			ret = true;
		} catch(Exception e) {
			ret = false;
		}
		if(test != null) {
			try {
				test.close();
			} catch (Exception e) {}
		}
		return ret;
	}
}