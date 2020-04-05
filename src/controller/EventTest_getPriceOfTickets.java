package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getPriceOfTickets {

	@Test
	void test() {
		/* eventobject is created with the parameters seen below
		 * then a the getPriceOfTickets method is called 
		 * the result double should return the current price per ticket
		 */
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		Double result = eventObject.getPriceOfTickets();
		Double prc = (double) 22.99;
		assertEquals(prc, result);
	}

}
