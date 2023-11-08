package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageObject extends AbstractPage {
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	
	@FindBy(id = "gender-female")
	WebElement genderFemaleRadio;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement dayOfBirth;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement monthOfBirth;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearOfBirth;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Company")
	WebElement companyTextbox;
	
	@FindBy(id = "Newsletter")
	WebElement newLetter;
	

	public boolean isGenderMaleSelected() {
		waitForElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public boolean isGenderFemaleUnselected() {
		waitForElementVisible(driver, genderFemaleRadio);
		return !isElementSelected(driver, genderFemaleRadio);
	}

	public String getFirstName() {
		waitForElementVisible(driver, firstNameTextbox);
		return getAttribute(driver, firstNameTextbox, "value");
	}

	public String getLastName() {
		waitForElementVisible(driver, lastNameTextbox);
		return getAttribute(driver, lastNameTextbox, "value");
	}

	public String getDateOfBirthDay() {
		waitForElementVisible(driver, dayOfBirth);
		return getFirstSelectedTextIndropdown(driver, dayOfBirth);
	}

	public String getDateOfBirthMonth() {
		waitForElementVisible(driver, monthOfBirth);
		return getFirstSelectedTextIndropdown(driver, monthOfBirth);
	}

	public String getDateOfBirthYear() {
		waitForElementVisible(driver, yearOfBirth);
		return getFirstSelectedTextIndropdown(driver, yearOfBirth);
	}

	public String getEmail() {
		waitForElementVisible(driver, emailTextbox);
		return getAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyName() {
		waitForElementVisible(driver, companyTextbox);
		return getAttribute(driver, companyTextbox, "value");
	}

	public boolean isNewsletterSelected() {
		waitForElementVisible(driver, newLetter);
		return isElementSelected(driver, newLetter);
	}

}