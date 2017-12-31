package Shop_V1;

/**
 * Represents a Customer object that retains information about a specific
 * customer, such as the first and last name as well as their cell phone number.
 * 
 * @author Jesse Buchan
 * @author Mantis Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Customer {
	/**
	 * A Customer object holds information such as the first name, last name,
	 * and cell phone number of a specific customer.
	 */
	private String firstName;
	private String lastName;
	private String cellNumber;

	/**
	 * Constructs a Customer that contains their first name, last name, and cell
	 * phone number.
	 * 
	 * @param firstName
	 *            The first name of the customer
	 * @param lastName
	 *            The last name of the customer
	 * @param cellNumber
	 *            The cell phone number of the customer
	 */
	public Customer(String firstName, String lastName, String cellNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellNumber = cellNumber;
	}

	/**
	 * Returns a string containing the Customer's first name.
	 * 
	 * @return firstName The Customer's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer.
	 * 
	 * @param firstName
	 *            The first name of the customer
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns a string containing the Customer's last name.
	 * 
	 * @return lastName The Customer's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name of the customer.
	 * 
	 * @param lastName
	 *            The last name of the customer
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns a string containing the Customer's cell phone number.
	 * 
	 * @return firstName The Customer's cell phone number
	 */
	public String getCellNumber() {
		return cellNumber;
	}

	/**
	 * Sets the cell phone number of the customer.
	 * 
	 * @param cellNumber
	 *            The cell phone number of the customer
	 */
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	/**
	 * Returns a string representation of the Customer object.
	 * 
	 * @return A string containing the customer's first and last name as well as
	 *         their cell phone number.
	 */
	public String toString() {
		return firstName + " " + lastName + " " + cellNumber;
	}
}