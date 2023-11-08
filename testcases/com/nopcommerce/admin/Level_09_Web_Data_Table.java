package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminDashBoardPO;
import pageObjects.nopCommerce.AdminLoginPO;
import pageObjects.nopCommerce.AdminProductPO;
import pageObjects.nopCommerce.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;
	
	String email = "admin@yourstore.com";
	String password = "admin";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		dashBoardPage = loginPage.loginToSystem(email, password);
		
		productPage = dashBoardPage.openProductPage();
	}
	
	@Test
	public void TC_01_Paging() {		
		// Paging
		productPage.goToPageByIndex("2");
		Assert.assertTrue(productPage.isActivePageByIndex("2"));
		
		productPage.goToPageByIndex("1");
		Assert.assertTrue(productPage.isActivePageByIndex("1"));
		
		productPage.goToPageByIndex("3");
		Assert.assertTrue(productPage.isActivePageByIndex("3"));
		
		productPage.goToPageByIndex("1");
		Assert.assertTrue(productPage.isActivePageByIndex("1"));
	}
  
	
	public void TC_02_Select_Deselect_All_Item() {
		productPage.checkToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxChecked());
		
		productPage.unCheckToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxUnChecked());
		
		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
		productPage.checkToProductCheckboxByName("Build your own computer");
		productPage.checkToProductCheckboxByName("Adobe Photoshop CS4");
		
	}

	
	public void TC_03_Check_Display() {
		Assert.assertTrue(productPage.areProductDetailDisplayed("Build your own computer","COMP_CUST","1208","10000","true"));
		Assert.assertTrue(productPage.areProductDetailDisplayed("Lenovo IdeaCentre 600 All-in-One PC","LE_IC_600","500","10000","true"));		
		productPage.selectNumberItemDropdown("100");
		Assert.assertTrue(productPage.areProductDetailDisplayed("Vintage Style Engagement Ring","VS_ENG_RN","2100","10000","false"));
	}

	
	public void TC_04_Edit() {
		productPage.clickToEditProductByName("Build your own computer");
		productPage.backToPage(driver);
		
		productPage.clickToEditProductByName("Lenovo IdeaCentre 600 All-in-One PC");
		productPage.backToPage(driver);
		
		productPage.clickToEditProductByName("Nikon D5500 DSLR - Black");
		productPage.backToPage(driver);
	}
	
	
	public void TC_05_Position() {
		productPage.selectNumberItemDropdown("50");
		Assert.assertTrue(productPage.isInfoDisplayedAtColumnNameAndRowNumber("Product name","2","Digital Storm VANQUISH 3 Custom Performance PC"));
		Assert.assertTrue(productPage.isInfoDisplayedAtColumnNameAndRowNumber("SKU","3","LE_IC_600"));
		Assert.assertTrue(productPage.isInfoDisplayedAtColumnNameAndRowNumber("Price","13",""));
		Assert.assertTrue(productPage.isPublishStatus("Published","5","true"));
		Assert.assertTrue(productPage.isPublishStatus("Published","5","true"));
	}
	
	
	public void TC_06_GetAllValue() {
		System.out.println(productPage.getAllValueByColumnName("Product name"));
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductPO productPage;
}

