package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest_getUsername {

	// test to see if the correct username is returned 
	@Test
	void test() {
		/* userobject is created with the parameters seen below
		 * then a the getUsername method is called 
		 * the result string should return the username which in this case is admin
		 */
		User userObject1 = new User("Admin", "AA", 100);
		String result = userObject1.getUsername();
		assertEquals("Admin", result);
	}
		
	
}
