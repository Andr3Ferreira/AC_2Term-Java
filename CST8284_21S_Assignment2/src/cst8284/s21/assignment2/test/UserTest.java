/** 
* File name: UserTest.java
* Author: André dos Santos Ferreira
* Course: CST8284 302 - Object Oriented Programming (Java)
* Assignment: #2, S2021
* Date: June 28, 2021
* Professor: Sandra Iroakazi 
*/
package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import cst8284.s21.assignment1.sample.User;

public class UserTest {

	private String DEFAULT_LNAME = "Silva";
	private String DEFAULT_FNAME = "Lillian";
	private String DEFAULT_ADDRESS = "45 Bertona St, Nepean";
	private int DEFAULT_AGE = 18;
	private int DEFAULT_ID = 1000;
	
	private String OTHER_LNAME = "BENCHK";
	User user1;

	@Before
	public void setUp() throws Exception {
		user1 = new User(DEFAULT_ID, DEFAULT_LNAME, DEFAULT_FNAME, DEFAULT_ADDRESS, DEFAULT_AGE);
	}

	@Test
	public void testUserTrue() {
		String lastName = user1.getLastName();
		assertTrue(lastName.equals(DEFAULT_LNAME));
	}

	@Test
	public void testUserFalse() {
		String lastName = user1.getLastName();
		assertFalse(lastName.equals(OTHER_LNAME));
	}


	@Test
	public void testGetUserIdTrue() {
		int id = user1.getUserId();
		assertTrue(id == DEFAULT_ID);
	}

	@Test
	public void testGetUserIdFalse() {
		int id = user1.getUserId();
		assertFalse(id == 2000);
	}

	@Test
	public void testGetLastNameTrue() {
		String lastName = user1.getLastName();
		assertTrue(lastName.equals(DEFAULT_LNAME));
	}

	@Test
	public void testGetLastNameFalse() {
		String lastName = user1.getLastName();
		assertFalse(lastName.equals(OTHER_LNAME));
	}

	@Test
	public void testGetFirstNameTrue() {
		String firstName = user1.getFirstName();
		assertTrue(firstName.equals(DEFAULT_FNAME));
	}

	@Test
	public void testGetFirstNameFalse() {
		String firstName = user1.getFirstName();
		assertFalse(firstName.equals("Barbara"));
	}

	@Test
	public void testGetAddressTrue() {
		String address = user1.getAddress();
		assertTrue(address.equals(DEFAULT_ADDRESS));
	}

	@Test
	public void testGetAddressFalse() {
		String address = user1.getAddress();
		assertFalse(address.equals("1385 Woodroffe Ave, Nepean"));
	}

	@Test
	public void testGetAgeTrue() {
		int age = user1.getAge();
		assertTrue(age == DEFAULT_AGE);
	}

	@Test
	public void testGetAgeFalse() {
		int age = user1.getAge();
		assertFalse(age == 20);
	}

}
