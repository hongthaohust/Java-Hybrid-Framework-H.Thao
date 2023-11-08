package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserOrdersPO extends AbstractPage {
	WebDriver driver;
	
	public UserOrdersPO(WebDriver driver) {
		this.driver = driver;
	}

}
