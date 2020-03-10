
import java.util.*;
import java.io.*;

public class Controller {
	private static User currentUser;
	private static HashMap<String,User> userList;
	private static ArrayList<String> transactionList;
	private static HashMap<String,Event> eventList;
	
	public static void main(String[] args) {
		transactionList = new ArrayList<String>();
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		String action = "";
		//reads the account lists currently with a hard coded accoutnList.txt file
		if (args.length == 0) {
			System.out.println("Please enter the account and event list file name.");
			exit = true;
		} else {
			readAccountList(args[0]);
			readEventList(args[1]);
			System.out.println("Type login if you want to login, exit if you want to exit.");
			while (!(action = in.nextLine()).equals("exit") && exit == false) {
				action = action.toLowerCase();
				if (currentUser == null) {
					if (action.equals("exit")) {
						System.out.println("Now exiting the system");
						exit = true;
					} else if (action.equals("login")) {
						currentUser = login(in);
						if (currentUser != null) {
							printMenu();
						} else {
							System.out.println("Type login if you want to login, exit if you want to exit.");
						}
					} else {
							System.out.println("Type login if you want to login, exit if you want to exit.");
					}
				} else { 
					if (action.equals("buy"))  {
						if (!currentUser.getType().equals("SS")) {
							if (buy(in)) {
								System.out.println("Buy transaction completed");
							} else {
								System.out.println("There was an error when trying to buy");
							}
						} else {
							System.out.println("Error: Invalid account type.");
						}
					} else if (action.equals("sell"))  {
						if (!currentUser.getType().equals("BS")){
							if (sell(in)) {
								System.out.println("Sell transaction completed.");
							} else {
								System.out.println("There was an error when trying to sell.");
							}
						} else {
							System.out.println("Error: Invalid account type.");
						}
					} else if (action.equals("addCredit"))  {
						if (addCredit(in)) {
							System.out.println("You have successfully added credit");
							break;
						} else {
							System.out.println("There was an error when trying to add credit");
							break;
						}
					} else if (action.equals("refund"))  {
						if (refund(in)) {
							System.out.println("You have successfully refunded");
							break;
						} else {
							System.out.println("There was an error when trying to refund");
							break;
						}
					} else if (action.equals("create")) {
						// check Privileges of account
						if(currentUser.getType().equals("AA")){
						
						// Call create method 
							if(create(in))
							{
								System.out.println("User was created successfully.");
								 
							}else {
								System.out.println("User was not created successfully.");
							}
						}else {
							System.out.println("Error: Admin Privileges Required.");
						}
						
					} else if (action.equals("delete"))  {
						// check Privileges of account
						if(currentUser.getType().equals("AA")){
						//call delete method	
						if(delete())
						{
							System.out.println("User was deleted successfully.");
							 
						}else {
							System.out.println("No user was deleted.");
						}
						}else {
							System.out.println("Error: Admin Privileges Required.");
						}
						
						
					} else if (action.equals("logout")) {
						System.out.println("You have logged out");
						currentUser = null;
					} else if (action.equals("exit")) {
						exit = true;
					} 
					if (currentUser != null)
						printMenu();
				}
			}
			//need to write the userList and the eventLIst in a way that it overrides the current ones.
			writeAccountList(args[0]);
			writeEventList(args[1]);
			writeTransactionList();
			System.out.println("Exiting the system now");
			in.close();
		}
	}
	
	
	
	//refund
	private static boolean refund(Scanner in){
		System.out.println("You are now refunding!");
		System.out.println("Please enter buyer's username");
		Scanner nameIn = new Scanner(System.in);
		String temp = nameIn.nextLine();
		String name = leftJustify(temp, 15);
		//checks the user list if the user exists
		if (userList.containsKey(temp)) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
			return false;
		}
		System.out.println("Please enter seller's username");
		Scanner nameInSeller = new Scanner(System.in);
		String tempSeller = nameInSeller.nextLine();
		String nameSeller = leftJustify(tempSeller, 15);
		//checks the user list if the user exists
		if (userList.containsKey(tempSeller)) {
			System.out.println("valid");
		} else {
			System.out.println("invalid");
			return false;
		}
		User validatedBuyer = userList.get(temp);
		User validatedSeller = userList.get(tempSeller);

		System.out.println("Enter amount of credit to transfer");
		Double amountCreditToTransfer = in.nextDouble();

