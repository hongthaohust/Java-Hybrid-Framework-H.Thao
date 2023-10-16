package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isGenderMaleSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public boolean isGenderFemaleUnselected() {
		waitForElementVisible(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
		return !isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstName() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastName() {
		waitForElementVisible(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getDateOfBirthDay() {
		waitForElementVisible(driver, CustomerInfoPageUI.DATE_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, CustomerInfoPageUI.DATE_DROPDOWN);
	}

	public String getDateOfBirthMonth() {
		waitForElementVisible(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getDateOfBirthYear() {
		waitForElementVisible(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedTextIndropdown(driver, CustomerInfoPageUI.YEAR_DROPDOWN);
	}

	public String getEmail() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyName() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttribute(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.NEWLETTER_TEXTBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWLETTER_TEXTBOX);
	}

}