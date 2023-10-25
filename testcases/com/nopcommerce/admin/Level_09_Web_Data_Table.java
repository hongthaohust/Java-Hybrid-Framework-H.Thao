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
	public void TC_01_Data_Table_List_Products() {
		
	}
  
	public void TC_02_login() {
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductPO productPage;
}
