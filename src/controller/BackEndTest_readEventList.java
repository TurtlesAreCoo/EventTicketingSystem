package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BackEndTest_readEventList {

	@Test
	void test() {
		/* A hashmap named result is created with the parameters seen below
		 * then a the readEventList method is called 
		 * the result should not be a null
		 * it will be the list of events in the event list file
		 */
		
		HashMap<String, Event> result = BackEnd.readEventList("EventList");
		assertNotNull("AccountList file not found", result); 
	}

}
