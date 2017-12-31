package Shop_V1;

import java.util.ArrayList;

/**
 * Represents an Inventory of items that have been can be bought or rented.
 * 
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Inventory{
	/**
	 * An Inventory object contains a list of items, a list
	 * of rentals, and a history of transactions.
	 */
	public ArrayList<Item> items;
	public RentedList rentList = new RentedList("Rental");
	public History history = new History("History");
	
	/**
	 * Constructs an Inventory with a list of items.
	 */
	public Inventory(){
		items = new ArrayList<Item>();
	}
	/**
	 * Sets the list of items to a given list.
	 * @param items		List of items
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/**
	 * Returns the list of items.
	 * @return items	List of items
	 */
	public ArrayList<Item> getItems(){
		return items;
	}
	/**
	 * Adds an item to the list of items. Also adds it to the History list.
	 * @param item	The item to be added
	 */
	public void addItem(Item item){
		items.add(item);
		history.addItem(item);
	}
	/**
	 * Removes the given item from the list of items.  Also adds it
	 * to the History list.
	 * @param item	The item to be removed
	 * @return itemRemoved	The item removed
	 */
	public Item removeItem(Item item){
		Item itemRemoved = items.remove(items.indexOf(item));
		history.addItem(itemRemoved);
		return itemRemoved;
	}
	/**
	 * Returns the index number of the selected item.
	 * @param item	The item selected.
	 * @return	The position inside the item list of the selected item
	 */
	public int getIndex(Item item){
		return items.indexOf(item);
	}
	/**
	 * Removes the selected item from the inventory. Also adds it 
	 * to the History list.
	 * @param item	The item being purchased
	 */
	public void buyItem(Item item){
		Item boughtItem =items.remove(items.indexOf(item));
		history.addItem(boughtItem);
	}
	/**
	 * Get history method
	 * @return history
	 */
	public History getHistory() {
		return history;
	}
	/**
	 * Set history method
	 * @param history which is going to be set
	 */
	public void setHistory(History history) {
		this.history = history;
	}
}
	
//	public void rentedItem(Item item){
//		Item renteditem = items.remove(items.indexOf(item));
//		rentList.addItem(renteditem);
//		history.addItem(renteditem);
//	}
//	
//	public void returnRented(Item item){
//		Item returnedItem = rentList.getRentedList().remove(rentList.getRentedList().indexOf(item));
//		items.add(returnedItem);
//		history.addItem(returnedItem);
//	}
//	
//}
