package Shop_V1;


import java.util.ArrayList;
import java.util.HashMap;

public class RentedList {
	public ArrayList<Item> itemsRented = new ArrayList<Item>();
	public HashMap<Customer, ArrayList<Item>> rentedList = new HashMap<Customer, ArrayList<Item>>();
	public String List;
	
	public RentedList(String Rental){
	this.List = Rental;
	}
	
	public void addToList(Customer customer, ArrayList<Item> item) {
		rentedList.put(customer, item);
	}
	
	public ArrayList<Item> getCustomer(Customer customer){
		return rentedList.get(customer);
	}
	
	public HashMap<Customer, ArrayList<Item>> getRentedList(){
		return rentedList;
	}
}