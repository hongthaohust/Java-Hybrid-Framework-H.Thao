package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends AbstractPage {
	WebDriver driver;
	
	public UserCustomerInfoPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleSelected() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public boolean isGenderFemaleUnselected() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		return !isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstName() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttribute(driver, UserCustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastName() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttribute(driver, UserCustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getDateOfBirthDay() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, UserCustomerInfoPageUI.DATE_DROPDOWN);
	}

	public String getDateOfBirthMonth() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getDateOfBirthYear() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmail() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyName() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterSelected() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NEWLETTER_TEXTBOX);
		return isElementSelected(driver, UserCustomerInfoPageUI.NEWLETTER_TEXTBOX);
	}

}