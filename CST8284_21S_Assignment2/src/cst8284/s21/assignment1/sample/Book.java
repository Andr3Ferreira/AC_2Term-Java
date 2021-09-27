/** 
* File name: Book.java
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
* This class include constructor, general methods, including getters,setters, toString(),equals().
* @version 1.0
* @author 
*/


public class Book{

	private static final int ISBN_LENGTH = 10;
	
	/**
     * id is the book's id
     * @see #Book(int, String, String, String)
     */
	private String isbnNumber;
	/**
     * title is the book's title
     * @see #Book(int, String, String, String)
     */
	private String title;
	/**
     * author is the book's author
     * @see #Book(int, String, String, String)
     */
	private String author;

	private String pubDate;
	
	/**
	 * constructor of Book
	 * @param id id of book
	 * @param title title of book
	 * @param author author of book
	 * @param d publication date
	 */
	public Book(String isbnNumber, String title, String author, String pubDate) {
		setBookId(isbnNumber);
		setTitle(title);
		setAuthor(author);
		setPubDate(pubDate);
	}
	
	/**
	 * get the book author 
	 * @return String book author
	 */
	public String getBookId() {
		return isbnNumber;
	}
	/**
	 * set the book id
	 * @param id book id
	 */
	public void setBookId(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	/**
	 * get the book author
	 * @return String book author
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * set the book title
	 * @param title book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * get the book author
	 * @return String book author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * set the book author
	 * @param author book author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * get the book author
	 * @return String book author
	 */
	public String getPubDate() {
		return pubDate;
	}
	/**
	 * set the book id
	 * @param id book id
	 * @throws ParseException 
	 */
	public void setPubDate(String pubDate)  {
		this.pubDate = pubDate;
	}
	/**
	 * 
	 * @param s : input isbn number to check
	 * @return : true if 10 digits only in the string, 
	 * 			 false otherwise
	 * 
	 */
	public static boolean verifyISBNNumber(String s) {
		int num=0;
		for (int i=0; i < s.length(); i++) {
			 if (Character.isDigit(s.charAt(i))) {
				 num++;
			 }
		}
		return num == ISBN_LENGTH;
	}
	
	/**
	 *rewrite toString() method
	 *@return String with book information 
	 */
	@Override
	public String toString() {
		return	"************ Title: " + getTitle() + "\n"
				+ "************ Author: "  + getAuthor() + "\n"
				+ "************ Publication Year: " + getPubDate() +"\n"
				+ "************ ISBN: " + getBookId();
	}
	
	//CREATE A EQUALS() METHOD HERE
		public boolean equals (Object o) {
			if(o instanceof Book && o != null){ //CHECK IF THE NEW OBJ IS instanceof Book AND != null
			Book obj = (Book) o;
			if(title == (obj.getTitle()) && author == (obj.getAuthor()) && isbnNumber == (obj.getBookId())&& pubDate == (obj.getPubDate())){ //CHECK IF THE book, User, AND dueDate ARE THE SAME
					return true;
				}
				return true;	
			}
			return false;
	}
}
