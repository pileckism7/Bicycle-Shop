package Shop_V1;

/**
 * Represents a Cost object that retains information about an item's cost,
 * specifically the retail and rental prices.
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Cost {
	/**
	 * A Cost object holds information about the retail and rental costs.
	 */
	int retailCost;
	int rentalCost;
	

	/**
	 * Constructs a Cost object that contains a rental price and a retail price.
	 * @param retail	The retail price
	 * @param rent		The rental price
	 */
	public Cost(int retail, int rent){
		retailCost = retail;
		rentalCost = rent;
	}
	
	/**
	 * Returns the retail cost.
	 * @return retailCost	The price of the retail cost
	 */
	public int getRetailCost() {
		return retailCost;
	}
	/**
	 * Sets the retail cost
	 * @param retailCost	The new price of the rental cost
	 */
	public void setRetailCost(int retailCost) {
		this.retailCost = retailCost;
	}
	/**
	 * Returns the retail cost.
	 * @return rentalCost	The price of the rental cost
	 */
	public int getRentalCost() {
		return rentalCost;
	}
	/**
	 * Sets the retail cost
	 * @param rentalCost	The new price of the rental cost
	 */
	public void setRentalCost(int rentalCost) {
		this.rentalCost = rentalCost;
	}
	/**
	 * Returns the retail and rental prices. If there is no rental cost then
	 * returns just the retail cost.
	 * @return	The prices of the rental cost and the retail cost
	 * @return	The price of the retail cost
	 */
	public String getPricing(){
		if(rentalCost != 0) {
			return retailCost + " " + rentalCost;
		}
		else {
			return retailCost + "";
		}
	}
}