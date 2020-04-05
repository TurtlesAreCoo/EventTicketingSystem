package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_getType {

	// test to see if the correct type is returned 
	@Test
	void test() {
		/* userobject is created with the parameters seen below
		 * then a the getType method is called 
		 * the result string should return the type which in this case is AA
		 */
		User userObject = new User("Admin", "AA", 100);
		String result = userObject.getType();
		assertEquals("AA", result);
	}

}
