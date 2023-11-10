package pageObjects.liveTechpanda;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveTechpanda.AdminHomePageUI;

public class AdminHomePO extends AbstractPage {
	WebDriver driver;
	
	public AdminHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClosePopup() {
		waitForElementClickable(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
	}
	
	public boolean isInfoDisplayedAtColumnNameAndRowNumber(String columnName, String rowIndex, String expectedValue) {
		int columnIndex = countElementSize(driver, AdminHomePageUI.COLUMN_NAME_SIBLING,columnName) + 1;
		String actualvalue = getText(driver, AdminHomePageUI.CELL_VALUE,rowIndex,String.valueOf(columnIndex));
		return actualvalue.contains(expectedValue);
	}
}