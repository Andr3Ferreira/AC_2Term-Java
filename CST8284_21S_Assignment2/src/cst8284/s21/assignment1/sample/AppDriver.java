/** 
* File name: AppDriver.java
* Author: Samira Ouaaz
* Course: CST8284 302 - Object Oriented Programming (Java)
* Assignment: #2, S2021
* Date: June 28, 2021
* Professor: Sandra Iroakazi
* Last modified: July 20, 2021
* Student: André dos Santos Ferreira
*/

package cst8284.s21.assignment1.sample;

import java.util.Scanner;


/**
* main class.
* @author 
* @version 1.0
*/
public class AppDriver {
	
	private static final int APP_EXIT = 0,
							APP_ADD_BOOK = 1,
							APP_MOD_BOOK = 2,
							APP_FIND_BOOK = 3,
							APP_LIST_BOOKS = 4,
							
							APP_ADD_USER = 5,
							APP_MOD_USER = 6,
							APP_FIND_USER = 7,
							APP_LIST_USERS = 8,
							
							APP_ADD_LOAN = 9,
							APP_MOD_LOAN = 10,
							APP_FIND_LOAN = 11,
							APP_LIST_LOANS = 12,
							
							APP_DELETE_BOOK = 13, //THIS METHOD WAS ADDED
							APP_DELETE_USER = 14,  //THIS METHOD WAS ADDED
							APP_DELETE_LOAN = 15;//THIS METHOD WAS ADDED

				
	
	private static Scanner in = new Scanner(System.in);
	
	LendingLibraryController appCtrl;
	
	public AppDriver() {
		appCtrl = new LendingLibraryController();
	}
	
	/*
	 * Launches the program
	 */
	public void startApp() {

		int choice = -1;
		do {
			choice = displayAppMenu();
			executeMenuItem(choice);
		} while (choice != APP_EXIT);

	}
	
	private static int displayAppMenu() {

		StringBuilder sb = new StringBuilder ("Enter a selection from the following menu:\n");
		sb.append(
				APP_ADD_BOOK + 		". Enter a new book\n" + 
				APP_MOD_BOOK + 		". Modify book details. Enter the book isbn number\n" +				
				APP_FIND_BOOK + 	". Find a book by isbn number\n" +
				APP_LIST_BOOKS + 	". Display list of all books\n" + 
				"\n" +
				APP_ADD_USER + 		". Add a new user\n" + 
				APP_MOD_USER + 		". Modify user details\n" + 				
				APP_FIND_USER + 	". Find a user by name\n" + 
				APP_LIST_USERS + 	". Display all users\n" + 
				"\n" +
				APP_ADD_LOAN + 		". Add a loan. Link a user name to a book by isbn number\n" + 
				APP_MOD_LOAN + 		". Modify a loan. Loan is identified by isbn number \n" + 
				APP_FIND_LOAN + 	". Find a loan. Loan is identified by isbn number\n" +
				APP_LIST_LOANS + 	". Display all loans\n" + 
				"\n" +
				APP_DELETE_BOOK +	". Delete a book\n" + //THIS METHOD WAS ADDED
				APP_DELETE_USER +	". Deletes a user\n" + //THIS METHOD WAS ADDED
				APP_DELETE_LOAN +	". Deletes a loan\n" + //THIS METHOD WAS ADDED
				APP_EXIT + 			". Exit program\n\n");

		int c = 0;
		try {
			
		 	System.out.println(sb.toString());
			
			String ch = in.nextLine();
			
			c =  Integer.parseInt(ch);
		} 
		catch(Exception ex) {
			//Any invalid command will be just ignored
			c = -1;
		}
	 	return c;
	 }
	
	private void executeMenuItem(int choice) {
		switch (choice) { 
			case APP_ADD_BOOK:
				appCtrl.addBook();
				break;
				
			case APP_MOD_BOOK:
				appCtrl.changeBook();
				break;
				
			case APP_FIND_BOOK:
				appCtrl.findBook();
				break;
			
			case APP_DELETE_BOOK:			//THIS METHOD WAS ADDED
				appCtrl.deleteBook();
				break;
				
			case APP_LIST_BOOKS:
				appCtrl.listBooks();
				break;
				
			case APP_ADD_USER:;
				appCtrl.addUser();
				break;
				
			case APP_MOD_USER:
				appCtrl.changeUser();
				break;
				
			case APP_FIND_USER:
				appCtrl.findUser();
				break;
			
			case APP_DELETE_USER:			//THIS METHOD WAS ADDED
				appCtrl.deleteUser();
				break;
				
			case APP_LIST_USERS:
				appCtrl.listUsers();
				break;				
							
			case APP_ADD_LOAN:
				appCtrl.addBookLoan();
				break;
				
			case APP_MOD_LOAN:
				appCtrl.changeBookLoan();
				break;
				
			case APP_FIND_LOAN:
				appCtrl.findBookLoan();
				break;
			
			case APP_DELETE_LOAN:			//THIS METHOD WAS ADDED
				appCtrl.deleteBookLoan();
				break;
				
			case APP_LIST_LOANS:
				appCtrl.listBookLoans();
				break;
				
			case APP_EXIT:
				System.out.println("Good Bye!");
				break;
				
			default:
				System.out.println("Unknown command!");
				break;
		}
		System.out.println(); 
	}
 }

