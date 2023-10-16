package commons;

import java.time.Duration;
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
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String currentWindow : allWindows) {
			driver.switchTo().window(currentWindow);
			String currentTitle = driver.getTitle();
			if (currentTitle.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
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

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextIndropdown(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean dropdownIsMultiple(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait expliciWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));

		List<WebElement> childItems = getElements(driver, childLocator);

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
		WebElement element = getElement(driver, locator);
		return element.getAttribute(attribueName);
	}
	
	public String getText(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		return element.getText();
	}
	
	public String getCssValue(WebDriver driver, String locator, String propertyName) {
		WebElement element = getElement(driver, locator);
		return element.getCssValue(propertyName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex().toUpperCase();
	}
	
	public int countElementSize(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	
	public void clickAndHoldToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator),getElement(driver, targetLocator)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
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
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
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
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForElementPresence(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
