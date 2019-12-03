package com.realeigenvalue.jmsg_client;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClientModelTest {
	@Test
	public void testClientModel() {
		ClientModel cm = new ClientModel();
		assertEquals("", cm.getIpAdress());
		assertEquals(-1, cm.getPortNumber());
		assertEquals("", cm.getUserName());
	}
	@Test
	public void testGetIpAdress() {
		ClientModel cm = new ClientModel();
		assertEquals("", cm.getIpAdress());
		cm.setIpAdress("127.0.0.1");
		assertEquals("127.0.0.1", cm.getIpAdress());
	}
	@Test
	public void testSetIpAdress() {
		ClientModel cm = new ClientModel();
		assertEquals("", cm.getIpAdress());
		cm.setIpAdress("127.0.0.1");
		assertEquals("127.0.0.1", cm.getIpAdress());	
	}
	@Test
	public void testGetPortNumber() {
		ClientModel cm = new ClientModel();
		assertEquals(-1, cm.getPortNumber());
		cm.setPortNumber("1024");
		assertEquals(1024, cm.getPortNumber());
		cm.setPortNumber("asdfasdf");
		assertEquals(-1, cm.getPortNumber());
	}
	@Test
	public void testSetPortNumber() {
		ClientModel cm = new ClientModel();
		assertEquals(-1, cm.getPortNumber());
		cm.setPortNumber("1024");
		assertEquals(1024, cm.getPortNumber());
		cm.setPortNumber("asdfasdf");
		assertEquals(-1, cm.getPortNumber());	
	}
	@Test
	public void testGetUserName() {
		ClientModel cm = new ClientModel();
		assertEquals("", cm.getUserName());
		cm.setUserName("user");
		assertEquals("user", cm.getUserName());
	}
	@Test
	public void testSetUserName() {
		ClientModel cm = new ClientModel();
		assertEquals("", cm.getUserName());
		cm.setUserName("user");
		assertEquals("user", cm.getUserName());	
	}
	@Test
	public void testExists() {
		ClientModel cm = new ClientModel();
		assertEquals(false, cm.exists("192.168.1.1", -1));
	}
}