/** 
* File name: BookTest.java
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

import cst8284.s21.assignment1.sample.Book;

public class BookTest {
	
	private String DEFAULT_ISBN = "9780132350";
	private String DEFAULT_TITLE = "Clean Code: A Handbook of Agile Software Craftsmanship";
	private String DEFAULT_AUTHOR = "Robert C. Martin";
	private String DEFAULT_YEAR = "2009";

	private String OTHER_ISBN = "9780132300";
	Book cleanCode;

	@Before
	public void setUp() throws Exception {
		cleanCode = new Book(DEFAULT_ISBN, DEFAULT_TITLE, DEFAULT_AUTHOR, DEFAULT_YEAR);	
	}

	@Test
	public void testBookTrue() {
		String id = cleanCode.getBookId();
		assertTrue(id.equals(DEFAULT_ISBN));
	}

	@Test
	public void testBookFalse() {
		String id = cleanCode.getBookId();
		assertFalse(id.equals(OTHER_ISBN));
	}

	@Test
	public void testGetBookIdTrue() {
		String id = cleanCode.getBookId();
		assertTrue(id.equals(DEFAULT_ISBN));
	}

	@Test
	public void testGetBookIdFalse() {
		String id = cleanCode.getBookId();
		assertFalse(id.equals(OTHER_ISBN));
	}

	@Test
	public void testGetTitleTrue() {
		String title = cleanCode.getTitle();
		assertTrue(title.equals(DEFAULT_TITLE));
	}

	@Test
	public void testGetTitleFalse() {
		String title = cleanCode.getTitle();
		assertFalse(title.equals("Big Java"));
	}

	@Test
	public void testGetAuthorTrue() {
		String author = cleanCode.getAuthor();
		assertTrue(author.equals(DEFAULT_AUTHOR));
	}

	@Test
	public void testGetAuthorFalse() {
		String author = cleanCode.getAuthor();
		assertFalse(author.equals("Machado de Assis"));
	}

	@Test
	public void testGetPubDateTrue() {
		String pubDate = cleanCode.getPubDate();
		assertTrue(pubDate.equals(DEFAULT_YEAR));
	}

	@Test
	public void testGetPubDateFalse() {
		String pubDate = cleanCode.getPubDate();
		assertFalse(pubDate.equals("2019"));
	}


}
