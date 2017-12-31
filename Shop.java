package Shop_V1;

import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a Shop object, which contains an Inventory and a CustomerList.
 * 
 * @author Jesse Buchan
 * @author Mantas Pileckis
 * @author David Smits
 * @author Jake Dominguez
 *
 */
public class Shop {
	/**
	 * A Shop contains an Inventory and a CustomerList. The rest of the instance variables
	 * are used to auto-generate customers, bicycles, and helmets.
	 */
	public String[] model = { "Popper205", "Mile202", "CasperGhost600", "Mamba235", "Turtle177", "Spooner11",
			"Digger500", "Madness150", "Otter250", "Haze420", "Fatboy200", "Snowflake17", "Ricer999", "Duster142" };
	public String[] bicycleDescription = { "MOUNTAIN", "ROADSTER", "BMX", "SPORT", "CRUISER", "FAT-TIRE", "UNIVERSAL" };
	public String[] gender = { "Female", "Male" };

	public String[] firstName = { "Laura", "Thomas", "Jen", "Cole", "Weezer", "Anthony", "Jacob", "David", "Jayson",
			"Tyler", "Phillip", "Victor", "Mantas", "Matt", "Kristina", "Kimberly", "Caroline" };
	public String[] lastName = { "Jackson", "Bapson", "Wattson", "Rackson", "Packson", "Macson", "Rockson", "Gatson",
			"Sonson", "Yahson", "Kanson", "Dankson", "Vackson", "Takson", "Catson", "Dabson" };
	public String[] cellNumber = { "7321234567", "1234568461", "4567515248", "1240875415", "0197348150", "7412589632",
			"1546751234", "01579454651", "5484505744", "4504514524", "1549796464" };

	public String[] helmetDescription = { "SPORT", "CRUISE", "LIGHTWEIGHT", "FULL-FACE" };
	public String[] helmetNames = { "Stinger", "Razor", "BellHub", "RigFang", "Revel", "BellModa", "Specialized",
			"Cycler", "Rush" };
	public String[] brand = { "Oakley", "Giro", "Burton", "Adidas", "Nike", "Billabong", "KING", "Dryworld", "Dunlop",
			"K2 Sports", "JD-Sport", "SuperDry", "O'Neill", "Puma", "RipCurl", "Salomon", "TH3", "Umbro", "Von Zipper",
			"Xtep", "Zubaz" };
	public String[] accessory = { "Back-Pack", "T-Shirt", "Hoodie", "Muscle-Shirt", "Jacket", "Shorts", "Gloves",
			"Gogles", "Water-Bottle", "Bike-Bag", "Hat", "Socks" };
	public String[] accessoryDescription = { "2017", "2018", "2016" };
	public String[] size = { Size.L.toString(), Size.M.toString(), Size.S.toString(), Size.XL.toString(),
			Size.XXL.toString() };
	public String[] color = { "Red", "Yellow", "Midnight", "White", "Purple", "Gray", "Gold", "Green", "Orange", "Pink",
			"Cherry", "Black", "Blue" };

	public Inventory inventory = new Inventory();
	public CustomerList customers = new CustomerList("Customer");
	public Random rand = new Random();

	/**
	 * Constructs a Shop object.
	 */
	public Shop() {
		populateShop();
	}
	/**
	 * Populates the Shop with accessories, bicycles, and helmets.
	 */
	public void populateShop() {
		populateShopAccessory();
		populateShopBicycle();
		populateShopHelmet();
	}
	/**
	 * Populates the Shop with helmets, using a random object
	 * to select the color, size, name, description, brand,
	 * and prices.
	 */
	public void populateShopHelmet() {
		for (int i = 0; i < 60; i++) {
			int col = rand.nextInt(color.length); // random color
			int siz = rand.nextInt(size.length); // random size
			int hlm = rand.nextInt(helmetNames.length); // random helmet name
			int hld = rand.nextInt(helmetDescription.length); // random helmet
																// description
			int brn = rand.nextInt(brand.length); // random accessory brand
			int accretail = rand.nextInt((89 - 30) + 1) + 30; // random price
																// for
																// accessories
			int helmetRental = rand.nextInt((25 - 10) + 1) + 10; // random
																	// helmet
																	// rental
																	// price
			inventory.addItem(new Helmet(helmetDescription[hld], helmetNames[hlm], size[siz], color[col], brand[brn],
					"Gender-Neutral", new Cost(accretail, helmetRental)));
		}
	}
	/**
	 * Populates the Shop with bicycles, using a random object
	 * to select the description, model, color, user gender, and prices.
	 */
	public void populateShopBicycle() {
		for (int i = 0; i < 60; i++) {
			int des = rand.nextInt(bicycleDescription.length); // random
																// description
			int mod = rand.nextInt(model.length); // random model
			int col = rand.nextInt(color.length); // random color
			int gen = rand.nextInt(gender.length); // random gender
			int rental = rand.nextInt((60 - 30) + 1) + 30; // random rental
															// price 30-99
			int retail = rand.nextInt((600- 200) + 1) + 200; // random retail
																// price 500-999
			inventory.addItem(new Bicycle(gender[gen], bicycleDescription[des], color[col], model[mod],
					new Cost(retail, rental)));
		}
	}
	/**
	 * Populates the Shop with accessories, using a random object
	 * to select the color, user gender, size, name, brand,
	 * and prices.
	 */
	public void populateShopAccessory() {
		for (int i = 0; i < 60; i++) {
			int col = rand.nextInt(color.length); // random color
			int gen = rand.nextInt(gender.length); // random gender
			int siz = rand.nextInt(size.length); // random size
			int brn = rand.nextInt(brand.length); // random accessory brand
			int acc = rand.nextInt(accessory.length); // random accessory
			int acd = rand.nextInt(accessoryDescription.length);//
			int accretail = rand.nextInt((60 - 30) + 1) + 30; // random price
																// for
																// accessories
			inventory.addItem(new Accessory(accessoryDescription[acd], accessory[acc], size[siz], brand[brn],
					gender[gen], color[col], new Cost(accretail, 0)));
		}
	}
	/**
	 * Returns a list of the Shop's items.
	 * @return	A list of the Shop's items
	 */
	public ArrayList<Item> getItem() {
		return inventory.getItems();
	}
	/**
	 * Returns the inventory of the shop.
	 * @return inventory	The object holding the entire inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}
}