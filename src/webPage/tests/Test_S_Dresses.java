package webPage.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import webPage.objects.Checkout;
import webPage.objects.Home;
import webPage.objects.S_Dresses;

public class Test_S_Dresses extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void selectDress() throws Exception {
		// Selecting a dress
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		driver.get(Home.HOME_URL);
		Home.clickW_SummerDresses(driver);
		S_Dresses.clickBlueDress(driver);
		S_Dresses.clickQuantity(driver);
		S_Dresses.selectSize(driver);
		S_Dresses.addToCart(driver);
		S_Dresses.proceedToCheckout(driver);

		String current = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?controller=order";
		Assert.assertEquals(current, expected);

	}

	@Test(priority = 2, enabled = true)
	public void cartCheck() throws Exception {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		// Checking if right dress is selected
		driver.get(Home.HOME_URL);
		Home.clickCartBtn(driver);
		Thread.sleep(2000);

		WebElement wd = driver.findElement(By.linkText("Printed Summer Dress"));
		String dressName = wd.getText();
		String expected = "Printed Summer Dress";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(dressName, expected);

		WebElement quantity = driver.findElement(By.name("quantity_5_24_0_0"));
		String s = quantity.getAttribute("value");
		sa.assertEquals(s, "2");

		WebElement color = driver.findElement(By.xpath("//small[2]"));
		String dress = color.getText();
		boolean col = dress.contains("Blue");
		boolean siz = dress.contains("M");
		sa.assertTrue(col);
		sa.assertTrue(siz);
		Checkout.clickProceed(driver);

		sa.assertAll();
	}

}
