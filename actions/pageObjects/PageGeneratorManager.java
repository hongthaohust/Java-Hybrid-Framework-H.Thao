package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserDownloadableProductPO getUserDownloadableProductPage(WebDriver driver) {
		return new UserDownloadableProductPO(driver);
	}
	
	public static UserBackInStockSubsPO getUserBackInStockSubsPage(WebDriver driver) {
		return new UserBackInStockSubsPO(driver);
	}
	
	public static UserRewardPointsPO getUserRewardPointsPage(WebDriver driver) {
		return new UserRewardPointsPO(driver);
	}
	
	public static UserChangePasswordPO getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPO(driver);
	}
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	
	public static AdminDashBoardPO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPO(driver);
	}

	public static AdminProductPO getAdminProductPO(WebDriver driver) {
		return new AdminProductPO(driver);
	}
}
