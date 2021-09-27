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


/** 
* This class include constructor, general methods, including getters,setters, toString().
* @version 1.0
* @author 
*/
public class BookLoan {
	/**

     * book which is loaned 
     * @see #BookLoan(User, Book, String)
     */	
	private Book book;
	/**
     * User who loaned books
     * @see #BookLoan(User, Book, String)
     */	
	private User User;
	/**
     * the date the book should be returned before 
     * @see #BookLoan(User, Book, String)
     */	
	private String dueDate;
	
	/**
	 * constructor of BookLoan
 	 *@param User User who loaned books
 	 *@param book book which is loaned by User
 	 *@param date date in which the book is loaned
 	 */
	public BookLoan(User User, Book book,  String dueDate) {
		setBook(book);
		setUser(User);
		setDueDate(dueDate);
	}
	/**
	 * get the book
	 * @return Book book is loaned
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * set the book
	 * @param book book is loaned
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * get the User
	 * @return User who loaned the book
	 */
	public User getUser() {
		return User;
	}
	/**
	 * set the User
	 * @param User User who loaned the book
	 */
	public void setUser(User User) {
		this.User = User;
	}
	/**
	 * get the due day
	 * @return the date before which the book should be returned
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * set the due day
	 * @param date date is the day in which User loaned the book
	 */
	public void setDueDate(String dueDate)  {
		
			this.dueDate = dueDate; ;
	
	}
	
	/**
	 *rewrite toString() method
	 *@return String with information demanded
	 */
	@Override
	public String toString() {
		return 	
				"************ User name:" + getUser().getFirstName() 
				+ " " + getUser().getLastName() + "\n"
				+ "************ Title: " + getBook().getTitle() + "\n"
				+ "************ Author: "  + getBook().getAuthor() + "\n"
				+ "************ ISBN: " + getBook().getBookId() + "\n"
				+ "************ Due date: " + getDueDate() ;

	}
	
	
	//CREATE A EQUALS() METHOD HERE
	public boolean equals (Object o) {
		if(o instanceof BookLoan && o != null){ //CHECK IF THE NEW OBJ IS instanceof BookLoan AND != null
			BookLoan obj = (BookLoan) o;
			if(book == (obj.getBook()) && User == (obj.getUser()) && dueDate == (obj.getDueDate())){ //CHECK IF THE book, User, AND dueDate ARE THE SAME
					return true;
				}
				return true;	
			}
			return false;
	}
}
