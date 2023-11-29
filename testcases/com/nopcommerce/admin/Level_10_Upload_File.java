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
import org.testng.annotations.AfterClass;

public class Level_10_Upload_File extends AbstractTest {
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
	public void TC_01_Upload_1_File() {		
		// Vào trang edit product
		productPage.clickToEditProductByName("Build your own computer");
		
		// Click vào section Multimedia
		//productPage.clickToSectionMultimedia();
		
		// Upload 1 file ảnh
		productPage.AddProductPicture("");
		
		// Verify ảnh hiển thị lên sau khi upload
		productPage.isFileUploadedInEditPage("");
		
		// Save -> go to Product page
		productPage.clickSaveButton();
		
		// Verify name/image name
		productPage.isFileUploadInProductPage("");
		
		// Vào lại trang edit
		productPage.clickToEditProductByName("Build your own computer");
		
		// Xóa image
		productPage.deleteImage();
		
		// verify ảnh bị xóa
		
		// Save -> go to Product page
		productPage.clickSaveButton();
		
		// verify lại ảnh đã bị xóa
		productPage.isDeletedFileSuccess("");
		
	}
	
	public void TC_02_Upload_Multiple_File() {		
		// Vào trang edit product
		
		// Upload nhiều file ảnh
		
		
		// Verify ảnh hiển thị lên sau khi upload
		
		// Save -> go to Product page
		
		// Verify name/image name
		
		// Vào lại trang edit
		
		// Xóa image
		
		// verify ảnh bị xóa
		
		// Save -> go to Product page
		
		// verify lại ảnh đã bị xóa
		
	}
  

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	AdminLoginPO loginPage;
	AdminDashBoardPO dashBoardPage;
	AdminProductPO productPage;
}

