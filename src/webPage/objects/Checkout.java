package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {
	
	public static final String BTN_CHECKOUT_XPATH="//span[text()='Proceed to checkout']";
	
	
	public static void clickProceed(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(BTN_CHECKOUT_XPATH));
		btn.click();

	}
	
	
	
	
	
}
