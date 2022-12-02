package scripts;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegisterPage;
import utility.Baseclass;

public class RegisterTest extends Baseclass {
	
	@Test(description="Registration Test")
	public void registerPageTest() throws InterruptedException{
		
		LoginPage loginPage=new LoginPage();
		loginPage.login();
		loginPage.verifyUserLoggedIn();
		RegisterPage registerUser=new RegisterPage();
		registerUser.clickOnRegisterUSer();
		registerUser.clickOnAddUSer();
		registerUser.fillUserName();
		registerUser.saveDetails();
		registerUser.verifyEmployeeCreated();
		
		
	}
	

}
