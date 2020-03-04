package controller;

import java.util.*;
import java.io.*;

public class Controller {
	private static User currentUser;
	private static ArrayList<String> userList;
	private static ArrayList<String> transactionList;
	private static ArrayList<String> eventList;	
	
	public static void main(String[] args) {
		transactionList = new ArrayList<String>();
		eventList = new ArrayList<String>();
		//reads the account lists currently with a hard coded accoutnList.txt file
		readAccountList();
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		String action = "";
		System.out.println("Type login if you want to login, exit if you want to exit.");
		//action = in.nextLine();
		while (!(action = in.nextLine()).equals("exit") && exit == false) {
			action = action.toLowerCase();
			if (currentUser == null) {
				if (action.equals("exit")) {
					System.out.println("Now exiting the system");
					exit = true;
				} else if (action.equals("login")) {
					currentUser = login();
				} else {
					System.out.println("Type login if you want to login, exit if you want to exit.");
				}
			} else { 
				if (action.equals("buy"))  {
					if (buy(in)) {
						System.out.println("Buy transaction completed");
					} else {
						System.out.println("There was an error when trying to buy");
					}
				} else if (action.equals("sell"))  {
					System.out.println("Sell");
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
					System.out.println("Create");
				} else if (action.equals("delete"))  {
					System.out.println("Delete");
				} else if (action.equals("logout")) {
					System.out.println("You have logged out");
					currentUser = null;
				} else if (action.equals("exit")) {
					exit = true;
				} else {
					printMenu();
				}
			}
		}
		System.out.println("Exiting the system now");
		in.close();
	}
	
	
	
	//refund
	private static boolean refund(Scanner in){
		boolean found = false;
		System.out.println("You are now refunding!");
		System.out.println("Please enter buyer's username");

		Scanner nameIn = new Scanner(System.in);
		String temp = nameIn.nextLine();
		String name = leftJustify(temp, 15);
		//checks the user list if the user exists
		Iterator<String> i = userList.iterator();
		temp = "";
		boolean found2 = false;
		while (i.hasNext() && found2 == false) {
			temp = (String) i.next();
			if (temp.contains(name)) {
				System.out.println("The user exists in the system");
				found2 = true;
			}
		}
		if (found2) {
			String[] ele = temp.split("\\s+");
			if (ele[0].equals(name))
				System.out.println("THIS IS THE CORRECT USER");
			//return new User(ele[0],ele[1], Double.valueOf(ele[2]));
		} else {
			System.out.println("Sorry User Not Found");
			//return null;
		}



		System.out.println("Please enter seller's username");
		Scanner nameInSeller = new Scanner(System.in);
		String tempSeller = nameInSeller.nextLine();
		String nameSeller = leftJustify(tempSeller, 15);
		//checks the user list if the user exists
		Iterator<String> iSeller = userList.iterator();
		tempSeller = "";
		boolean foundSeller = false;
		while (iSeller.hasNext() && foundSeller == false) {
			tempSeller = (String) iSeller.next();
			if (tempSeller.contains(nameSeller)) {
				System.out.println("The user exists in the system");
				foundSeller = true;
			}
		}
		if (foundSeller) {
			String[] eleSeller = tempSeller.split("\\s+");
			if (eleSeller[0].equals(nameSeller))
				System.out.println("THIS IS THE CORRECT USER");
			//return new User(ele[0],ele[1], Double.valueOf(ele[2]));
		} else {
			System.out.println("Sorry User Not Found");
			//return null;
		}

		/* Creating new arrays to hold the split value (credit) and convert from string to double
		in order to do math with it
		 */
		String[] arraySell = tempSeller.split("\\s+");
		double test = Double.parseDouble(arraySell[2]);
		String[] arrayBuy = temp.split("\\s+");
		double test2 = Double.parseDouble(arrayBuy[2]);
		//Transferring the credits
		System.out.println("Please enter amount of credit to transfer");
		double transferCredit = in.nextDouble();
		double newCreditSeller = test - transferCredit;
		double newCreditBuyer = transferCredit + test2;
		//printing 
		System.out.println(newCreditSeller + " is the new total amount for the seller");
		System.out.println(newCreditBuyer + " is the new total amount for the buyer");
		return true;
	}
			
