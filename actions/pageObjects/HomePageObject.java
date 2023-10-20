package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	// Hàm khởi tạo (Constructor)
	// Khi new Class này lên HomePageObject thì nó sẽ chạy đầu tiên
	// Không có kiểu trả về
	// Cùng tên với tên class
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}

	public boolean isAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		return isElementDisplay(driver, HomePageUI.LOGIN_LINK);
	}
	
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.LOGOUT_LINK);
		return isElementDisplay(driver, HomePageUI.LOGOUT_LINK);
	}

	public void clickMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	
	public void clickLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}

}