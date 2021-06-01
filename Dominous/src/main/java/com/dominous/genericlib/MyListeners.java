package com.dominous.genericlib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	       Reporter.log(result.getName()+" test Started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" test PASSED",true);
	}

	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" test FAILED", true);
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		try {
			wlib.getPageScreenshot("./Screenshots/"+result.getName()+".png");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+"test SKIPPED", true);
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" testRunner Started",true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" testRunner Ended", true);
		
	}

	
}
