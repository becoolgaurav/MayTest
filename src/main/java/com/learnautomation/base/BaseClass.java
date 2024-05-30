package com.learnautomation.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.learnautomation.browser.Browserfactory;
import com.learnautomation.dataprovider.ConfigReader;

public class BaseClass {
	
protected WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		Reporter.log("Launching the setUp", true);
		driver=Browserfactory.getBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("appURL"));
		
	}
	
	@AfterClass
	public void exit()
	{
		Reporter.log("Launching the tearDown", true);
		Browserfactory.closeBrowser(driver);
	}
}
