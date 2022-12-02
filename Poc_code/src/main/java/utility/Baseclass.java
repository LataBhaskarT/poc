package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass extends ExtentReporterNG {
	// TODO Auto-generated method stub
	public static WebDriver driver;
	public static Properties propFile;
	public ExtentReports extent;
	public ExtentTest extentTest;

	
	/*@BeforeTest
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output1/ExtentReport.html", true);
		
	}*/
	
	/*@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}*/
	
	@BeforeMethod
	public static void openBrowser() throws IOException{
		propFile = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/utility/config.properties");
		propFile.load(ip);

		WebDriverManager.chromedriver().setup();
		DesiredCapabilities SSLCertificate = DesiredCapabilities.chrome();
		// Set the pre defined capability – ACCEPT_SSL_CERTS value to true
		SSLCertificate.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// Open a new instance of chrome driver with the desired capability
		 driver = new ChromeDriver(SSLCertificate);

		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		String applicationUrl = propFile.getProperty("url");
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(applicationUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	public void waitForDisplayed(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
