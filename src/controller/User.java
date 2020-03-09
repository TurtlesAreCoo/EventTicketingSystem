

public class User {
	private String username;
	private String accountType;
	private double balance;
	
	public User(String name, String type, double bal) {
		username = name;
		accountType = type;
		balance = bal;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getType() {
		return accountType;
	}
	
	public double getBalance() {
		return balance;
	}
	public String toString() {
		return leftJustify(username,15) + " " + accountType + " " + zeroRightJustify(String.valueOf(balance).replace(".", ""),9);
	}
	
	//transaction code helper methods
	private static String leftJustify(String word, int size) {
		String space = "";
		for (int i = word.length(); i < size; i++) {
			space+= " ";
		}
		return word+space;
	}
	private static String zeroRightJustify(String word, int size) {
		String space = "";
		for (int i = word.length(); i < size; i++) {
			space+= "0";
		}
		return space+word;
	}
}
