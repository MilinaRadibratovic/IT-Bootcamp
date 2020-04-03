package webPage.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegAndLogIn {

	public static final String EMAIL_ID = "email_create";
	public static final String BTN_CREATE_ID = "SubmitCreate";
	public static final String CUST_FIRST_NAME_NAME = "customer_firstname";
	public static final String CUST_LAST_NAME_NAME = "customer_lastname";
	public static final String PASSWORD_ID = "passwd";
	public static final String FIRST_NAME_NAME = "firstname";
	public static final String LAST_NAME_NAME = "lastname";
	public static final String ADDRESS1_ID = "address1";
	public static final String CITY_ID = "city";
	public static final String STATE_ID = "id_state";
	public static final String ZIP_ID = "postcode";
	public static final String PHONE_ID = "phone_mobile";
	public static final String ADDRESS2_ID = "alias";
	public static final String BTN_REGISTER_ID = "submitAccount";
	public static final String LOG_OUT_LTEXT = "Sign out";
	public static final String EMAIL_ID_SINGNIN = "email";
	public static final String BTN_SIGN_IN_XPATH = "//p[@class='submit']//span[1]";
	public static final String PASSWORD_LOGIN_ID = "passwd";
	public static final String REG_FAIL_XPATH = "//li[contains(text(),'An account using this email address has already be')]";
	public static final String LOG_FAIL_XPATH = "//li[contains(text(),'Authentication failed.')]";

//Sends user email for registration
	public static void sendEmailAdr(WebDriver driver, String emailAdress) {
		WebElement e_email = driver.findElement(By.id(EMAIL_ID));
		e_email.click();
		e_email.sendKeys(emailAdress);
	}

// Clicks registration button
	public static void clickCreate(WebDriver driver) {
		WebElement e_create = driver.findElement(By.id(BTN_CREATE_ID));
		e_create.click();
	}

	// Sends user first name for registration
	public static void sendFirstName1(WebDriver driver, String firstName) {
		WebElement e_firstName1 = driver.findElement(By.name(CUST_FIRST_NAME_NAME));
		e_firstName1.click();
		e_firstName1.sendKeys(firstName);
	}

	// Sends user last name for registration
	public static void sendLastName1(WebDriver driver, String lastName) {
		WebElement e_lastName1 = driver.findElement(By.name(CUST_LAST_NAME_NAME));
		e_lastName1.click();
		e_lastName1.sendKeys(lastName);
	}

	// Sends user password for registration
	public static void sendPassword(WebDriver driver, String password) {
		WebElement e_pswrd = driver.findElement(By.id(PASSWORD_ID));
		e_pswrd.click();
		e_pswrd.sendKeys(password);
	}

	// Sends user first name for registration, it is not necessary, default is set
	// to same first name
	public static void sendFirstName2(WebDriver driver, String firstName) {
		WebElement e_firstName2 = driver.findElement(By.name(FIRST_NAME_NAME));
		e_firstName2.click();
		e_firstName2.sendKeys(firstName);
	}

	// Sends user last name for registration, it is not necessary,default is set to
	// same last name
	public static void sendLastName2(WebDriver driver, String lastName) {
		WebElement e_lastName2 = driver.findElement(By.name(LAST_NAME_NAME));
		e_lastName2.click();
		e_lastName2.sendKeys(lastName);
	}

	// Sends user adress name for registration
	public static void sendAddress1(WebDriver driver, String address1) {
		WebElement e_address1 = driver.findElement(By.id(ADDRESS1_ID));
		e_address1.click();
		e_address1.sendKeys(address1);
	}

	// Sends user city name for registration
	public static void sendCity(WebDriver driver, String city) {
		WebElement e_city = driver.findElement(By.id(CITY_ID));
		e_city.click();
		e_city.sendKeys(city);
	}

	// Selects user state name for registration
	public static void selectState(WebDriver driver, String state) {
		WebElement e_state = driver.findElement(By.id(STATE_ID));
		Select select = new Select(e_state);
		select.selectByVisibleText(state);
		e_state.click();

	}

	// Sends user zip code name for registration
	public static void sendZip(WebDriver driver, String zip) {
		WebElement e_zip = driver.findElement(By.id(ZIP_ID));
		e_zip.click();
		e_zip.sendKeys(zip);
	}

	// Sends user phone name for registration
	public static void sendPhone(WebDriver driver, String phone) {
		WebElement e_phone = driver.findElement(By.id(PHONE_ID));
		e_phone.click();
		e_phone.sendKeys(phone);
	}

	// Sends user delivery address name for registration, by default is set to first
	// address
	public static void sendAddress2(WebDriver driver, String address2) {
		WebElement e_address2 = driver.findElement(By.id(ADDRESS2_ID));
		e_address2.click();
		e_address2.clear();
		e_address2.sendKeys(address2);
	}

	// Clicks on registration button
	public static void clickRegister(WebDriver driver) {
		WebElement e_register = driver.findElement(By.id(BTN_REGISTER_ID));
		e_register.click();
	}

	// Clicks on log out button
	public static WebElement clickSignOut(WebDriver driver) {
		WebElement e_logOut = driver.findElement(By.partialLinkText(LOG_OUT_LTEXT));
		e_logOut.click();
		return e_logOut;
	}

	// Sends user email for log in for already created user
	public static void sendEmailSignIn(WebDriver driver, String emailAdress) {
		WebElement e_email = driver.findElement(By.id(EMAIL_ID_SINGNIN));
		e_email.click();
		e_email.sendKeys(emailAdress);
	}

	// Clicks on Log in button for already created user
	public static void clickLogIn(WebDriver driver) {
		WebElement e_logIn = driver.findElement(By.xpath(BTN_SIGN_IN_XPATH));
		e_logIn.click();
	}

	// Sends password for already created user
	public static void sendPasswordLogIn(WebDriver driver, String password) {
		WebElement e_pswrd = driver.findElement(By.id(PASSWORD_LOGIN_ID));
		e_pswrd.click();
		e_pswrd.sendKeys(password);
	}

	public static WebElement regFail(WebDriver driver) {
		WebElement e_fail = driver.findElement(By.xpath(REG_FAIL_XPATH));
		return e_fail;
	}
	
	public static WebElement logFail(WebDriver driver) {
		WebElement e_fail = driver.findElement(By.xpath(REG_FAIL_XPATH));
		return e_fail;
	}
}
