package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_getSellerName {

	@Test
	void test() {
		/* eventobject is created with the parameters seen below
		 * then a the getSellerName method is called 
		 * the result string should return the seller's name which in this case is seller1
		 */
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		String result = eventObject.getSellerName();
		assertEquals("Seller1", result);
	}

}
