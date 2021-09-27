/** 
* File name: User.java
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
* 
*/
public class User {
	
	private static final int DEFAULT_AGE = 18;
	private static int userNextId=1000;
	
	/**
     * id is the user's id 
     */	
	private int id;
	/**
     * name is the user's name 
     * 
     */	
	private String lastName;
	
	private String firstName;
	/**
     * address is the user's address
     *
     */	
	private String address;
	
	private int age;
	
	/**
	 * constructor of User
	 * @param id id of user
	 * @param name name of user
	 * @param address address of user
	 */
	public User(int id, String lname, String fname, String address, int age) {
		setUserId(id);
		setLastName(lname);
		setFirstName(fname);
		setAddress(address);
		setAge(age);
	}
	
	/**
	 * constructor of User
	 * @param id id of user
	 * @param name name of user
	 * @param address address of user
	 */
	public User(String lname, String fname, String address, int age) {
		this(userNextId++, lname, fname, address, age);		
	}
	
	/**
	 * constructor of User
	 * @param id id of user
	 * @param name name of user
	 * @param address address of user
	 */
	public User(String lname, String fname, String address) {
		this(lname, fname, address, DEFAULT_AGE);		
	}
	
	/**
	 * get the user's id
	 * @return integer user's id
	 */
	public int getUserId() {
		return id;
	}
	/**
	 * set user's id
	 * @param id user id
	 */
	public void setUserId(int id) {
		this.id = id;
	}
	/**
	 * get the user's name
	 * @return integer user name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * set the user's name
	 * @param name user's name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * get the user's name
	 * @return integer user name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * set the user's name
	 * @param name user's name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * get the user's address
	 * @return String user's address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * set the user's address
	 * @param address user's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * get the user's age
	 * @return int age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * set the age
	 * @param age 
	 */
	public void setAge(int num) {
		age = num;
	}
	
	/**
	 *rewrite toString() method
	 *@return String with information demanded
	 */
	@Override
	public String toString() {
		return "************ User id: " + getUserId() + "\n"
			+ "************ User name: " + getLastName() + " " + getFirstName() + "\n"
			+ "************ Age: " + getAge() + "\n"
			+ "************ Address: " + getAddress() + "\n";
	}
	
	//CREATE A EQUALS() METHOD HERE
		public boolean equals (Object o) {
			if(o instanceof User && o != null){ //CHECK IF THE NEW OBJ IS instanceof User AND != null
				User obj = (User) o;
				if(lastName == (obj.getLastName()) && firstName == (obj.getFirstName()) && age == (obj.getAge())&& address == (obj.getAddress())){ 
					return true;
				}
				return true;	
			}
			return false;
	}
}
