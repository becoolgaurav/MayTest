package com.learnautomation.browser;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.learnautomation.dataprovider.ConfigReader;

public class Browserfactory {

	public static WebDriver driver=null;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	
	public static WebDriver getBrowser(String browserName,String myUrl) throws IOException
	{
		
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
		{
			Reporter.log("Please privide valid driver");
			//System.out.println("Please privide valid driver");
		}
		String timeout=ConfigReader.getProperty("implicitwait");
		long time=Long.parseLong(timeout);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		driver.get(myUrl);
		return driver;
		
	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
