package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserRegisterPageUI;

public class UserRegisterPO extends AbstractPage {
	WebDriver driver;
	
	public UserRegisterPO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickGenderRadio() {
		waitForElementClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void selectDay(String day) {
		waitForElementVisible(driver, UserRegisterPageUI.DATE_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.DATE_DROPDOWN, day);
	}

	public void selectMonth(String month) {
		waitForElementVisible(driver, UserRegisterPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.MONTH_DROPDOWN, month);
	}

	public void selectYear(String year) {
		waitForElementVisible(driver, UserRegisterPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserRegisterPageUI.YEAR_DROPDOWN, year);
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputCompany(String companyName) {
		waitForElementVisible(driver, UserRegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXTBOX, companyName);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputConfirmPassword(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getSuccessText() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
		return getText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
	}

	public UserHomePO clickLogoutLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public UserLoginPO clickLoginLink() {
		waitForElementClickable(driver, UserRegisterPageUI.LOGINT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGINT_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
}