package com.learnautomation.reports;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

	public class ExtentManager {
	    
	    private static ExtentReports extent;
	    
	    public static ExtentReports getInstance() {
	    	if (extent == null)
	    		createInstance();
	    	
	        return extent;
	    }
	    
	    public static ExtentReports createInstance() {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:/CC/E2e/ExtentReport/Automate1.html");
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Gaurav Automation Report");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("report 1");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        return extent;
	    }
	}
	


