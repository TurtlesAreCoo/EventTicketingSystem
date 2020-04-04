package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_toString {

	@Test
	void test() {
		User userObject = new User("Humza", "AA", 100);
		String result = userObject.toString();
		assertEquals("Humza           AA 000001000", result); 
			
	}

}
