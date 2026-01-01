package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001AccountRegistrationPage extends BaseClass {

    @Test(groups = {"regression","master"})
    public void verify_account_registration() {

        logger.info("***** Starting TC001_AccountRegistrationTest *****");

        try {
        	Thread.sleep(1000);
            HomePage hp = new HomePage(driver);
            hp.ClickMyAccount();
            logger.info("Clicked on MyAccount Link");

            hp.ClickRegister();
            logger.info("Clicked on Register Link");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            logger.info("Providing customer details");
            regpage.setFirstUsername(randomString().toUpperCase());
            regpage.setLastname(randomString().toUpperCase());
            regpage.setEmail(randomString() + "@gmail.com");
            regpage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();
            regpage.setPassword(password);
            regpage.setConfirmPassword(password);

            regpage.setPolicy();
            regpage.ClickContinue();

            String confmsg = regpage.getConfirmationmsg();
            Assert.assertEquals(confmsg,
                    "Your Account Has Been Created!",
                    "Confirmation message mismatch");

            logger.info("Test passed");

        } catch (Exception e) {
            logger.error("Test failed", e);
            Assert.fail("Test failed: " + e.getMessage());
        }

        logger.info("***** Finished TC001_AccountRegistrationTest *****");
    }
    public String randomString() {
	    return RandomStringUtils.randomAlphabetic(5);
	}

	public String randomNumber() {
	    return RandomStringUtils.randomNumeric(10);
	}

	public String randomAlphaNumeric() {
	    String str = RandomStringUtils.randomAlphabetic(3);
	    String num = RandomStringUtils.randomNumeric(3);
	    return str + "@" + num;
	}
}

