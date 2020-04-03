package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {

	public static final String HOME_URL = "http://automationpractice.com/index.php";
	public static final String WOMEN_BTN_XPATH = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	public static final String W_SUMMER_DRESSES_XPATH = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	public static final String DRESSES_BTN_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]";
	public static final String D_SUMMER_DRESSES_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul[@class='submenu-container clearfix first-in-line-xs']/li[3]/a[1]";
	public static final String CART_BTN_XPATH = "//b[contains(text(),'Cart')]";
	public static final String SIGNIN_CNAME = "login";

	// Method to hover over WOMEN link and click on Sumer dresses link
	public static String clickW_SummerDresses(WebDriver driver) throws Exception {
		Actions action1 = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath(WOMEN_BTN_XPATH));
		action1.moveToElement(btn);
		Thread.sleep(2000);
		action1.moveToElement(driver.findElement(By.xpath(W_SUMMER_DRESSES_XPATH))).click().build().perform();
		String current1 = driver.getCurrentUrl();
		return current1;
	}

//Method to hover over DRESSES link and click on SUMMER DRESSES link
	public static String clickD_SummerDresses(WebDriver driver) throws Exception {
		Actions action2 = new Actions(driver);
		WebElement btn = driver.findElement(By.xpath(DRESSES_BTN_XPATH));
		action2.moveToElement(btn);
		Thread.sleep(2000);
		action2.moveToElement(driver.findElement(By.xpath(D_SUMMER_DRESSES_XPATH))).click().build().perform();
		String current2 = driver.getCurrentUrl();
		return current2;
	}

//Method to navigate to HomePage url if on other page
	public static void backHome(WebDriver driver) {
		driver.navigate().to(HOME_URL);
	}

	public static void clickCartBtn(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(CART_BTN_XPATH));
		btn.click();

	}

	public static void clickSignIn(WebDriver driver) {
		WebElement e_signIn = driver.findElement(By.className(SIGNIN_CNAME));
		e_signIn.click();

	}

}