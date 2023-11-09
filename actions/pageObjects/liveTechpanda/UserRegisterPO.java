package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveTechpanda.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;
	
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isTextDisplayed() {
		waitForElementVisible(driver, UserRegisterPageUI.CREATE_ACCOUNT_TEXT_CONFIRM);
		return isElementDisplayed(driver, UserRegisterPageUI.CREATE_ACCOUNT_TEXT_CONFIRM);
	}
	
	public void inputToFirstNameTextbox(String first_name) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT, first_name);
	}
	
	public void inputToMiddleNameTextbox(String middle_name) {
		waitForElementVisible(driver, UserRegisterPageUI.MIDDLE_NAME_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.MIDDLE_NAME_TEXT, middle_name);
	}
	public void inputToLastNameTextbox(String last_name) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT, last_name);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT, password);
	}
	

	public void inputToConfirmPasswordTextbox(String confirm_password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASWORD_TEXT);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASWORD_TEXT, confirm_password);
	}

	public UserHomePO clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public UserHomePO registerToSystem(String first_name, String middle_name, String last_name, String email, String password, String confirm_password) {
		inputToFirstNameTextbox(first_name);
		inputToMiddleNameTextbox(middle_name);
		inputToLastNameTextbox(last_name);
		inputToEmailTextbox(email);
		inputToPasswordTextbox(password);
		inputToConfirmPasswordTextbox(confirm_password);
		return clickToRegisterButton();
		}
}