package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getSellerName {

	@Test
	void test() {
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		String result = eventObject.getSellerName();
		assertEquals("Seller1", result);
	}

}
