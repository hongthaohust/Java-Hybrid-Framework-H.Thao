package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;
	
	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}
}