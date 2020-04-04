package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EventTest_toString {

	@Test
	void test() {
		Event eventObject = new Event("Travis_Scott", "Seller1", 50, 22.99);
		String result = eventObject.toString();
		assertEquals("Travis_Scott        Seller1        050 002299", result);
	}

}
