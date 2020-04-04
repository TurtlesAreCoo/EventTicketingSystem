package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BackEndTest_readAccountList {

	@Test
	void test() {	
		HashMap<String, User> result = BackEnd.readAccountList("AccountList");
		assertNotNull("AccountList file not found", result); 

	}

	}


