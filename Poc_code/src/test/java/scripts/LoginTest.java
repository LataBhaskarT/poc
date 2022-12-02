package scripts;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends LoginPage  {
	
	
	@Test(description="Login Test")
	public void loginPageTest(){
		LoginPage loginPage=new LoginPage();
		loginPage.login();
		loginPage.verifyUserLoggedIn();
		
	}
	
}
