package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getNumOfTickets {

	@Test
	void test() {
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		int result = eventObject.getNumOfTickets();
		assertEquals(50, result);
	}

}
