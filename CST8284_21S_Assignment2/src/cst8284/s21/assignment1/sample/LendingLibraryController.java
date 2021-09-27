/** 
* File name: LendingLibraryController.java
* Author: Samira Ouaaz
* Course: CST8284 302 - Object Oriented Programming (Java)
* Assignment: #2, S2021
* Date: June 28, 2021
* Professor: Sandra Iroakazi
* Last modified: July 20, 2021
* Student: André dos Santos Ferreira
*/

package cst8284.s21.assignment1.sample;

import java.util.ArrayList;
import java.util.Scanner;

public class LendingLibraryController {
	
	private LendingLibrary lib;
	private static Scanner in = new Scanner(System.in);
	
	public LendingLibraryController() {
		lib = new LendingLibrary (); 
	}
	/** 
	 * add the User if it is not User of library now
	 * @return boolean as status(true for success, false for not success)
	 * @see User#equals(User)
	 */
	public void addUser() {
		System.out.println("New User Entry");

		//name is User's name
		String lname = getResponseTo("Last name: ");

		String fname = getResponseTo("First name: ");
		
		String s = getResponseTo("Age: ");
		
		int age = -1;
		if (isValidNumber(s)) {
			age = Integer.parseInt(s);
		}

		//Accept only positive age 
		if ( age > 0 ) {
			//address is User's address
			String address=getResponseTo("User address: ");
		
			// a loop covering each User of the library
			if (lib.findUser(lname, fname) != null ) {
				System.out.println("This user already exists");
			}
			else {
				User u1= new User(lname, fname, address, age);
				if (lib.addUser(u1) ) {
					System.out.println("User was added");
				} else {
					System.out.println("User could not be added");
				}
			}
		} else {
			System.out.println("Invalid age value for age.");
		}
	}

	/**
	 * change library User address
	 * @return boolean as status(true for success, false for not success)
	 * @see User#equals(User)
	 */
	public void changeUser() {
		System.out.println("User Modification");
		
		String lname = getResponseTo("Last Name: ");
		
		String fname = getResponseTo("First Name: ");

		// a loop covering each User of the library
		User u = lib.findUser(lname, fname);
		if ( u != null) {
			String add = getResponseTo("New address: ");
			//change User's address
			u.setAddress(add);
			System.out.println("Address changed");
		} else {
			System.out.println("User doesn't exist");
		}
	}
	
	/**
	 *  Prompt the user for input parameters to find
	 *  a user in the library
	 */
	public void findUser() { 
		System.out.println("Find User");

		String ln = getResponseTo("Last name: ");
		
		String fn = getResponseTo("First name: ");
		
		User c = lib.findUser(ln, fn);
		
		if (c != null ) {
			System.out.println(c);
		} else {
			System.out.println("No user with this name!");
		}
	}
	
	
	/*
	 * CREATE DELETEUSER METHOD HERE!!!
	 */
	public void deleteUser() {
		System.out.println("Delete User:");

		String lname = getResponseTo("Last name: ");

		String fname = getResponseTo("First name: ");
		
		//User u1= new User(lname, fname);
		// a loop covering each User of the library
		if (lib.findUser(lname, fname) == null ) {
				System.out.println("Error! This user was not found"); 		// SEE IF THE USER EXISTS
			}
		else {
				if (lib.findUser(lname, fname) != null) {
					lib.getLibUser().remove(lname);	
					lib.getLibUser().remove(fname);								// IF THE USER EXISTS, TRIES REMOVE IT
					System.out.println("User was removed.");					//SUCCESSFUL MESSAGE
			} else {
					System.out.println("User could not be removed.");			//FAILURE MESSAGE
				}
			}
	}
	
	
	/**
	 * 	 Output the user list of the library
	 */
	public void listUsers() {
		outputUserData(lib.getLibUser());
	}
	
