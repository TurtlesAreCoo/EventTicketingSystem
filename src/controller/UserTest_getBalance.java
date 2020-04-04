package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest_getBalance {

	@Test
	void test() {
		User userObject = new User("Admin", "AA", 100);
		Double result = userObject.getBalance();
		Double num = (double) 100; 
		assertEquals(num, result); //different type of assert 
		
	}

}
