package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	 public HomePage(WebDriver driver) {
		
		super(driver);
	 }	
	@FindBy(xpath="//i[contains(@class,'fa fa-user')]")
	WebElement lnkMyaccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	public void ClickMyAccount() {
		
		lnkMyaccount.click();
	}
	
	public void ClickRegister() {
		
		lnkRegister.click();
	}
    public void ClickLogin() {
		
		lnkLogin.click();
	}
	
	
}