	/**
	 * add the book to library's books collection
	 * @return boolean as status(true for success, false for not success)
	 */
	public void addBook() {
		System.out.println("New Book Entry");

		//name is book title
		String name=getResponseTo("Title: ");
		
		//author is book's author
		String author=getResponseTo("Author: ");

		String year=getResponseTo("Publication date (year in NNNN format): ");
		
		String isbn=getResponseTo("ISBN number (10 digits): ");
		
		if (Book.verifyISBNNumber(isbn) ) {
			if (lib.findBook(isbn) != null ) {
				System.out.println("This book already exists! Not added");
			} else {
				Book book1= new Book(isbn,name,author, year);
				if (!lib.addBook(book1) ) {
					System.out.println("Book could not be added");
				} 
			}
		} else {
			System.out.println("Invalid ISBN number");
		}
	}
	
	/**
	 * 	Prompt the user for details about the book to modify
	 *  
	 */
	public void changeBook() {
		System.out.println("Modify a Book.");

		String id = getResponseTo("ISBN number of the book to find: ");
		
		Book b = lib.findBook(id);
		if (b == null) {
			System.out.println("Could not find a book with this isbn");
		} else {

			String t = getResponseTo("New Title (Hit Enter key for no change): ");
			if (!t.isEmpty()) {
				b.setTitle(t);
			}

			String a = getResponseTo("New Author (Hit Enter key for no change): ");
			if (!a.isEmpty()) {
				b.setAuthor(a);			
			}
		}
	}
	
	/**
	 * 	Prompt the user for details about the book to find
	 */
	public void findBook() {
		Book b = null;
		System.out.println("Find a Book.");

		String bid = getResponseTo("Enter the book isbn number: ");
		
		b = lib.findBook(bid);
		
		if (b != null ) {
			System.out.println(b);
		} else {
			System.out.println("No book with this isbn!" );
		}
	}
	
	/*
	 * CREATE DELETEBOOK METHOD HERE!!!
	 */
	public void deleteBook() {
		Book b = null;
		System.out.println("Delete a Book.");

		String bid = getResponseTo("Enter the book isbn number: ");
		
		b = lib.findBook(bid);
		
		if (b != null && lib.findLoan(bid) == null) {
			lib.getLibBook().remove(b);		//The method remove(boolean) from the ArrayList deletes the first occurrence of the parameter, otherwise it's unchanged.
			System.out.println("The book was removed.");													//SUCCESSFUL MESSAGE
		} else {
			System.out.println("Error! No book with this isbn or the book could not be removed." );			//FAILURE MESSAGE
		}
	}
	
	/**
	 * 	 Output the book list of the library
	 */
	public void listBooks() {
		outputBookData(lib.getLibBook());
	}
	
	/**
	 * 	Prompt the user for details about the loan to add
	 */
	public void addBookLoan() {
		System.out.println("New Loan Entry");

		String ln = getResponseTo("User last name: ");
		
		String fn = getResponseTo("User first name: ");
		
		User user = null;
		Book b = null;
		user = lib.findUser(ln, fn);
		
		if ( user != null ) {	 
			 //bid is the book's id
			 String bid = getResponseTo("Book isbn number: ");
			 //cover each book in library
			 b = lib.findBook(bid);
			 if ( b != null) {
				 //date would be the borrow date
				 String date=getResponseTo("Loan date (format yyyy-mm-dd): ");
		 
				 executeBookLoan(user, b, date);
			 } else {
				 System.out.println("Could not find a book with this isbn!");
			 }
		} else {
			System.out.println("Invalid user!");
		}
	}
	
	/**
	 * Prompt the user for details about the loan to find
	 */
	public void findBookLoan() {
		System.out.println("Find a book loan.");
		
		Book b = null;
		BookLoan bl = null;
		
		String bid=getResponseTo("Book isbn number: ");

		b = lib.findBook(bid);
		if (b != null ) {
			bl = lib.findLoan(bid);
			if ( bl != null) {
				System.out.println( bl);
			} else {
				System.out.println("No book loan found.");
			}
		} else {
			System.out.println("No loan found with this isbn number!");
		}
	}
	
