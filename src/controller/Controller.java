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
						System.out.println("You have sucessfully purchased");
					} else {
						System.out.println("There was an error when trying to buy");
					}
					printMenu();
				} else if (action.equals("sell"))  {
					System.out.println("Sell");
				} else if (action.equals("addCredit"))  {
					System.out.println("Add credit");
				} else if (action.equals("refund"))  {
					System.out.println("Refund");
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
					System.out.println("Sorry that was an invalid input, please try again!");
					printMenu();
				}
			}
		}
		System.out.println("Exiting the system now");
		in.close();
	}
	
	//basic buy
	//need to make it check if event exists
	private static boolean buy(Scanner in){
		
		System.out.println("hello buy man");
		System.out.println("Please enter the Event name");
		String eventName = in.nextLine();
		System.out.println("Please enter the Sellers name");
		String sellerName = in.nextLine();
		System.out.println("Enter the number of tickets you want to purchase (max 4)");
		int numOfTickets = in.nextInt();
		//need to actually check all the info above with the current event doc
		String ticketValue = "111.00";
		buyAndSellTransaction("04",eventName,sellerName,String.valueOf(numOfTickets), ticketValue.replace(".", ""));
		
		return true;
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
				System.out.println("got the ting");
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
