package com.dominous.operation;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo {
	
	@Test(priority=6)
	public void run() {
		Reporter.log("run tests are running successfully",true);
	}

}
