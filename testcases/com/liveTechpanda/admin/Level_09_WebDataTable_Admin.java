package com.liveTechpanda.admin;

import org.testng.annotations.Test;

import com.liveTechpanda.user_data.User_Infomation_Register;

import commons.AbstractTest;
import pageObjects.liveTechpanda.AdminHomePO;
import pageObjects.liveTechpanda.AdminLoginPO;
import pageObjects.liveTechpanda.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_09_WebDataTable_Admin extends AbstractTest {
	WebDriver driver;
	
	String username = "user01";
	String password = "guru99com";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		loginPage = PageGeneratorManager.getAdminLoginPage(driver);
	}
	
	@Test
	public void TC_01_Verify_User_Info_After_Register() {	
		homePage = loginPage.loginToSystem(username,password);
		homePage.clickClosePopup();
		
		homePage.isInfoDisplayedAtColumnNameAndRowNumber("Name", "1", User_Infomation_Register.FIRST_NAME);
		homePage.isInfoDisplayedAtColumnNameAndRowNumber("Name", "1", User_Infomation_Register.LAST_NAME);
		homePage.isInfoDisplayedAtColumnNameAndRowNumber("Name", "1", User_Infomation_Register.MIDDLE_NAME);
		homePage.isInfoDisplayedAtColumnNameAndRowNumber("Email", "1", User_Infomation_Register.EMAIL);	
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	AdminLoginPO loginPage;
	AdminHomePO homePage;
}
