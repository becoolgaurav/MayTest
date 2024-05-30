package com.leaarnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.utils.Helper;

public class RegisterationPage {
	WebDriver driver;
	
	public RegisterationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	By name=By.xpath("//input[@name='name']");
	By email=By.xpath("//input[@name='email']");
	By pass=By.xpath("//input[@name='password']");
	By interest=By.xpath("//input[@type='checkbox']");
	By gender=By.xpath("//input[@value='Male']");
	By state=By.xpath("//select[@name='state']");
	By hobby=By.xpath("//select[@name='hobbies']");
	By submit=By.xpath("//button[@class='submit-btn']");
	By manage=By.xpath("//img[@alt='menu']");
	By home=By.xpath("//a/*[text()='Home']");
	By title=By.xpath("//h1[text()='Learn Automation Courses']");
	
	
	public void register(String uname,String eemail,String ppass,String estate,String Hobby)
	{
		WebElement e=driver.findElement(name);
		Helper.waitForElement(driver, e);
		driver.findElement(name).sendKeys(uname);
		driver.findElement(email).sendKeys(eemail);
		driver.findElement(pass).sendKeys(ppass);
		driver.findElement(interest).click();
		driver.findElement(gender).click();
		WebElement e5=driver.findElement(state);
		WebElement e2=driver.findElement(hobby);
		Helper.select(e5, estate);
		Helper.select(e2, Hobby);
		driver.findElement(submit).click();		
		
	}
	
	public void clickSignIn()
	{
//		LoginPage login=new LoginPage(driver);
//		login.clickSignUp();
		driver.findElement(manage).click();
		driver.findElement(home).click();
	}
	
	public boolean titleDisplay()
	{
	return 	driver.findElement(title).isDisplayed();
	}
	
	

}
