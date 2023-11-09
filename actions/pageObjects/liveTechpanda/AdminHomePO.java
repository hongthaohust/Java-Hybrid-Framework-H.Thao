package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveTechpanda.AdminHomePageUI;
import pageUIs.liveTechpanda.UserHomePageUI;

public class AdminHomePO extends AbstractPage {
	WebDriver driver;
	
	public AdminHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClosePopup() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
	}
	
	public boolean isRegisterSuccess() {
		waitForElementVisible(driver, UserHomePageUI.REGISTER_SUCCESS_TEXT);
		return isElementDisplayed(driver, UserHomePageUI.REGISTER_SUCCESS_TEXT);
	}
}