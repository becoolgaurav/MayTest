package com.leaarnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.utils.Helper;



public class HomePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By manage=By.xpath("//*[text()='Manage']");
	private By burgerButton=By.xpath("//img[@alt='menu']");
	private By signOut=By.xpath("//button[text()='Sign out']");
	
	public WebElement manageIsDisplayed()
	{
		WebElement el=driver.findElement(manage);
		
		//boolean sts=driver.findElement(manage).isDisplayed();
		 WebElement manage=Helper.waitForElement(driver, el);
		return manage;
	}
	
	public LoginPage SignOut()
	{
		driver.findElement(burgerButton).click();
		driver.findElement(signOut).click();
		LoginPage page=new LoginPage(driver);
		return page;
	}
	
	
}
