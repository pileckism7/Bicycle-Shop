package Shop_V1;
/*
 * Exception which appears if item is not rentable
 */
public class ExceptionNonRentableItem extends Exception {
	String itemclass;
	public ExceptionNonRentableItem(String itemclass){
		System.err.println(itemclass + " Is not a rentable item.");
	}
}
