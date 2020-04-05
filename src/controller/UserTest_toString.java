package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_toString {

	@Test
	void test() {
		/* userobject is created with the parameters seen below
		 * then a the toString method is called 
		 * the result string should be formatted as seen in the assertEquals statement below
		 */
		User userObject = new User("Humza", "AA", 100);
		String result = userObject.toString();
		assertEquals("Humza           AA 000001000", result); 
			
	}

}
