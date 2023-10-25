package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.GlobalConstans;
import pageUIs.AdminDashBoardPageUI;

public class AdminDashBoardPO extends AbstractPage {
	WebDriver driver;
	
	public AdminDashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		waitForElementClickable(driver, AdminDashBoardPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG);
		clickToElement(driver, AdminDashBoardPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG);
		
		waitForElementClickable(driver, AdminDashBoardPageUI.SUB01_LINK_IN_SIDEBAR,GlobalConstans.ADMIN_MENU_CATALOG, GlobalConstans.ADMIN_MENU_PRODUCT);
		clickToElement(driver, AdminDashBoardPageUI.SUB01_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG, GlobalConstans.ADMIN_MENU_PRODUCT);
		return PageGeneratorManager.getAdminProductPO(driver);
	}
}