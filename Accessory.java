package Shop_V1;
/**
 * Represents an accessory that a customer can purchase.
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */

public class Accessory extends Item {
	
	private String size;
	private String brand;
	private String color;
	private String gender;
	
	/**
	 * Creates an accessory object that contains a simple description, a name,
	 * the brand, the gender of the preferred user, the color, and the cost.
	 * @param description	Simple description of the accessory
	 * @param name			Name of the accessory
	 * @param size			Size of the accessory 
	 * @param brand			Brand of the accessory
	 * @param gender		Gender of the preferred user
	 * @param color			Color of the accessory
	 * @param cost			Cost of the accessory, contains both retail and rental costs
	 */
	public Accessory(String description, String name, String size, String brand, String gender, String color, Cost cost){
		super(description, cost, name);
		this.brand = brand;
		this.size = size;
		this.gender = gender;
		this.color = color;
	}
	/**
	 * Returns the brand of the accessory object.
	 * @return brand	A string containing the brand name
	 */
	public String getBrand(){
		return brand;
	}
	/**
	 * Returns the size of the accessory object
	 * @return size		A string containing the size (S, M, L, etc)
	 */
	public String getSize(){
		return size;
	}
	/**
	 * Returns a string representation of the accessory object.
	 * @return	A string containing the accessory's description,
	 * name, size, brand, and both retail and rental costs.
	 * FORMATED
	 */
	public String listItem(){
		return "Type: "+description +
				" Brand: "+ brand +
				" Model: " + name + 
				" Size: " + size + 
				" Color: "+ color + 
				" Gender: "+gender + 
				" Purchase Price: $" 
				+ cost.getRetailCost() + " +Tax.";
	}
	/**
	 * Returns a string representation of the accessory object.
	 * @return	A string containing the accessory's description,
	 * name, size, brand, and both retail and rental costs.
	 */
	public String toString(){
		return  "Model:          "+description +
				"\nBrand:        "+ brand +
				"\nItem:         " + name + 
				"\nSize:         " + size + 
				"\nColor:        "+ color + 
				"\nGender:       "+gender + 
				"\nPurchase Price:         $" 
				+ cost.getRetailCost() + " +Tax.";  
	}
	/**
	 * Returns a string containing the gender the accessory is for
	 * @return gender	A string containing the gender of the object
	 */
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}
	/**
	 * Returns a string containing the color of the accessory
	 * @return color	A string containing the color of the object
	 */
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
}