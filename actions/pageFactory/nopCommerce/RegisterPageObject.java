package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	
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
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmpasswordTextbox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;

	public void clickGenderRadio() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void inputLastName(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
		
	}

	public void selectDay(String day) {
		waitForElementVisible(driver, dayOfBirth);
		selectItemInDropdown(driver, dayOfBirth, day);
	}

	public void selectMonth(String month) {
		waitForElementVisible(driver, monthOfBirth);
		selectItemInDropdown(driver, monthOfBirth, month);
	}

	public void selectYear(String year) {
		waitForElementVisible(driver, yearOfBirth);
		selectItemInDropdown(driver, yearOfBirth, year);
	}

	public void inputEmail(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputCompany(String companyName) {
		waitForElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, companyName);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputConfirmPassword(String password) {
		waitForElementVisible(driver, confirmpasswordTextbox);
		sendkeyToElement(driver, confirmpasswordTextbox, password);
	}

	public void clickRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getSuccessText() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getText(driver, registerSuccessMessage);
	}

	public void clickLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
	
	public void clickLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}
}