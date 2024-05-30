package com.learnautomation.reports;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.base.BaseClass;
import com.learnautomation.browser.Browserfactory;
import com.learnautomation.utils.Helper;

public class ExtentListner implements ITestListener{


	ExtentReports extent=ExtentManager.getInstance();
	ExtentTest test;
	
	public void onTestSuccess(ITestResult result) {
	   
	   test.pass("Test Case passed");
//	    Reporter.log( result.getInstanceName(), true);
//	    Reporter.log( result.getMethod().getMethodName(), true);
//	    Reporter.log( ""+result.getStatus(), true);
	   
	  }

	public void onTestFailure(ITestResult result) {
	    // not implemented
		
		WebDriver driver=Browserfactory.getDriver();
		String cap=Helper.captureScreenshot(driver);
		test.fail("Test Case failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromBase64String(cap).build());
		Reporter.log( result.getInstanceName(), true);
	    Reporter.log( result.getMethod().getMethodName(), true);
	    Reporter.log( ""+result.getStatus(), true);
	    Reporter.log( result.getThrowable().getMessage(), true);
	    
	  }
	
	public void onTestStart(ITestResult result) {
	    // not implemented
		
	    test =extent.createTest(result.getMethod().getMethodName());
	  }
	
	public void onFinish(ITestContext context) {
	    // not implemented
		Reporter.log( "Test finihed", true);
	   // Reporter.log( result.getMethod().getMethodName(), true);
		extent.flush();
	  }
	
}
