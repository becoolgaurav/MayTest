package com.leaarnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.utils.Helper;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By email=By.xpath("//input[@id='email1']");
	private By password=By.xpath("//input[@id='password1']");
	private By signIn=By.xpath("//button[@class='submit-btn']");
	private By signUp=By.xpath("//a[@class='subLink']");
	
	
	public boolean signInDisplay()
	{
		return driver.findElement(signIn).isDisplayed();
	}
	
	public HomePage signIn(String uName,String pWord)
	{
		driver.findElement(email).sendKeys(uName);
		driver.findElement(password).sendKeys(pWord);
		driver.findElement(signIn).click();
		HomePage home=new HomePage(driver);
		return home;
		
	}
	
	public boolean getTitle(String title)
	{
		boolean stats=driver.getTitle().contains(title);
		return stats;
	}
	
	public RegisterationPage clickSignUp()
	{
		WebElement el=driver.findElement(signUp);
		Helper.waitForElement(driver, el).click();
		RegisterationPage register=new RegisterationPage(driver);
		return register;
	}
	
	
	
	
	
	
	

}
