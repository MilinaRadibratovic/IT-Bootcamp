package webPage.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import webPage.objects.Home;

public class TestHome extends BaseTest {


	@Test(priority = 1,enabled=true)
	public static void getSummerDressesPage1() throws Exception {
		driver.get(Home.HOME_URL);
		Home.clickW_SummerDresses(driver);
		String current1 = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		boolean ok = current1.contains(expected);

		Assert.assertTrue(ok);

	}

	@Test(priority = 2,enabled=true)
	public static void getSummerDressesPage2() throws Exception {
		driver.get(Home.HOME_URL);
		Home.clickD_SummerDresses(driver);
		String current2 = driver.getCurrentUrl();
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
		boolean ok = current2.contains(expected);

		Assert.assertTrue(ok);

	}

	@Test(priority = 3,enabled=true)
	public static void compareLinks() throws Exception {
		driver.get(Home.HOME_URL);
		String w_link = Home.clickW_SummerDresses(driver);
		Home.backHome(driver);
		String d_link = Home.clickD_SummerDresses(driver);
		Assert.assertEquals(w_link, d_link);

	}

}
