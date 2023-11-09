package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveTechpanda.AdminHomePageUI;

public class AdminLoginPO extends AbstractPage {
	WebDriver driver;
	
	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminHomePO clickLoginButton() {
		waitForElementClickable(driver, AdminHomePageUI.lOGIN_BUTTON);
		clickToElement(driver, AdminHomePageUI.lOGIN_BUTTON);
		
		return PageGeneratorManager.getAdminHomePage(driver);
	}
	
	public void inputToEmailTextbox(String username) {
		waitForElementVisible(driver, AdminHomePageUI.USERNAME_TEXT);
		sendkeyToElement(driver, AdminHomePageUI.USERNAME_TEXT, username);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminHomePageUI.PASSWORD_TEXT);
		sendkeyToElement(driver, AdminHomePageUI.PASSWORD_TEXT, password);
	}

	public AdminHomePO loginToSystem(String username, String password) {
		inputToEmailTextbox(username);
		inputToPasswordTextbox(password);
		return clickLoginButton();
	}
}