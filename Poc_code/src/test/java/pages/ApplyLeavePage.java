package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.Baseclass;

public class ApplyLeavePage extends Baseclass{
	
	@FindBy(css="button[title='Apply Leave']") WebElement applyLeavel;
	@FindBy(css="div.oxd-select-wrapper") WebElement selectLeaveType;
	@FindBy(css="div.oxd-date-input input") List<WebElement> dates;
	@FindBy(css="textarea.oxd-textarea") WebElement comments;
	@FindBy(css="button[type='submit']") WebElement applyBttn;
	@FindBy(css="div.oxd-select-option span") WebElement typeOfLeave;
	
	
	public ApplyLeavePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnApplyLeave() {
		applyLeavel.click();		
	}
	
	public void fillLeaveDetails() throws InterruptedException {
		
		selectLeaveType.click();
		Thread.sleep(5000);
		typeOfLeave.click();
		Thread.sleep(5000);
		
	}
}
