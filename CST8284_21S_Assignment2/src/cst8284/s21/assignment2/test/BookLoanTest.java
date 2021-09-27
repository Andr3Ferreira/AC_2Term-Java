/** 
* File name: BookLoanTest.java
* Author: André dos Santos Ferreira
* Course: CST8284 302 - Object Oriented Programming (Java)
* Assignment: #2, S2021
* Date: June 28, 2021
* Professor: Sandra Iroakazi 
*/

package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.s21.assignment1.sample.Book;
import cst8284.s21.assignment1.sample.BookLoan;
import cst8284.s21.assignment1.sample.User;

public class BookLoanTest {

	
	
	private String DEFAULT_LNAME = "Ferreira";
	private String DEFAULT_FNAME = "Andre";
	private String DEFAULT_ADDRESS = "";
	private int DEFAULT_AGE = 28;
	private User DEFAULT_USER = new User(DEFAULT_LNAME, DEFAULT_FNAME, DEFAULT_ADDRESS, DEFAULT_AGE);
	private String DEFAULT_TITLE = "Big Java Early Objects";
	private String DEFAULT_AUTHOR = "Horstmann Cay";
	private String DEFAULT_PUBDATE = "2018";
	private String DEFAULT_ID = "97889896745";
	private Book DEFAULT_BOOK = new Book(DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_PUBDATE, DEFAULT_ID);		
	private String DEFAULT_DUEDATE = "2021-07-20";

	private String OTHER_DUEDATE = "2021-08-21";
	BookLoan bl;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {}

	@Before
	public void setUp() throws Exception {
		bl = new BookLoan(DEFAULT_USER, DEFAULT_BOOK, DEFAULT_DUEDATE);
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testBookLoanTrue() {
		String dueDate = bl.getDueDate().toString();
		assertTrue(dueDate.equals(DEFAULT_DUEDATE));
	}
	
	@Test
	public void testBookLoanFalse() {
		String dueDate = bl.getDueDate();
		assertFalse(dueDate.equals(OTHER_DUEDATE));
	}

	@Test
	public void testGetBookTrue() {
		Book book = bl.getBook();
		assertTrue(book.equals(DEFAULT_BOOK));
	}

	@Test
	public void testGetBookFalse() {
		Book book = bl.getBook();
		assertFalse(book.equals("Dom Casmurro"));
	}

	@Test
	public void testGetUserTrue() {
		User user = bl.getUser();
		assertTrue(user.equals(DEFAULT_USER));
	}

	@Test
	public void testGetUserFalse() {
		User user = bl.getUser();
		assertFalse(user.equals("Another User"));
	}

	@Test
	public void testGetDueDateTrue() {
		String dueDate = bl.getDueDate();
		assertTrue(dueDate.equals(DEFAULT_DUEDATE));
	}

	@Test
	public void testGetDueDateFalse() {
		String dueDate = bl.getDueDate();
		assertFalse(dueDate.equals(OTHER_DUEDATE));
	}

}
