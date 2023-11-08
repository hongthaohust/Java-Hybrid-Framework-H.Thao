package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserHomePageUI;

public class UserHomePO extends AbstractPage {
	WebDriver driver;
	
	// Hàm khởi tạo (Constructor)
	// Khi new Class này lên HomePageObject thì nó sẽ chạy đầu tiên
	// Không có kiểu trả v�?
	// Cùng tên với tên class
	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public UserRegisterPO clickRegisterLink() {
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public boolean isAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLoginLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGIN_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGIN_LINK);
	}
	
	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.LOGOUT_LINK);
		return isElementDisplayed(driver, UserHomePageUI.LOGOUT_LINK);
	}

	public UserCustomerInfoPO clickMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserLoginPO clickLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	public void clickLogoutLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
		clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
	}

}