package Shop_V1;
import java.util.Random;

/**
 * Represents an Item object that contains the name of the item,
 * its cost, a short description, and a barcode.
 * 
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public abstract class Item {
	/**
	 * An Item object includes its name, cost, description
	 * and a barcode.  The other instance variables below
	 * are used to calculate the Item's barcode. 
	 */
	protected String name;
	protected Cost cost;
	protected String description;
	protected static int randomBarcodeMax = 999999999;
	protected static int randomBarcodeMin = 800000000;
	protected Integer barcode;
	protected Random rand = new Random();

	/**
	 * Constructs an Item with a short description, it's cost,
	 * and it's name.
	 * @param description	Description of the item
	 * @param cost			Cost of the item
	 * @param name			Name of the item
	 */
	public Item(String description, Cost cost, String name){
		this.description = description;
		this.cost = cost;
		this.name =name;
		this.barcode = rand.nextInt((randomBarcodeMax - randomBarcodeMin)+1)+randomBarcodeMin;

	}
	/**
	 * Returns a description of the item.
	 * @return description	Description of the item
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Sets the item's description.
	 * @param description	Description of the item
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Returns the cost of the item.
	 * @return cost			The cost of the item
	 */
	public Cost getCost() {
		return cost;
	}
	/**
	 * Sets the item's cost.
	 * @param cost		The cost of the item
	 */
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	/**
	 * Returns the name of the item.
	 * @return name		The name of the item
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the item.
	 * @param name		The name of the item.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the barcode of the item.
	 * @return barcode	The barcode of the item
	 */
	public int getBarcode(){
		return barcode;
	}
	public abstract String listItem();
	/**
	 * Returns the size of the item. Must be overridden. 
	 * @return The size of the item
	 */
	public abstract String getSize();
	/**
	 * Returns the gender of the preferred user. Must be 
	 * overridden.
	 * @return The gender of the preferred user
	 */
	public abstract String getGender();
	/**
	 * Returns the color of the object. Must be overridden.
	 * @return The color of the object
	 */
	public abstract String getColor();
	/**
	 * Returns the brand of the object. Must be overridden.
	 * @return The brand of the object
	 */
	public abstract String getBrand();
	
}