package testcases;




import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import com.leaarnautomation.pages.HomePage;
import com.leaarnautomation.pages.LoginPage;
import com.learnautomation.base.BaseClass;
import com.learnautomation.dataprovider.DataProviders;


public class LoginTest extends BaseClass {
	
	
	
	@Test(dataProvider = "TestData",dataProviderClass = DataProviders.class)
	public void validLogin(String uname,String pass)
	{		
		Reporter.log("Launching the validation Login", true);
		
		LoginPage login=new LoginPage(driver);
		Assert.assertTrue(login.getTitle("Learn Automation"));
		HomePage home=login.signIn(uname,pass);
		WebElement stste=home.manageIsDisplayed();
		Assert.assertTrue(stste.isDisplayed());
		login=home.SignOut();
				
	}
	
	
	
	

}
