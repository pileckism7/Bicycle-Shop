package Shop_V1;
/*
 * Exception which appears if file name doesnt exist
 * 
 */

public class IncorrectFileException extends Exception {
	String message = "Incorrect File Directory";
	public IncorrectFileException(String message){
		this.message = message;
		System.err.println(message);
	}
	
	public void showMessage(){
		System.out.println(message);
	}
}
