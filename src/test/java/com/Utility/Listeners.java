package com.Utility;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {								//TESTNG LISTENERS CLASS IMPLEMENTS THE ITESTLISTENER INTERFACE OF TESTNG 
	
	@Override
	public void onTestStart(ITestResult result) {								//THIS METHOD WILL MARK THE START OF A TEST
		System.out.println("Test Started : "+result.getName());					//THIS WILL PRINT THE DESIRED MESSAGE AND THE TEST NAME IF IT STARTS SUCCESSFULLY
	}

	 @Override
	public void onTestSuccess(ITestResult result) {								//THIS METHOD WILL MARK THE SUCCESSFUL OPERATION OF A TEST
		 System.out.println("Test Successful : "+result.getName());				//THIS WILL PRINT THE DESIRED MESSAGE AND THE TEST NAME IF IT PASSES SUCCESSFULLY
		 System.out.println();
	}

	 @Override
	public void onTestFailure(ITestResult result) {								//THIS METHOD WILL OVERRIDE IF A TEST FAILS 
		 System.out.println("Test Failed : "+result.getName());					//THIS WILL PRINT THE DESIRED MESSAGE AND THE TEST NAME IF IT FAILS
		 System.out.println();
	}

	 @Override
	public void onTestSkipped(ITestResult result) {								//THIS METHOD WILL OVERRIDE IF A TEST IS SKIPPED
		 System.out.println("Test Skipped : "+result.getName());				//THIS WILL PRINT THE DESIRED MESSAGE AND THE TEST NAME IF IT IS SKIPPED
		 System.out.println();
	}

	 @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	 @Override
	public void onStart(ITestContext context) {

	}

	 @Override
	public void onFinish(ITestContext context) {

	}
	
}
