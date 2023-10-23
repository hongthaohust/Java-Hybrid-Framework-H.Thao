package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Register_Login_User_Page_Generator_Manager extends AbstractTest {
	WebDriver driver;
	Select select;
	String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, companyName, password;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "MyFirstName";
		lastName = "MyLastName";
		email = "imtester" + random()+ "@yopmail.com";
		companyName = "FPT telecom";
		password ="123456";	
	}

	@Test
	public void TC_01_register() {
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = homePage.clickRegisterLink();
				
		registerPage.clickGenderRadio();
		registerPage.inputFirstName(firstName);
		registerPage.inputLastName(lastName);
		
		registerPage.selectDay("15");
		registerPage.selectMonth("May");
		registerPage.selectYear("1990");
		
		registerPage.inputEmail(email);
		registerPage.inputCompany(companyName);
		registerPage.inputPassword(password);
		registerPage.inputConfirmPassword(password);
		
		registerPage.clickRegisterButton();
		
		Assert.assertEquals(registerPage.getSuccessText(), "Your registration completed");
		
		
		//homePage = registerPage.clickLogoutLink();
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		//loginPage = homePage.clickLoginLink();
		
		loginPage = registerPage.clickLoginLink();
		
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		homePage = loginPage.clickLoginButton();
		
		Assert.assertTrue(homePage.isAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}
  
	
	@Test(dependsOnMethods = "TC_02_login")
	public void TC_03_myAccount() {
		customerInfoPage = homePage.clickMyAccountLink();
				
		Assert.assertTrue(customerInfoPage.isGenderMaleSelected());
		Assert.assertTrue(customerInfoPage.isGenderFemaleUnselected());
		
		Assert.assertEquals(customerInfoPage.getFirstName(), firstName);
		Assert.assertEquals(customerInfoPage.getLastName(), lastName);
		
		Assert.assertEquals(customerInfoPage.getDateOfBirthDay(), "15");
		Assert.assertEquals(customerInfoPage.getDateOfBirthMonth(), "May");
		Assert.assertEquals(customerInfoPage.getDateOfBirthYear(), "1990");
		
		Assert.assertEquals(customerInfoPage.getEmail(), email);
		Assert.assertEquals(customerInfoPage.getCompanyName(), companyName);
		
		Assert.assertTrue(customerInfoPage.isNewsletterSelected());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
}
