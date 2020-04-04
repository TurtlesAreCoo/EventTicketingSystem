package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BackEndTest_readEventList {

	@Test
	void test() {
		
		HashMap<String, Event> result = BackEnd.readEventList("EventList");
		assertNotNull("AccountList file not found", result); 
	}

}
