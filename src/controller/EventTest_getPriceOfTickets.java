package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getPriceOfTickets {

	@Test
	void test() {
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		Double result = eventObject.getPriceOfTickets();
		Double prc = (double) 22.99;
		assertEquals(prc, result);
	}

}
