package controller;

import java.util.*;
import java.io.*;

public class Controller {
	private static User currentUser;
	private static ArrayList<String> userList;
	
	public static void main(String[] args) {
		//reads the account lists currently with a hardcoded accoutnList.txt file
		readAccountList();
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		String action = "";
		System.out.println("Type login if you want to login, logout if you want to exit.");
		
		while (!exit) {
			action = in.nextLine();
			action = action.toLowerCase();
			if (action.equals("logout")) {
				exit = true;
			} else if (action.equals("login")) {
				currentUser = login();
			} else if (action.equals("buy"))  {
				if (buy()) {
					System.out.println("You have sucessfully purchased");
				} else {
					System.out.println("There was an error when trying to buy");
				}
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
			}
		}
		System.out.println("Exiting the system now");
		in.close();
	}
	
	private static boolean buy() {
		System.out.println("hello buy man");
		return true;
	}
	private static User login() {
		Scanner nameIn = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String name = make15Long(nameIn.nextLine());
		nameIn.close();
		//checks the user list if the user exists
		Iterator<String> i = userList.iterator();
		String temp = "";
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
			welcomeAdmin(name.trim());
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
	private static String make15Long(String word) {
		String space = "";
		for (int i = word.length(); i < 15; i++) {
			space+=" ";
		}
		return word+space;
	}
	//printing for the account types
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
	}
	private static void welcomeStandard(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter sell to Sell!");
		System.out.println("Enter buy to Buy!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
	}
	private static void welcomeSell(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter sell to Sell!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
	}
	private static void welcomeBuy(String name) {
		System.out.println("============================");
		System.out.println("Hello " + name + "!");
		System.out.println("============================");
		System.out.println("Enter buy to Buy!");
		System.out.println("Enter addCredit to Add Credit!");
		System.out.println("Enter logout to Logout!");
	}
	
}