	/**
	 * Prompt the user for details about the loan to modify
	 */
	public void changeBookLoan() {
		System.out.println("Modify loan details.");
		
		String bid = getResponseTo("ISBN number for the loan you want to modify: ");

		BookLoan bl = lib.findLoan(bid);
		if ( bl != null ) {
			String d = getResponseTo("Change due date (Hit Enter key for no change): ");
			if ( d.isEmpty()) {
				System.out.println("Date not changed");
			} else {
				bl.setDueDate(d);
			}	
		} else {
			System.out.println("No loan found with this isbn number!");
		}
	}
	
	/*
	 * CREATE DELETEBOOKLOAN METHOD HERE!!!
	 */
	public void deleteBookLoan() {
		System.out.println("Delete a BookLoan.");
		String bid = getResponseTo("ISBN number for the loan you want to delete: ");
		
		BookLoan bl = lib.findLoan(bid);
		if ( bl != null ) {
			lib.getLibBookLoan().remove(bl);
			System.out.println("The book loan was removed.");
		} else {
			System.out.println("Error! No book loan found or it could not be deleted.");
		}
		
}
	/**
	 * 	 Output the book loan list of the library
	 */
	public void listBookLoans() {
		outputLoanData(lib.getLibBookLoan());
	}

	/**
	 * create loan
	 * @param User User who would loan book
	 * @param book book which would be loaned
	 * @param date the loan date
	 * @return boolean as status(true for success, false for not success)
	 */
	private void executeBookLoan(User user, Book book, String date) {

		//loop cover each item in the collection of loaned book, User who loaned and loan-date
		for (BookLoan bookloan : lib.getLibBookLoan()) {
			//if book exists in book loan, display "book is loaned",return false
			
			if(bookloan != null && bookloan.getBook().getBookId().equals(book.getBookId())){
				System.out.println("Book is already loaned.");
				return;
			}
		}
		//if books the User loaned are less than max,borrow this book and return true, else, return false
		if(lib.userCanBorrow(user)){
			
			BookLoan bookloan1 = new BookLoan(user,book,date);
			if (lib.addBookLoan(bookloan1)) {
				
				System.out.println("Loan added.");
				System.out.println(bookloan1);
			}
			else {
				System.out.println("Could not add this loan.");
			}
		}else {
			System.out.println("User is not allowed to borrow more books.");
			
		}	
	}
	
	/**
	 *  private method that does the real display
	 * @param l : array of books to display
	 */
	private void outputBookData(ArrayList<Book> l) {
		int i = 1;
		for (Book element : l) {
			if (element != null) {
				System.out.println("Book #" + i++);
				System.out.println(element);
			}
		}
	}
	
	/**
	 *  private method that does the real display
	 * @param l : array of users to display
	 */
	private void outputUserData(ArrayList<User> l) {
		int i = 1;
		for (User element : l) {
			if (element != null) {
				System.out.println("User #" + i++);
				System.out.println(element);
			}
		}
	}
	
	/**
	 *  private method that does the real display
	 * @param l : array of book loans to display
	 */
	private void outputLoanData(ArrayList<BookLoan> l) {
		int i=1;
		for (BookLoan element : l) {
			if (element != null) {
				System.out.println("Loan #" + i++);
				System.out.println(element);
			}
		}
	}
	
	/**
	 * 
	 * @param s	: string to display
	 * @return	: input string by the user
	 */
	private static String getResponseTo(String s) {
		System.out.print(s);
		return(in.nextLine());
	}
 	
	
	/*
  	 * Returns true if the given String is null or empty, 
  	 * returns false if not.
  	 * 
  	 * @param s
  	 * @return boolean
  	 */
  	public static boolean isNullOrEmpty(String s) {
  		return s == null || s.equals("");
  	}
  	
  	/**
  	 * 
  	 * @param digits 	: input string to check
  	 * @return			: true if the string is digits only
  	 * 					  false if the input contains other characters
  	 */
	public static boolean isDigitsOnly(String digits) {
   		return digits.matches("^[0-9]*$");
   	}
	
	/**
	 * 
	 * @param s		: input string
	 * @return		: true if the string is a number
	 */
	private static boolean isValidNumber(String s) {
		return (!isNullOrEmpty(s) && isDigitsOnly(s));
	}

}
