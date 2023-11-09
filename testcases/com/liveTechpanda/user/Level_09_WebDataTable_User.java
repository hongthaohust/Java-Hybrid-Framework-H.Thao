package com.liveTechpanda.user;

import org.testng.annotations.Test;

import com.liveTechpanda.user_data.User_Infomation_Register;

import commons.AbstractTest;
import pageObjects.liveTechpanda.UserHomePO;
import pageObjects.liveTechpanda.UserRegisterPO;
import pageObjects.liveTechpanda.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_09_WebDataTable_User extends AbstractTest {
	WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}
	
	@Test
	public void TC_01_Register() {	
		registerPage = homePage.clickRegisterLink();
		registerPage.isTextDisplayed();
		homePage = registerPage.registerToSystem(User_Infomation_Register.FIRST_NAME, User_Infomation_Register.MIDDLE_NAME, User_Infomation_Register.LAST_NAME, User_Infomation_Register.EMAIL, User_Infomation_Register.PASSWORD, User_Infomation_Register.CONFIRM_PASSWORD);
		homePage.isRegisterSuccess();
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	UserRegisterPO registerPage;
	UserHomePO homePage;
}
