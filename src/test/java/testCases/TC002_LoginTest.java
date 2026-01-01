package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void verify_login() {
		
		logger.info("**** Start TC002_LoginTest ******** ");
		try {
		//home page
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		//login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		//myaccount page verify
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExist();
		
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true);
	    
	}
		catch(Exception e) {
	
			Assert.fail();
		}
	   logger.info("***Finished TC001_LoginPage");

}}
