package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserBackInStockSubsPO;
import pageObjects.nopCommerce.UserChangePasswordPO;
import pageObjects.nopCommerce.UserCustomerInfoPO;
import pageObjects.nopCommerce.UserDownloadableProductPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRewardPointsPO;
import pageUIs.nopCommerce.AbstractPageUI;

public class AbstractPage {
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public Set<String> getWindowHandle(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		allWindows = driver.getWindowHandles();

		for (String currentWindow : allWindows) {
			driver.switchTo().window(currentWindow);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		allWindows = driver.getWindowHandles();
		for (String currentWindow : allWindows) {
			if (!currentWindow.equals(parentID)) {
				driver.switchTo().window(currentWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement getElement(WebDriver driver, String locator, String...values) {
		return driver.findElement(getByXpath(getDynamicLocator(locator, values)));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public List<WebElement> getElements(WebDriver driver, String locator, String... values) {
		return driver.findElements(getByXpath(getDynamicLocator(locator, values)));
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		element.click();
	}
	

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String...values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextIndropdown(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean dropdownIsMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

		childItems = getElements(driver, childLocator);

		for (WebElement actualItem : childItems) {
			if (actualItem.getText().trim().equals(expectItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", actualItem);
				sleepInSecond(1);

				actualItem.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getAttribute(WebDriver driver, String locator, String attribueName) {
		element = getElement(driver, locator);
		return element.getAttribute(attribueName);
	}
	
	public String getText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText();
	}
	
	public String getText(WebDriver driver, String locator, String...values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getText();
	}
	
	public String getCssValue(WebDriver driver, String locator, String propertyName) {
		element = getElement(driver, locator);
		return element.getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex().toUpperCase();
	}
	
	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public int countElementSize(WebDriver driver, String locator, String...values) {
		return getElements(driver, getDynamicLocator(locator, values)).size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckbox(WebDriver driver, String locator, String...value) {
		element = getElement(driver, getDynamicLocator(locator, value));
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String...values) {
		return getElement(driver, getDynamicLocator(locator, values)).isSelected();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator, String...values) {
		return getElement(driver, getDynamicLocator(locator, values)).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	public void doubleClickToElement(WebDriver driver, String locator, String...value) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, getDynamicLocator(locator, value))).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void clickAndHoldToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator),getElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator),key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String...values) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getDynamicLocator(String locator, String...values) {
		locator = String.format(locator, (Object[])values);
		return locator;
	}
	public String getDynamicLocatorInt(String locator, int...values) {
		locator = String.format(locator,values);
		return locator;
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String...values ) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator,values))));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String...values ) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator,values))));
	}
	
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator, String...values) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}
	
	public boolean waitToJQueryAndJSLoaded(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstans.LONG_TIMEOUT);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
				}
			};
			return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	// 8 hàm mở page
	public UserMyProductReviewPO openMyproductReview(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, AbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}
	
	public UserCustomerInfoPO openCustomerInfo(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, AbstractPageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
	
	public UserAddressesPO openAddressesPage(WebDriver driver) {
		waitForElementVisible(driver, AbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, AbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}
	
	public UserOrdersPO openOrders(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.ORDERS_LINK);
		clickToElement(driver, AbstractPageUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}
	
	public UserDownloadableProductPO openDownloadableProducts(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, AbstractPageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getUserDownloadableProductPage(driver);
	}
	
	public UserBackInStockSubsPO openBackInStockSubs(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		clickToElement(driver, AbstractPageUI.BACK_IN_STOCK_SUBSCRIPTIONS_LINK);
		return PageGeneratorManager.getUserBackInStockSubsPage(driver);
	}
	
	public UserRewardPointsPO openRewardPoints(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.REWARD_POINTS_LINK);
		clickToElement(driver, AbstractPageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointsPage(driver);
	}
	
	public UserChangePasswordPO openChangePassword(WebDriver driver) {
		waitForElementClickable(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, AbstractPageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPage(driver);
	}
	
	public AbstractPage openMenubarLink01(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		
		switch (pageName) {
		case "Customer info": {
			return PageGeneratorManager.getUserCustomerInfoPage(driver);
				}
		case "Addresses": {
			return PageGeneratorManager.getUserAddressesPage(driver);
		}
		case "Orders": {
			return PageGeneratorManager.getUserOrdersPage(driver);
				}
		case "Downloadable products": {
			return PageGeneratorManager.getUserDownloadableProductPage(driver);
		}
		case "Back in stock subscriptions": {
			return PageGeneratorManager.getUserBackInStockSubsPage(driver);
		}
		case "Reward points": {
			return PageGeneratorManager.getUserRewardPointsPage(driver);
		}
		case "Change password": {
			return PageGeneratorManager.getUserChangePasswordPage(driver);
		}
		case "My product reviews": {
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + pageName);
		}
	}
	
	public void openMenubarLink02(WebDriver driver, String pageName) {
		waitForElementClickable(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
	}
	
	public void waitAjaxLoadingInvisible(WebDriver driver) {
		waitForElementInvisible(driver, AbstractPageUI.LOADING_ICON);
	}
	public void waitProcessingBarInvisible(WebDriver driver, String imageName) {
		waitForElementInvisible(driver, AbstractPageUI.PROCESSING_BAR, imageName);
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private WebDriverWait explicitWait;
	private Actions action;
	private WebElement element;
	private Set<String> allWindows;
	private Select select;
	private List<WebElement> childItems;
}
