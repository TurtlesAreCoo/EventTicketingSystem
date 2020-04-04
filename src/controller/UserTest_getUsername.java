package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest_getUsername {

	// test to see if the correct username is returned 
	@Test
	void test() {
		User userObject1 = new User("Admin", "AA", 100);
		String result = userObject1.getUsername();
		assertEquals("Humza", result);
	}
		
	
}
