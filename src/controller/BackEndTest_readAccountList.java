package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BackEndTest_readAccountList {

	@Test
	void test() {	
		/* A hashmap named result is created with the parameters seen below
		 * then a the readAccountList method is called 
		 * the result should not be a null
		 * it will be the list of accounts in the account list file
		 */
		HashMap<String, User> result = BackEnd.readAccountList("AccountList");
		assertNotNull("AccountList file not found", result); 

	}

	}


