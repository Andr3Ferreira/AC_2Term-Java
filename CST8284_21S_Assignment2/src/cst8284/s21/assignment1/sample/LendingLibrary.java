/** 
* File name: LendingLibrary.java
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

/** 
* Library class enable users to display menu,
* add/change/remove User,add/remove book, borrow book,
* display Users,books,and due date.
* @version 1.0
* @author 
*/
public class LendingLibrary {

	private static final int MAX_LOAN_PER_USER = 2;
	
	/**
     * collection of books(being loaned), Users(who loaned books) and loan-date
     * 
     */

	private ArrayList<Book> libBooks;
	
	private ArrayList<User> libUsers;
	
	private ArrayList<BookLoan> libBookLoans;
	
	 /**
	  * constructor of Library, 
	  * @param libBook collection of books 
	  * @param libUser	collection of Users 
	  * @param libBookLoan	collection of books(being loaned), Users(who loaned books) and loan-date
	  */
	public LendingLibrary() {
		
		libBooks = new ArrayList<Book>(); 
		
		libUsers = new ArrayList<User>();

		libBookLoans = new ArrayList<BookLoan>(); 

	}
	/**
	 * gets  books owned by the library
	 * @return the ArrayList of books owned by the library
	 */
	public ArrayList<Book> getLibBook() { 
		return libBooks;
	}
	/**
	 * sets  books owned by the library
	 * @param libBook
	 * 		collection of books
	 */
	public void setLibBook(ArrayList<Book> libBook) { 
		this.libBooks = libBook;
		
	}
	/**
	 * gets Users of the library
	 * @return the ArrayList of Users of the library
	 */
	public ArrayList<User> getLibUser() {
		return libUsers;
	}
	/**
	 * sets the Users of the library
	 * @param libUser collection of Users
	 */
	public void setLibUser(ArrayList<User> libUser) {
		this.libUsers = libUser;		
	}
	/**
	 * get the collection of books(being loaned), Users(who loaned books) and loan-date in the library
	 * @return the ArrayList of books,Users, and loan-dates
	 */
	public ArrayList<BookLoan> getLibBookLoan() {
		return libBookLoans;
	}
	/**
	 * set the books(being loaned), Users(who loaned books) and loan-date in the library
	 * @param libBookLoan collection of books,Users, and loan-dates
	 */
	public void setLibBookLoan(ArrayList<BookLoan> libBookLoan) {//BookLoan[] 
		this.libBookLoans = libBookLoan;	
	}

	/**
	 * 
	 * @param lname		: User's last name
	 * @param fname		: User's first name
	 * @param address	: User's address 
	 * @param age		: User's age
	 * @return			: new User object
	 */
	public User makeUser(String lname, String fname, String address, int age) {
		return new User (lname, fname, address, age); 
	}
	
	/**
	 * Adds a user to the array
	 * @param u 	: User object
	 * @return		: true if we could add the object to the array
	 * 				: false if we have  reached the max array capacity
	 */
	public boolean addUser(User u) {
		if (!libUsers.contains(u)) { 
			libUsers.add(u);
			return true;			
		}
		return false;
	}
	
	/**
	 * Adds a book to the array
	 * @param b 	: Book object
	 * @return		: true if we could add the object to the array
	 * 				: false if we have  reached the max array capacity
	 */
	public boolean addBook(Book b) {
		if (!libBooks.contains(b)) { //Use the method equals() from Book to check if b is a instance of Book()
			libBooks.add(b);
			return true;
		}
		return false;
	}
	
	/**
	 * Adds a book loan to the array
	 * @param bl 	: BookLoan object
	 * @return		: true if we could add the object to the array
	 * 				: false if we have  reached the max array capacity
	 */

