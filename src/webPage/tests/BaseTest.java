package webPage.tests;

import org.testng.annotations.Test;

import utility.GetData;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	protected static WebDriver driver;
//This is the data used for registering one user
	protected static String emailAdress = "msdauenhwih@mail.com";
	protected static String firstName = "Milutin";
	protected static String lastName = "Nikolic";
	protected static String password = "PaSword";
	protected static String adress1 = "5 Badeau Plaza";
	protected static String city = "Honolulu";
	protected static String state = "Hawaii";
	protected static String zip = "32144";
	protected static String phone = "419154643";

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterSuite
	public void afterSuite() {
		driver.close();

	}

//This method takes a screenshot if test fails
	public void testFail() throws Exception {
		TakesScreenshot ssh = (TakesScreenshot) driver;
		File source = ssh.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(source, new File("./Screenshots/Screenshot.png"));
	}
}
