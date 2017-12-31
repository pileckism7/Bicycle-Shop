package Shop_V1;
/**
 * Represents a Helmet object, which is both purchasable and rentable,
 * that holds the information about it's size, brand, color, and user gender.
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Helmet extends Item implements Rentable{
	private String size;
	private String brand;
	private String color;
	private String gender;

	/**
	 * Constructs a helmet that contains a description of the helmet,
	 * the name, size, brand, color, user gender, and the cost.
	 * @param description	Short description of the helmet
	 * @param name			Name of the helmet
	 * @param size			Size of the helmet
	 * @param color			Color of the helmet
	 * @param brand			Brand of the helmet
	 * @param gender		Gender of the preferred user
	 * @param cost			Cost of the helmet, including rental and retail prices
	 */
	public Helmet(String description, String name, String size, String color, String brand, String gender, Cost cost){
		super(description, cost, name);
		this.size = size;
		this.color = color;
		this.brand =brand;
		this.gender = gender;
	}
	/**
	 * Returns the size of the helmet.
	 * @return size		The size of the helmet
	 */
	public String getSize(){
		return size;
	}
	/**
	 * Returns a String representation of the helmet.
	 * @return A string containing the description of the helmet, the name,
	 * 			it's size, and both the rental and retail costs.
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
	 * Returns a String representation of the helmet.
	 * @return A string containing the description of the helmet, the name,
	 * 			it's size, and both the rental and retail costs.
	 * FORMATED
	 */
	public String toString(){
		return "Model:          "+description +
				"\nBrand:        "+ brand +
				"\nModel:         " + name + 
				"\nSize:         " + size + 
				"\nColor:        "+ color + 
				"\nGender:       "+gender + 
				"\nPurchase Price:         $" 
				+ cost.getRetailCost() + " +Tax."; 
	}


	/**
	 * Returns the preferred user gender.
	 * @return gender	The gender of the preferred user
	 */
	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}
	/**
	 * Returns the color of the helmet.
	 * @return color	The color of the helmet
	 */
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	/**
	 * Returns the brand of the helmet.
	 * @return brand	The brand of the helmet.
	 */
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return brand;
	}
}