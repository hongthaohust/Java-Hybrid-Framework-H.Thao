package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashBoardPO;
import pageObjects.AdminLoginPO;
import pageObjects.AdminProductPO;
import pageObjects.PageGeneratorManager;

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
  
	@Test
	public void TC_02_Select_Deselect_All_Item() {
		productPage.checkToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxChecked());
		
		productPage.unCheckToSelectAllCheckbox();
		Assert.assertTrue(productPage.areProductCheckboxUnChecked());
		
		productPage.checkToProductCheckboxByName("Apple MacBook Pro 13-inch");
	}
	
	@Test
	public void TC_03_Check_Display() {
		
	}

	@Test
	public void TC_04_Edit() {
	
}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductPO productPage;
}

