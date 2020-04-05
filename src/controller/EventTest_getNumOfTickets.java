package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getNumOfTickets {

	@Test
	void test() {
		/* eventobject is created with the parameters seen below
		 * then a the getNumOfTickets method is called 
		 * the result int should return the current number of tickets
		 */
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		int result = eventObject.getNumOfTickets();
		assertEquals(50, result);
	}

}
