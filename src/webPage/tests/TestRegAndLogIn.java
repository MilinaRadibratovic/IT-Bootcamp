package webPage.tests;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.GetData;
import webPage.objects.RegAndLogIn;
import webPage.objects.Home;

public class TestRegAndLogIn extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void createOneUser() throws Exception {
		// Sample data are on the BaseTest class
		// this method creates one user
		// driver.get(Home.HOME_URL);
		// Home.clickSignIn(driver);
		Thread.sleep(3000);

		// sending data to a web page
		RegAndLogIn.sendEmailAdr(driver, emailAdress);
		RegAndLogIn.clickCreate(driver);
		Thread.sleep(2000);
		RegAndLogIn.sendFirstName1(driver, firstName);
		RegAndLogIn.sendLastName1(driver, lastName);
		RegAndLogIn.sendPassword(driver, password);
		RegAndLogIn.sendFirstName2(driver, firstName);
		RegAndLogIn.sendLastName2(driver, lastName);
		RegAndLogIn.sendAddress1(driver, adress1);
		RegAndLogIn.sendCity(driver, city);
		RegAndLogIn.selectState(driver, state);
		RegAndLogIn.sendZip(driver, zip);
		RegAndLogIn.sendPhone(driver, phone);
		RegAndLogIn.sendAddress2(driver, adress1);
		RegAndLogIn.clickRegister(driver);
		Thread.sleep(2000);
		WebElement actual = RegAndLogIn.clickSignOut(driver);
		Assert.assertNotNull(actual);
	}

	@Test(priority = 2, enabled = true)
	public void createUsersFromExcel() throws Exception {

		SoftAssert sa = new SoftAssert();
		for (int i = 1; i < 31; i++) {
			// Method to fill in Registration form for 30 users from Excel table
			// Get to sign in in page
			driver.get(Home.HOME_URL);
			Home.clickSignIn(driver);
			Thread.sleep(4000);
			// sending data to a web page
			RegAndLogIn.sendEmailAdr(driver, GetData.getCellData(i, 0));
			RegAndLogIn.clickCreate(driver);
			Thread.sleep(7000);
			// checking if can be done
			String actual = driver.getCurrentUrl();
			String expected = "controller=authentication&back=my-account#account-creation";
			sa.assertEquals(actual, expected);
			if (actual.contains(expected)) {
				RegAndLogIn.sendFirstName1(driver, GetData.getCellData(i, 1));
				RegAndLogIn.sendLastName1(driver, GetData.getCellData(i, 2));
				RegAndLogIn.sendPassword(driver, GetData.getCellData(i, 3));
				RegAndLogIn.sendFirstName2(driver, GetData.getCellData(i, 1));
				RegAndLogIn.sendLastName2(driver, GetData.getCellData(i, 2));
				RegAndLogIn.sendAddress1(driver, GetData.getCellData(i, 4));
				RegAndLogIn.sendCity(driver, GetData.getCellData(i, 5));
				RegAndLogIn.selectState(driver, GetData.getCellData(i, 6));
				RegAndLogIn.sendZip(driver, GetData.getCellData(i, 7));
				RegAndLogIn.sendPhone(driver, GetData.getCellData(i, 8));
				RegAndLogIn.sendAddress2(driver, GetData.getCellData(i, 4));
				RegAndLogIn.clickRegister(driver);
				Thread.sleep(7000);
				GetData.setCellData("PASSED", i, 9);
				RegAndLogIn.clickSignOut(driver);
			} else {
				GetData.setCellData("FAILED", i, 9);
				testFail();
			}
			Thread.sleep(4000);
		}
		sa.assertAll();

	}

	@Test(priority = 3, enabled = true)
	public void logInExcelUsers() throws Exception {

		SoftAssert sa = new SoftAssert();
		for (int i = 1; i < 31; i++) {
			driver.get(Home.HOME_URL);
			Home.clickSignIn(driver);
			Thread.sleep(4000);
			// sending data
			RegAndLogIn.sendEmailSignIn(driver, GetData.getCellData(i, 0));
			RegAndLogIn.sendPasswordLogIn(driver, GetData.getCellData(i, 3));
			RegAndLogIn.clickLogIn(driver);
			Thread.sleep(7000);
			// checking if loging was successful
			String actual = driver.getTitle();
			String expected = "My account";
			sa.assertEquals(actual, expected);
			if (actual.contentEquals(expected)) {
				GetData.setCellData("PASSED", i, 10);
				RegAndLogIn.clickSignOut(driver);
			} else {
				GetData.setCellData("FAILED", i, 10);
				testFail();
			}
			Thread.sleep(4000);
		}
		sa.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void clearData() throws Exception {
		int n = GetData.rewriteData();
		GetData.newCellData(n);

	}

}
