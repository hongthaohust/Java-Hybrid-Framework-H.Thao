package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveTechpanda.UserHomePageUI;

public class UserHomePO extends AbstractPage {
	WebDriver driver;
	
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.ACCOUNT_DROPDOWN);
		clickToElement(driver, UserHomePageUI.ACCOUNT_DROPDOWN);
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	public boolean isRegisterSuccess() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_SUCCESS_TEXT);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_SUCCESS_TEXT);
	}
}