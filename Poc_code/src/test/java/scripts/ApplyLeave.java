package scripts;

import org.testng.annotations.Test;

import pages.ApplyLeavePage;
import pages.LoginPage;

public class ApplyLeave extends ApplyLeavePage {
	
	@Test
	public void testApplyLeave() throws InterruptedException {
	ApplyLeavePage applyLeave=new ApplyLeavePage();
	LoginPage loginPage=new LoginPage();
	loginPage.login();
	loginPage.verifyUserLoggedIn();
	applyLeave.clickOnApplyLeave();
	applyLeave.fillLeaveDetails();
	}
	

}
