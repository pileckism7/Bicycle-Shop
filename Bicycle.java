package Shop_V1;
/**
 * Represents a bicycle that a customer can purchase or rent.
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Bicycle extends Item implements Rentable {
	/**
	 * A bicycle object has a color and a preferred gender.
	 */
	private String gender;
	private String color;
	/**
	 * Creates a bicycle object that contains a simple description, the color of the bicycle, a name,
	 * and the cost.
	 * @param Gender		Gender of the preferred user
	 * @param description	A short description of the bike
	 * @param Color			The color of the bike
	 * @param name			The name of the bike
	 * @param cost			The cost of the bike, contains both the retail and rental price
	 */
	public Bicycle(String Gender, String description, String Color, String name, Cost cost){
	super(description, cost, name);
	this.color = Color;
	this.gender = Gender;
	}
	
	/**
	 * @return
	 */
	public String listItem(){
		return "Model: "+description +
				" Item: " + name +  
				" Color: "+ color + 
				" Gender: " +gender + 
				" Purchase Price: $" 
				+ cost.getRetailCost() + " +Tax.";
	}
	
	/**
	 * Returns the gender of the preferred user
	 * @return gender	A string containing the gender 
	 */
	public String getGender(){
		return gender;
	}
	
	/**
	 * Returns the color of the bike
	 * @return color	The color of the bike
	 */
	public String getColor(){
		return color;
	}
	/**
	 * Returns a string representation of the bicycle object.
	 * @return	A string containing the accessory's preferred gender, description,
	 * 			color, name, and both retail and rental costs.
	 */
	public String toString(){
		return "Model:          "+description +
				"\nItem:         " + name + 
				"\nColor:        "+ color + 
				"\nGender:       "+gender + 
				"\nPurchase Price:         $" 
				+ cost.getRetailCost() + " +Tax."; 
				
	}
	/**
	 * Since bicycle extends Item, bicycle must implement a getSize method.
	 * However since our bicycles do not have a size, the method always
	 * returns a null value.
	 * @return	null
	 */
	@Override
	public String getSize() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Since bicycle extends Item, bicycle must implement a getBrand method.
	 * However since our bicycles do not have a brand, the method always
	 * returns a null value.
	 * @return	null
	 */
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return null;
	}
}