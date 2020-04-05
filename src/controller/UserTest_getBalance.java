package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_getBalance {

	@Test
	void test() {
		
		/* userobject is created with the parameters seen below
		 * then a the getBalance method is called 
		 * the result double should return the current balance, which for this case is 100
		 */
		User userObject = new User("Admin", "AA", 100);
		Double result = userObject.getBalance();
		Double num = (double) 100; 
		assertEquals(num, result); //different type of assert 
		
	}

}
