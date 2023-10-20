package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	// Hàm khởi tạo (Constructor)
	// Khi new Class này lên HomePageObject thì nó sẽ chạy đầu tiên
	// Không có kiểu trả về
	// Cùng tên với tên class
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAccountLink;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginLink;

	public void clickRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}
	
	public boolean isAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplay(driver, myAccountLink);
	}

	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, loginLink);
		return isElementDisplay(driver, loginLink);
	}
	
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, logoutLink);
		return isElementDisplay(driver, logoutLink);
	}

	public void clickMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}
	
	public void clickLoginLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}