	//add credit
	private static boolean addCredit(Scanner in){
		//seeing if usernames match
		System.out.println("You are now adding credit!");
		System.out.println("Enter username of account being credited");

		Scanner nameIn = new Scanner(System.in);
		String temp = nameIn.nextLine();
		String name = leftJustify(temp, 15);
		//checks the user list if the user exists
		Iterator<String> i = userList.iterator();
		temp = "";
		boolean found2 = false;
		while (i.hasNext() && found2 == false) {
			temp = (String) i.next();
			if (temp.contains(name)) {
				System.out.println("The user exists in the system");
				found2 = true;
			}
		}
		if (found2) {
			String[] ele = temp.split("\\s+");
			if (ele[0].equals(name))
				System.out.println("THIS IS THE CORRECT USER");
			//return new User(ele[0],ele[1], Double.valueOf(ele[2]));
		} else {
			System.out.println("Sorry User Not Found");
			//return null;
		}

		String[] arrayNew = temp.split("\\s+");

		System.out.println("Enter amount of credit you would like to add");
		double creditAdd = in.nextDouble();
		if(creditAdd > 1000){
			System.out.println("Cannot process more than 1000");
			return false;
		}
		else{
			//Add code to add the credit
		}

/*what it should look like i think
	if(arrayNew[1] == "AA")
	ask for username
	make sure username matches
	ask for amount of credit to add
	add the credit
	else
	ask for amount of credit to add
	add the credit
 */
		//****in standard mode****
		if(arrayNew[1] == "AA")
		System.out.println(creditAdd + " has been added to account " + arrayNew[0]);
		System.out.println(arrayNew[1]);
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

		System.out.println("Please enter the Event name");
		while (cancel == false && (eventName = in.nextLine()).length() > 19) {
			if (eventName.toLowerCase().equals("cancel")) {
				cancel = true;
				System.out.println("Buy Transaction cancelled.");
			} else {
				System.out.println("You have entered an invalid event name please try again, or type cancel to cancel the transaction.");
			}
		}	
		if (eventName.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Buy Transaction cancelled.");
		}
		System.out.println("Please enter the Sellers name");
		while (cancel == false && (sellerName = in.nextLine()).length() > 13) {
			if (sellerName.toLowerCase().equals("cancel")){
				cancel = true;
				System.out.println("Buy Transaction cancelled.");
			} else {
				System.out.println("You have entered an invalid seller name please try again, or type cancel to cancel the transaction");
			}
		}
		if (sellerName.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Buy Transaction cancelled.");
		}
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
		double salePriceDouble = 0;
		boolean cancel = false;
		boolean numeric = true;
		
		System.out.println("Please enter the event name.");
		while (cancel == false && (eventName = in.nextLine()).length() > 19) {
			if (eventName.toLowerCase().equals("cancel")) {
				cancel = true;
				System.out.println("Sell transaction cancelled.");
			} else {
				System.out.println("You have entered an invalid event name please try again, or type cancel to cancel the transaction.");
			}
		}	
		if (eventName.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Sell transaction cancelled.");
		} else { 
			System.out.println("You have entered an invalid sale price please try again, or type cancel to cancel the transaction.");
		}
		
		System.out.println("Please enter the price per ticket.");
		while (cancel == false && (salePrice = in.nextLine()).length() > 6) {
			if (salePrice.toLowerCase().equals("cancel")) {
				cancel = true;
				System.out.println("Sell Transaction canclled");
			} else {
				//check if it is double
			}
		}
		if (salePrice.toLowerCase().equals("cancel")){
			cancel = true;
			System.out.println("Sell transaction cancelled.");
		} else { 
			System.out.println("You have entered an invalid sale price please try again, or type cancel to cancel the transaction.");
		}
		
		System.out.println("Please enter the amount of tickets you are selling.");
		
		buyAndSellTransaction("03", eventName, currentUser.getUsername(), String.valueOf(numOfTickets), String.valueOf(salePrice).replace(".", ""));
	}
	
	//XX_EEEEEEEEEEEEEEEEEEE_SSSSSSSSSSSSS_TTT_PPPPPP
	private static void buyAndSellTransaction(String type, String eventName, String sellerName, String numOfTickets, String ticketPrice) {
		transactionList.add(type + " " + leftJustify(eventName,19) + " " + leftJustify(sellerName,13) + " " + zeroRightJustify(numOfTickets, 3) + " " + zeroRightJustify(ticketPrice,6));
	}
	
	private static User login() {
		Scanner nameIn = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String temp = nameIn.nextLine();
		String name = leftJustify(temp, 15);
		//checks the user list if the user exists
		Iterator<String> i = userList.iterator();
		temp = "";
		boolean found = false;
		while (i.hasNext() && found == false) {
			temp = (String) i.next();
			if (temp.contains(name)) {
				found = true;
			}
		}
		if (found) {
			String[] ele = temp.split("\\s+");
			if (ele[1].equals("AA"))
				welcomeAdmin(name);
			else if (ele[1].equals("SS"))
				welcomeSell(name);
			else if (ele[1].equals("BS"))
				welcomeBuy(name);
			else
				welcomeStandard(name);
			return new User(ele[0],ele[1], Double.valueOf(ele[2]));
		} else {
			System.out.println("Sorry User Not Found");
			return null;
		}
	}
	private static void readAccountList() {
		userList = new ArrayList<String>();
		try {
			File accountFile = new File("AccountList.txt");
			Scanner reader = new Scanner(accountFile);
			while (reader.hasNextLine()) 
				userList.add(reader.nextLine());
			reader.close();
		} catch (FileNotFoundException e) {
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
