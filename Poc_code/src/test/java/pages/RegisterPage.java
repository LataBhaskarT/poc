package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import utility.Baseclass;

public class RegisterPage extends Baseclass {
	Faker faker = new Faker();

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement registerUser;

	@FindBy(css = "button.oxd-button--secondary i")
	WebElement addUser;

	@FindBy(css = "input.orangehrm-firstname")
	WebElement firstName;

	@FindBy(css = "input.orangehrm-middlename")
	WebElement middleName;

	@FindBy(css = "input.orangehrm-lastname")
	WebElement lastName;

	@FindBy(css = "button[type='submit']")
	WebElement saveButton;

	@FindBy(css = "div.orangehrm-edit-employee-name h6")
	WebElement employeeNameCreated;
	
	String firstNameOFEmployee = faker.name().firstName();

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnRegisterUSer() {
		waitForDisplayed(registerUser);
		registerUser.click();
	}

	public void clickOnAddUSer() {
		waitForDisplayed(addUser);
		addUser.click();
	}

	public void fillUserName() throws InterruptedException {
		Thread.sleep(5000);
		firstName.sendKeys(firstNameOFEmployee);
		Thread.sleep(5000);
		//waitForDisplayed(middleName);
		middleName.sendKeys(faker.name().firstName());
		Thread.sleep(5000);
		//waitForDisplayed(lastName);
		lastName.sendKeys(faker.name().lastName());
	}

	public void saveDetails() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		saveButton.click();
	}

	public void verifyEmployeeCreated() throws InterruptedException {
		//waitForDisplayed(employeeNameCreated);
		Thread.sleep(8000);
		String employeeName = employeeNameCreated.getText();
		Assert.assertTrue(employeeName.contains(firstNameOFEmployee), "User is created");
	}
}
