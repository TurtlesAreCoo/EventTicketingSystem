
import java.util.*;
import java.io.*;

/* The component of the assignment that handels all the reading and writing of files
* @author Kingsley Lam - 500825557
* @author Carlson Dultra - 500812352 
* @author Humza Imran - 500522148
*/

public class BackEnd {
	private String accountFile;
	private String eventFile;
	/* Constructor for the backend files
	* @param acc A String that contains the name of the account list file
	* @param event A String that contains the name of the event list file
	*/
	public BackEnd(String acc, String event) {
		accountFile = acc;
		eventFile = event;
	}

	/* Reads the pre existing account list file and inputs it into a hashmap
	* @param filename A String that contians the name of the account list file
	* @return returns a hashmap that contains all the users mapped out to the username
	*/
	public static HashMap<String,User> readAccountList(String filename) {
		HashMap<String,User> userList = new HashMap<String,User>();
		try {
			File accountFile = new File(filename);
			Scanner reader = new Scanner(accountFile);
			String temp = "";
			String[] ele;
			while (reader.hasNextLine()) {
				temp = reader.nextLine();
				ele = temp.split("\\s+");
				userList.put(ele[0], new User(ele[0], ele[1], Double.valueOf(ele[2])/100));
			}
			reader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred." + System.getProperty("user.dir"));
		      e.printStackTrace();
		}
		return userList;
	}

	/* Reads the pre existing event list file and inputs it into a hashmap
	* @param filename A String that contains the name of the event list file
	* @return returns a hashmap that contains all the events mapped out to the event name
	*/
	public static HashMap<String,Event> readEventList(String filename) {
		HashMap<String,Event> eventList = new HashMap<String,Event>();
		try {
			File eventFile = new File(filename);
			Scanner reader = new Scanner (eventFile);
			String temp = "";
			String[] ele;
			while (reader.hasNextLine()) {
				temp = reader.nextLine();
				ele = temp.split("\\s+");
				eventList.put(ele[0], new Event(ele[0], ele[1], Integer.valueOf(ele[2]), Double.valueOf(ele[3])/100));
			}
			reader.close();
		} catch (FileNotFoundException e) {
			 System.out.println("An error occurred." + System.getProperty("user.dir"));
		     e.printStackTrace();
		}
		return eventList;
	}
	
	/* Writes the updated account list to the accountlist file
	* @param filename the name of the account list file
	* @param userList the current users list
	*/
	public static void writeAccountList(String filename, HashMap<String, User> userList) {
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
	
	/* Writes the updated event list to the event list file
	* @param filename the name of the event list file
	* @param eventList the current event list
	*/
	public static void writeEventList(String filename, HashMap<String, Event> eventList) {
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

	/* Writes out the transaction list of that session
	* @param transactionList the list the contains all the transaction codes for that session
	*/
	public static void writeTransactionList(ArrayList<String> transactionList) {
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
}