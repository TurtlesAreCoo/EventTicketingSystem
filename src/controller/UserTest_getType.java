package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_getType {

	// test to see if the correct type is returned 
	@Test
	void test() {
		User userObject = new User("Admin", "AA", 100);
		String result = userObject.getType();
		assertEquals("AA", result);
	}

}
