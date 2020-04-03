package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class S_Dresses {

	public static final String BLUE_ID="color_20";
	public static final String QUANT_XPATH="//a[@class='btn btn-default button-plus product_quantity_up']//span";
	public static final String SIZE_ID="group_1";
	public static final String TO_CART_XPATH="//span[contains(text(),'Add to cart')]";
	public static final String CHECKOUT_XPATH="//span[contains(text(),'Proceed to checkout')]";
	
	public static void clickBlueDress(WebDriver driver) {
		WebElement btn = driver.findElement(By.id(BLUE_ID));
		btn.click();
	}
	
	public static void clickQuantity(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(QUANT_XPATH));
		btn.click();
		
	}
	
	public static void selectSize(WebDriver driver) {
		WebElement btn = driver.findElement(By.id(SIZE_ID));
		Select select=new Select(btn);
		select.selectByVisibleText("M");
		btn.click();
		
	}
	public static void addToCart(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(TO_CART_XPATH));
		btn.click();
		
	}
	public static void proceedToCheckout(WebDriver driver) {
		WebElement btn = driver.findElement(By.xpath(CHECKOUT_XPATH));
		btn.click();
		
	}
}
