package Shop_V1;

import java.util.ArrayList;

/**
 * Represents a CustomerList that retains a list of customers and the name of
 * the list itself.
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class CustomerList {
	/**
	 * A CustomerList contains a list of costumers and the name of the list.
	 */
	public ArrayList<Customer> customerList = new ArrayList<Customer>();
	public String List;

	/**
	 * Constructs a CustomerList with the following name.
	 * 
	 * @param List
	 *            The name of the list
	 */
	public CustomerList(String List) {
		this.List = List;
	}

	/**
	 * Adds a customer to the list.
	 * 
	 * @param customer
	 *            The customer to be added into the list
	 */
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	/**
	 * Removes a customer from the list.
	 * 
	 * @param index
	 *            The index number of the customer to be removed
	 */
	public void removeCustomer(int index) {
		customerList.remove(index);
	}

	/**
	 * Returns the list of customers.
	 * 
	 * @return customerList The list of customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customerList;
	}
}