
import java.util.*;
import java.io.*;

public class BackEnd {
	private String accountFile;
	private String eventFile;
	
	public BackEnd(String acc, String event) {
		accountFile = acc;
		eventFile = event;
	}

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