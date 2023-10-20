package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		
		// Tạo ra sự tham chiếu/ kết nối của các element
		PageFactory.initElements(driver, this);
	}
	
	// Định nghĩa element
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;
	
	public void inputEmail(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);
	}

	public void inputPassword(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void clickLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

}