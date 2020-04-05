package controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class BackEndTest_loopCoverage {

	@Test
	void test() {
		// this test is for decision and loop coverage
		//there are no loops in out backend methods hence only decision will be tested
		//this method gives a non existing file name for the account list 
		// the method readAccountList has a try and catch exception in it
		// when an incorrect file name is given the try and catch is executed instead of the rest of the code
		// a null should not be returned as a exception is caught. 
		
		HashMap<String, User> result = BackEnd.readAccountList(" ");
		assertNotNull("AccountList file not found", result); 
	}

}
