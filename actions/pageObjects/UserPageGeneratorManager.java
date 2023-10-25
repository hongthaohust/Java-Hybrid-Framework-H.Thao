package pageObjects;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManager {
	public static UserLoginPO getLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInfoPO getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	
	public static UserAddressesPO getAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserOrdersPO getOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserMyProductReviewPO getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserDownloadableProductPO getDownloadableProductPage(WebDriver driver) {
		return new UserDownloadableProductPO(driver);
	}
	
	public static UserBackInStockSubsPO getBackInStockSubsPage(WebDriver driver) {
		return new UserBackInStockSubsPO(driver);
	}
	
	public static UserRewardPointsPO getRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPO(driver);
	}
	
	public static UserChangePasswordPO getChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);
	}
}
