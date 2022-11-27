package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Baseclass;

public class LoginPage extends Baseclass{
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	WebElement loginBtn;
	
	@FindBy(css="span.oxd-userdropdown-tab")
	WebElement employeeImg;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
public void login() {
	userName.sendKeys("Admin");
	password.sendKeys("admin123");
	loginBtn.click();
	
}
public void verifyUserLoggedIn() {
	waitForDisplayed(employeeImg);
	
}
}
