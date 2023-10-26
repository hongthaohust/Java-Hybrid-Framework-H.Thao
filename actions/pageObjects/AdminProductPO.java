package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;
	
	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageByIndex(String indexPage) {
		waitForElementClickable(driver, AdminProductPageUI.PAGING_NUMBER, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_NUMBER, indexPage);
	}

	public boolean isActivePageByIndex(String indexPage) {
		waitForElementVisible(driver, AdminProductPageUI.PAGING_NUMBER_ACTIVE, indexPage);
		return isElementDisplayed(driver, AdminProductPageUI.PAGING_NUMBER_ACTIVE, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		checkToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public void unCheckToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
		uncheckToCheckbox(driver, AdminProductPageUI.SELECT_ALL_CHECKBOX);
	}

	public boolean areProductCheckboxChecked() {
		boolean status = true;
		List<WebElement> allProductCheckbox = getElements(driver, AdminProductPageUI.GROUPS_CHECKBOX_ON_PAGE);
		for (WebElement productCheckbox : allProductCheckbox) {
			if (!productCheckbox.isSelected()) {
				status = false;
				return status;
			}
		}
		return status;
	}

	public boolean areProductCheckboxUnChecked() {
		boolean status = true;
		List<WebElement> allProductCheckbox = getElements(driver, AdminProductPageUI.GROUPS_CHECKBOX_ON_PAGE);
		for (WebElement productCheckbox : allProductCheckbox) {
			if (productCheckbox.isSelected()) {
				status = false;
				return status;
			}
		}
		return status;
	}

	public void checkToProductCheckboxByName(String productName) {
		waitForElementClickable(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
		checkToCheckbox(driver, AdminProductPageUI.PRODUCT_CHECKBOX_BY_NAME, productName);
	}
}