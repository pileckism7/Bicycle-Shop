package Shop_V1;

	import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Management {
	
	
	public static ArrayList<Item> newItems = new ArrayList<Item>();
	
	
	public static ArrayList<Item> getNewItems(String filePath) throws IncorrectFileException{
		String line = "";
		String cvsSplitBy = ",";
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(filePath));
			
		} catch (FileNotFoundException e) {
			throw new IncorrectFileException("Invalid file path");
		}
		
		try {
			while((line = br.readLine()) != null){
				String[] theLine = line.split(cvsSplitBy);
				System.out.println(theLine[0]);
				if(theLine[0].equals("Bicycle")){
					String[] everything = line.split(cvsSplitBy);
					Cost theCost = new Cost(Integer.parseInt(everything[5]), Integer.parseInt(everything[6]));
					newItems.add(new Bicycle(everything[1], everything[2], everything[3], 
											everything[4],  theCost));
						
				}else if(theLine[0].equals("Accessory")){
					String[] everything = line.split(cvsSplitBy);
					Cost theCost = new Cost(Integer.parseInt(everything[7]), Integer.parseInt(everything[8]));
					newItems.add(new Accessory(everything[1], everything[2], everything[3], 
											everything[4], everything[5], everything[6], theCost));
					
				}else if(theLine[0].equals("Helmet")){
					String[] everything = line.split(cvsSplitBy);
					Cost theCost = new Cost(Integer.parseInt(everything[7]), Integer.parseInt(everything[8]));
					newItems.add(new Helmet(everything[1], everything[2], everything[3], 
											everything[4], everything[5], everything[6], theCost));
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return newItems;
		
	}
}
