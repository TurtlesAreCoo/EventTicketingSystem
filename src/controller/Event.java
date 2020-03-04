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
	
}
