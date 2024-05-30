package com.learnautomation.utils;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Helper {
/*
 * sleep
 * Explicit timeout
 * scroll
 * 
 * 
 */
	
	public static void select(WebElement ele,String state)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(state);
	}
	
	public static void mouseHover(WebDriver driver,WebElement el)
	{
		Actions act=new Actions(driver);
		act.moveToElement(el).perform();
	}
	
	
	public static void sleep(int val) throws InterruptedException
	{
		Thread.sleep(val);
	}
	
	public static void scrollTillElementPresent(WebDriver driver,By locator)
	{
		
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(locator)).perform();
	}
	
	public static WebElement waitForElement(WebDriver driver, WebElement el)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(30000));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(el));
		return ele;
	}
	
	public static void click(WebDriver driver, WebElement ele)
	{
		try {
			ele.click();
		} catch (Exception e) {
			Reporter.log("Simple click failed,trying with actions class"+e.getMessage(), true);
			
			Actions act=new Actions(driver);
			try {
				act.click(ele).perform();
			} catch (Exception e2) {
				// TODO: handle exception
				Reporter.log("Actions click failed,trying with JSExecuter class"+e2.getMessage(), true);
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", ele);
			
			}
			
			
		}
		
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot scrrenshot=(TakesScreenshot)driver;
		String file=scrrenshot.getScreenshotAs(OutputType.BASE64);
		return file;
	}
	
}