		//Adding to buyer balance
		Double buyerBalance = validatedBuyer.getBalance();
		Double newBuyerBalance = amountCreditToTransfer + buyerBalance;
		System.out.println(temp + "'s new balance is " + newBuyerBalance);
		String newBuyerBalanceString = Double.toString(newBuyerBalance);
		userList.replace(newBuyerBalanceString,validatedBuyer);

		//Subtracting seller balance
		Double sellerBalance = validatedSeller.getBalance();
		Double newSellerBalance = sellerBalance - amountCreditToTransfer;
		System.out.println(tempSeller + "'s new balance is " + newSellerBalance);
		String newSellerBalanceString = Double.toString(newSellerBalance);
		userList.replace(newSellerBalanceString,validatedSeller);
		
		return true;
	}
			
	//add credit
	private static boolean addCredit(Scanner in){
		//seeing if usernames match
		if(currentUser.getType().equals("AA")) {
			System.out.println("You are an admin!");
			System.out.println("You are now adding credit!");
			System.out.println("Enter username of account being credited");
			Scanner nameIn = new Scanner(System.in);
			String temp = nameIn.nextLine();
			String name = leftJustify(temp, 15);
			//checks the user list if the user exists
			if (userList.containsKey(temp)) {
				System.out.println("valid");
				System.out.println("Enter amount to add into account");

				User validated = userList.get(temp);
			//	Double inputtedUserBalance = validated.getBalance();

				//Adding inputted amount to the balance of the current user
				Double amountToAddIntoAccount = in.nextDouble();
				if(amountToAddIntoAccount > 1000){
					System.out.println("Cannot add over 1000 in a given session");
					return false;
				}
				Double newUserBalance = validated.getBalance();
				newUserBalance = amountToAddIntoAccount + newUserBalance;
				System.out.println(temp + "'s new balance is " + newUserBalance);

			} else {
				System.out.println("User doesn't exist");
				return false;
			}
		}
		else{
			System.out.println("You are not an admin");
			System.out.println("You are now adding credit!");
			System.out.println("Enter amount to add to your account");

			Double amountToAdd = in.nextDouble();
			if(amountToAdd > 1000){
				System.out.println("Cannot add over 1000 in a given session");
				return false;
			}
			Double newBalance = currentUser.getBalance();

			//Adding inputted amount to the balance of the current user
			newBalance = amountToAdd + newBalance;
			System.out.println("Your new balance is " + newBalance);
		}
		return true;
	}
	
	
	//basic buy
	//need to make it check if event exists
	private static boolean buy(Scanner in){
		String eventName = "";
		String sellerName = "";
		int numOfTickets = 0;
		boolean cancel = false;
		boolean stopNum = false;
		//Getting the event Name
		System.out.println("Please enter the Event name");
		while (cancel == false && (eventName = in.nextLine()).length() > 19) {
			System.out.println("You have entered an invalid event name please try again, or type cancel to cancel the transaction.");
		}	
		if (eventName.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Buy Transaction cancelled.");
		} else {
		//Getting the sellers name
			System.out.println("Please enter the Sellers name");
		}
		while (cancel == false && (sellerName = in.nextLine()).length() > 13) {
			System.out.println("You have entered an invalid seller name please try again, or type cancel to cancel the transaction");
		}
		if (sellerName.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Buy Transaction cancelled.");
		}
		//getting the number of tickets
		if (!cancel) { 
			System.out.println("Enter the number of tickets you want to purchase (max 4)");
			if (currentUser.getType().equals("AA")) {
				while (stopNum == false && (numOfTickets = in.nextInt()) != 0){
					if (numOfTickets > 0 && numOfTickets < 1000)
						stopNum = true;
					else
						System.out.println("You have entered an incorrect ticket amount please try again, or type cancel to cancel the transaction");
				}
			} else {
				while (stopNum == false && (numOfTickets = in.nextInt()) != 0){
					if (numOfTickets > 0 && numOfTickets < 4)
						stopNum = true;
					else
						System.out.println("You have entered an incorrect ticket amount please try again, or type cancel to cancel the transaction");
				}
			}
			//need to actually check all the info above with the current event doc
			String ticketValue = "111.00";
			buyAndSellTransaction("04",eventName,sellerName,String.valueOf(numOfTickets), ticketValue.replace(".", ""));
		}
		return true;
	}
	
	//basic sell
	private static boolean sell(Scanner in) {
		String eventName = "";
		String salePrice = "";
		String numOfTickets = "";
		boolean cancel = false;
		
		//Getting the event name
		System.out.println("Please enter the event name.");
		eventName = in.nextLine();
		while (cancel == false && (eventName = in.nextLine()).length() > 19) {
			System.out.println("You have entered an invalid event name please try again, or type cancel to cancel the transaction.");
		}
		if (eventName.toLowerCase().equals("cancel")){
			cancel = true;
		} else {
			System.out.println("Please enter the price per ticket.");
		}
		while (cancel == false && !in.hasNextDouble()) {
			if (salePrice.toLowerCase().equals("cancel")){
				cancel = true;
			} else {
				System.out.println("you have entered an invalid sale price please try again, or type cancel to cancel the transaction.");
				salePrice = in.nextLine();
			}
		}
		if (!cancel) {
			salePrice = in.nextLine();
			System.out.println("Please enter the amount of tickets you are selling.");
		}
		while (cancel == false && !in.hasNextInt()) {
			System.out.println("you have entered an invalid number of tickets please try again, or type cancel to cancel the transaction.");
			numOfTickets = in.nextLine();
		}
		if (salePrice.toLowerCase().equals("cancel") || cancel) {
			cancel = true;
		} else {
			numOfTickets = in.nextLine();
		}
	
		if (cancel) {
			System.out.println("Sell transaction cancelled.");
			return false;
		} else {
			buyAndSellTransaction("03", eventName, currentUser.getUsername(), numOfTickets, salePrice.replace(".", ""));
			eventList.put(eventName, new Event(eventName, currentUser.getUsername(),Integer.valueOf(numOfTickets), Double.valueOf(salePrice)));
		}
		return true;
	}
	
	//Create method 
	private static boolean create(Scanner nameIn) {
		
		System.out.println("Welcome to Create!");
		// Scanner nameIn = new Scanner(System.in);
		System.out.println("Please enter the name of the user you would like to create.");
		String newUserName = nameIn.nextLine();
		//Check length of user name 
		if(newUserName.length() > 15)
		{
			System.out.println("Error, user name must be below 15 charcters.");
			return false; 
		}
		// Check to see if user name already exists in system. 
		if ((userList.containsKey(newUserName))){
			System.out.println("Error please enter a new username. " +  newUserName + " already exisits.");
			return false;
		}
		
		System.out.println("Please enter the user type:");
		String newUserType = nameIn.nextLine();
		
		System.out.println("Please enter credit to be added:");
		int newUserCreditAmount = nameIn.nextInt();
		//checks credit limit
		if(newUserCreditAmount > 999999)
		{
			System.out.println("Credit limit exceeded.");
			return false;
		}
		userList.put(newUserName, new User(newUserName, newUserType, newUserCreditAmount));
		createAndDeleteTransaction("01",currentUser.getUsername(), currentUser.getType(), String.valueOf(currentUser.getBalance()));
		return true;	
	}
	
	private static boolean delete() {
		System.out.println("Welcome to Delete!");
		Scanner nameIn = new Scanner(System.in);
		System.out.println("Please enter the name of the user you would like to delete:");
		String newUserName = nameIn.nextLine();
		
		if ((userList.containsKey(newUserName))){
			if(newUserName.equals(currentUser.getUsername()))
			{
				System.out.println("Cannot delete current user.");
				return false;
			}
			userList.remove(newUserName);
			System.out.println(newUserName + " has been deleted.");
			createAndDeleteTransaction("02",currentUser.getUsername(), currentUser.getType(), String.valueOf(currentUser.getBalance()));
			return true;
		}	
		System.out.println(newUserName + " does not exist.");
		return false;
	}
	//XX_EEEEEEEEEEEEEEEEEEE_SSSSSSSSSSSSS_TTT_PPPPPP
	private static void buyAndSellTransaction(String type, String eventName, String sellerName, String numOfTickets, String ticketPrice) {
		transactionList.add(type + " " + leftJustify(eventName,19) + " " + leftJustify(sellerName,13) + " " + zeroRightJustify(numOfTickets, 3) + " " + zeroRightJustify(ticketPrice,6));
		System.out.println(transactionList.get(0));
	}
	
	private static void createAndDeleteTransaction(String num, String userName, String userType, String credit) {
		transactionList.add(num + " " + leftJustify(userName, 15) + " " + userType + " " + zeroRightJustify(credit, 9)); 
		System.out.println(transactionList.get(0));
	}

	private static User login(Scanner in) {
		System.out.println("Enter Username: ");
		String name = in.nextLine();
		if (userList.containsKey(name)) {
			return userList.get(name);
		} else {
			System.out.println("user " + name + " does not exist in the database.");
			return null;
		}
	}
	
	private static void readAccountList(String filename) {
		userList = new HashMap<String,User>();
		try {
			File accountFile = new File(filename);
			Scanner reader = new Scanner(accountFile);
			String temp = "";
			String[] ele;
			while (reader.hasNextLine()) {
				temp = reader.nextLine();
				ele = temp.split("\\s+");
				userList.put(ele[0], new User(ele[0], ele[1], Double.valueOf(ele[2])));
			}
			reader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred." + System.getProperty("user.dir"));
		      e.printStackTrace();
		}
	}
	
	private static void readEventList(String filename) {
		eventList = new HashMap<String,Event>();
		try {
			File eventFile = new File(filename);
			Scanner reader = new Scanner (eventFile);
			String temp = "";
			String[] ele;
			while (reader.hasNextLine()) {
				temp = reader.nextLine();
				ele = temp.split("\\s+");
				eventList.put(ele[0], new Event(ele[0], ele[1], Integer.valueOf(ele[2]), Double.valueOf(ele[3])));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			 System.out.println("An error occurred." + System.getProperty("user.dir"));
		     e.printStackTrace();
		}
	}
	
	
	private static void writeAccountList(String filename) {
		String key;
		User temp;
		try {
			FileWriter writer = new FileWriter(filename,false);
			for (Map.Entry mapElement : userList.entrySet()) { 
	            key = (String)mapElement.getKey(); 
	            temp = userList.get(key);
	            writer.write(temp.toString() + "\n"); 
	        } 
			writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred." + System.getProperty("user.dir"));
		      e.printStackTrace();
		}
	}
	
	private static void writeEventList(String filename) {
		String key;
		Event temp;
		try {
			FileWriter writer = new FileWriter(filename ,false);
			for (Map.Entry mapElement : eventList.entrySet()) { 
	            key = (String)mapElement.getKey(); 
	            temp = eventList.get(key);
	            writer.write(temp.toString() + "\n"); 
	        } 
			writer.close();
		} catch (IOException e) {
		      System.out.println("An error occurred." + System.getProperty("user.dir"));
		      e.printStackTrace();
		}
	}

	private static void writeTransactionList() {
		FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
		try {
            fw = new FileWriter("TransactionList.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            Iterator<String> i = transactionList.iterator();
            pw.println("");
            while (i.hasNext()) {
            	pw.println(i.next());
            }
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        }  catch (IOException e) {
        	 System.out.println("An error occurred." + System.getProperty("user.dir"));
		     e.printStackTrace();
        }
	}
	
	//transaction code helper methods
	private static String leftJustify(String word, int size) {
		String space = "";
		for (int i = word.length(); i < size; i++) {
			space+= " ";
		}
		return word+space;
	}
	private static String rightJustify(String word, int size) {
		String space = "";
		for (int i = word.length(); i < size; i++) {
			space+= " ";
		}
		return space+word;
	}
	private static String zeroRightJustify(String word, int size) {
		String space = "";
		for (int i = word.length(); i < size; i++) {
			space+= "0";
		}
		return space+word;
	}
	
	//printing for the account types
	private static void printMenu() {
		if (currentUser.getType().equals("AA"))
			welcomeAdmin(currentUser.getUsername());
		else if (currentUser.getType().equals("SS"))
			welcomeSell(currentUser.getUsername());
		else if (currentUser.getType().equals("BS"))
			welcomeBuy(currentUser.getUsername());
		else
			welcomeStandard(currentUser.getUsername());
	}
	
	private static void welcomeAdmin(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter create to Create!");
		System.out.println("Enter delete to Delete!");
		System.out.println("Enter sell to Sell!");
		System.out.println("Enter buy to Buy!");
		System.out.println("Enter refund to Refund!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
		System.out.println("Enter exit to exit the system!");
	}
	private static void welcomeStandard(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter sell to Sell!");
		System.out.println("Enter buy to Buy!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
		System.out.println("Enter exit to exit the system!");
	}
	private static void welcomeSell(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter sell to Sell!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
		System.out.println("Enter exit to exit the system!");
	}
	private static void welcomeBuy(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter buy to Buy!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
		System.out.println("Enter exit to exit the system!");
	}
}
