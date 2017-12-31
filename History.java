package Shop_V1;

import java.util.ArrayList;

/**
 * Represents a history of items that have been bought, rented, or added to the shop's inventory.
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class History {
	/**
	 * A History object contains the name of the list and
	 * the list of Items that have been bough, rented,
	 * or added to the shop's inventory.
	 */
	public String List;
	public ArrayList<Item> history = new ArrayList<Item>();
	
	/**
	 * Constructs a History object with the given name.
	 * @param history	The name of the History object
	 */
	public History(String history){
		this.List  = history;

	}
	/**
	 * Adds an item to the list.
	 * @param item	The Item to be added to the list
	 */
	public void addItem(Item item) {
		history.add(item);
	}
	/**
	 * Returns the list.
	 * @return history	The list of Items
	 */
	public ArrayList<Item> getHistory(){
		return history;

	}
}