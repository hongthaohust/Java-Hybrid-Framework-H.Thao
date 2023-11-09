package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);
	}
	public static AdminHomePO getAdminHomePage(WebDriver driver) {
		return new AdminHomePO(driver);
	}
	
}