	public boolean addBookLoan(BookLoan bl) {
		if (!libBookLoans.contains(bl)) { //Use the method equals() from User to check if u is a instance of User(); 
			libBookLoans.add(bl);
			return true;
		}
		return false;
	}

	
	/**
	 * Find a loan with this isbn number
	 * @param id 	: book isbn number
	 * @return 		: BookLoan object if found, null otherwise
	 */
	public BookLoan findLoan(String id) {
		for(BookLoan bl: libBookLoans) {
			//find the book with the given id
			if(bl!=null && bl.getBook().getBookId().equals(id)) {
				return bl;
			} 
		 }	
		return null;
	}
	
	/**
	 * Find the book with this isbn number  in the registry
	 * @param bid 	: book isbn number
	 * @return 		: Book object if found, null otherwise 
	 * 	  
	 */
	public Book findBook(String bid) {
		//cover each book in library
		for(Book book: getLibBook()) {
			//find the book with the given id
			if(book!=null && book.getBookId().equals(bid)) {
				//assign b to the book with the given id
				return book;
			} 
		}	
		return null;
	}
	
	/**
	 * Find the user with these first and last name in the registry
	 * @param l :  user's last name
	 * @param f : user's first name
	 * @return 	:  User object with the same last and first name if found
	 * 			: null otherwise
	 */
	public User findUser(String l, String f) {
		//cover each book in library
		for(User  c: libUsers) {
			//find the book with the given id
			if(c!=null && c.getLastName().equals(l)
						&& c.getFirstName().equals(f) ) {
				return c;
			} 
		}
		return null;
	}
	
	
	/**
	 * check whether User has loaned book
	 * @param User User to be checked
	 * @return boolean as status(true for success, false for not success)
	 * @see User#equals(User)
	 */
	public boolean isBookLoaned(Book b) {
		//loop cover each item in the collection of loaned book, User who loaned and loan-date
		for (BookLoan bookloan : getLibBookLoan()) {
			//If User equals to one User in the collection, return true. if not, return false
			if (bookloan!=null && bookloan.getBook().equals(b)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param u User
	 * @return True if user loaned less than max books so far
	 */
	public boolean userCanBorrow(User u) {
		
		int numBook=0;		
		for (BookLoan bookloan : getLibBookLoan()) {
						
			// check how many books the user loaned
			if(bookloan != null && u.equals(bookloan.getUser())) {
				numBook++;	
			}
		}
		//if books the User loaned are less than max,borrow this book 
		//and return true, else, return false
		return (numBook < MAX_LOAN_PER_USER);
	}
	
	public boolean deleteUser(String firstName, String lastName) {
		//CHECK IF THE USER ASKED TO BE DELETED EXIST AND IT EXISTS IN THE ARRAYLIST
		//IF IT EXISTS, CALL THE DELETE METHOD FROM appCtrl
		for(User u :libUsers) {
		LendingLibraryController appCtrl = new LendingLibraryController();
		appCtrl.deleteUser();
		System.out.println("User was removed.");
		return true;
		}
		System.out.println("Error! User could not be removed or was not found.");
		return false;
	}
	
	public boolean deleteBook(String isbnNumber){
		//CHECK IF THE BOOK ASKED TO BE DELETED EXIST AND IT EXISTS IN THE ARRAYLIST
		//IF IT EXISTS, CALL THE DELETE METHOD FROM appCtrl
		for(Book b:libBooks) {
		LendingLibraryController appCtrl = new LendingLibraryController();
		appCtrl.deleteBook();
		System.out.println("Book was removed.");
		return true;
		}
		System.out.println("Error! Book could not be removed or was not found.");
		return false;
	}
	
	public boolean deleteLoan(String isbnNumber){
		//CHECK IF THE LOAN ASKED TO BE DELETED EXIST AND IT EXISTS IN THE ARRAYLIST
		//IF IT EXISTS, CALL THE DELETE METHOD FROM appCtrl
		for(BookLoan bl:libBookLoans) {
		LendingLibraryController appCtrl = new LendingLibraryController();
		appCtrl.deleteBookLoan();
		System.out.println("Loan was removed.");
		return true;
		}
		System.out.println("Error! Loan could not be removed or was not found.");
		return false;
	}
}

