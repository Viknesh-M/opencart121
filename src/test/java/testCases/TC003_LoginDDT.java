package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email,String pass,String exp) {
		
		logger.info("****Start TC003_LoginDDT *******");
		try {
	//home page
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
			
	//login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.ClickLogin();
			
	//myaccount page verify
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExist();
			
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true);
		 
		if(exp.equalsIgnoreCase("Valid")) {
			
			if(targetPage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(true);
			}
			else {
				
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(false);
				
			}
             else {
				
				Assert.assertTrue(true);
			}
		}}catch(Exception e){
			
			Assert.fail();
		}
       logger.info("****Finished TC003_LoginDDT *******");
}}
