package pageObjects.nopCommerce;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import commons.GlobalConstans;
import pageUIs.nopCommerce.AbstractPageUI;
import pageUIs.nopCommerce.AdminProductPageUI;

public class AdminProductPO extends AbstractPage {
	WebDriver driver;
	
	public AdminProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void goToPageByIndex(String indexPage) {
		waitForElementClickable(driver, AdminProductPageUI.PAGING_NUMBER, indexPage);
		clickToElement(driver, AdminProductPageUI.PAGING_NUMBER, indexPage);
		waitAjaxLoadingInvisible(driver);
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

	public AdminDashBoardPO openDashBoardPage() {
		waitForElementClickable(driver, AbstractPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_DASHBOARD);
		clickToElement(driver, AbstractPageUI.MAIN_LINK_IN_SIDEBAR, GlobalConstans.ADMIN_MENU_DASHBOARD);
		
		sleepInSecond(5);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}

	public boolean areProductDetailDisplayed(String productName, String skuID, String price, String quantity,
			String publishStatus) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName,skuID,price,quantity,publishStatus);
		return isElementDisplayed(driver, AdminProductPageUI.PRODUCT_DETAIL_IN_TABLE, productName,skuID,price,quantity,publishStatus);
	}

	public void selectNumberItemDropdown(String itemNumber) {
		waitForElementClickable(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductPageUI.SHOW_NUMBER_ITEM_DROPDOWN,itemNumber);
		waitAjaxLoadingInvisible(driver);
	}

	public boolean isInfoDisplayedAtColumnNameAndRowNumber(String columnName, String rowIndex, String expectedValue) {
		int columnIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName) + 1;
		String actualvalue = getText(driver, AdminProductPageUI.CELL_VALUE,rowIndex,String.valueOf(columnIndex));
		return actualvalue.equals(expectedValue);
	}

	public boolean isPublishStatus(String columnName, String rowIndex, String publishStatus) {
		int columnIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING,columnName) + 1;
		return isElementDisplayed(driver, AdminProductPageUI.PUBLISH_STATUS,rowIndex,String.valueOf(columnIndex),publishStatus);
	}

	public void clickToEditProductByName(String productName) {
		waitForElementClickable(driver, AdminProductPageUI.EDIT_PRODUCT, productName);
		clickToElement(driver, AdminProductPageUI.EDIT_PRODUCT, productName);
		waitAjaxLoadingInvisible(driver);
	}

	
	// Hàm lấy dữ liệu này đang có lỗi khi click tại page mới thì load lại trang nên element bị thay đổi trong DOM
	public List<String> getAllValueByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		List<WebElement> allPageLinks = getElements(driver, AdminProductPageUI.ALL_PAGE_LINK);
		
		int columnIndex = countElementSize(driver, AdminProductPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		
		for(WebElement pageLink : allPageLinks) {
			pageLink.click();
			List<WebElement> allRowValues = getElements(driver, AdminProductPageUI.ALL_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			
			for(WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
			}
		}
		
		return allValues;
	}
	
	
	public void AddProductPicture(String image_path) {
		sendkeyToElement(driver, AdminProductPageUI.UPLOAD_FILE_BUTTON, image_path);
		waitProcessingBarInvisible(driver,image_path);
	}
	public void AddProductPictureMultiple(String image_path) {
		sendkeyToElement(driver, AdminProductPageUI.UPLOAD_FILE_BUTTON, image_path);
		waitProcessingBarInvisible(driver,image_path);
	}
	public void VerifyPictureUploadedInEditPage(String image_path) {
		sendkeyToElement(driver, AdminProductPageUI.UPLOAD_FILE_BUTTON, image_path);
		waitProcessingBarInvisible(driver,image_path);
	}
	public void VerifyPictureUploadedInProductPage(String image_path) {
		sendkeyToElement(driver, AdminProductPageUI.UPLOAD_FILE_BUTTON, image_path);
		waitProcessingBarInvisible(driver,image_path);
	}

	public void isFileUploadedInEditPage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void clickToSectionMultimedia() {
		// TODO Auto-generated method stub
		
	}

	public void clickSaveButton() {
		// TODO Auto-generated method stub
		
	}

	public void isFileUploadInProductPage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void deleteImage() {
		// TODO Auto-generated method stub
		
	}
		
}