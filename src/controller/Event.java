package controller;

public class Event {
	private String eventName;
	private String sellerName;
	private int numOfTickets;
	private double priceOfTicket;
	//some constructors
	//some get methods
	public Event(String eName, String sName, int tickets, double price) {
		eventName = eName;
		sellerName = sName;
		numOfTickets = tickets;
		priceOfTicket = price;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public int getNumOfTickets() {
		return numOfTickets;
	}
	
	public double getPriceOfTickets() {
		return priceOfTicket;
	}
	
	public String toString() {
		return leftJustify(eventName, 19) + " " + leftJustify(sellerName, 15) + zeroRightJustify(String.valueOf(numOfTickets), 3) + " " + zeroRightJustify(String.valueOf(priceOfTicket).replace(".", ""), 6);
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
