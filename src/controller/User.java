
class User {
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
}
