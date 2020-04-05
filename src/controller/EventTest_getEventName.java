package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getEventName {

	@Test
	void test() {
		/* eventobject is created with the parameters seen below
		 * then a the getEventName method is called 
		 * the result string should return the event name which in this case is Travis_Scott
		 */
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		String result = eventObject.getEventName();
		assertEquals("Travis_Scott", result);
	}

}
