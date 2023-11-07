package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.GlobalConstans;
import pageUIs.AbstractPageUI;

public class AdminDashBoardPO extends AbstractPage {
	WebDriver driver;
	
	public AdminDashBoardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductPO openProductPage() {
		waitForElementClickable(driver, AbstractPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG);
		clickToElement(driver, AbstractPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG);
		clickToElement(driver, AbstractPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG); // Cho nay phai click 2 lan vao main-menu thi moi so xuong dropdown
		
		waitForElementClickable(driver, AbstractPageUI.SUB01_LINK_IN_SIDEBAR,GlobalConstans.ADMIN_MENU_CATALOG, GlobalConstans.ADMIN_MENU_PRODUCT);
		clickToElement(driver, AbstractPageUI.SUB01_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_CATALOG, GlobalConstans.ADMIN_MENU_PRODUCT);
		
		waitAjaxLoadingInvisible(driver);
		
		return PageGeneratorManager.getAdminProductPO(driver);
	}
}