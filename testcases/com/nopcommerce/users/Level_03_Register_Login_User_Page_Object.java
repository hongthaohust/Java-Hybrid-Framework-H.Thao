package com.nopcommerce.users;

import org.testng.annotations.Test;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Register_Login_User_Page_Object {
	WebDriver driver;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, companyName, password;
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		firstName = "MyFirstName";
		lastName = "MyLastName";
		email = "imtester" + random()+ "@yopmail.com";
		companyName = "FPT telecom";
		password ="123456";	
	}

	@Test
	public void TC_01_register() {
		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();
		
		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickLogoutLink();
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		homePage = new HomePageObject(driver);
		homePage.clickLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputEmail(email);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLoginLinkDisplayed());
	}
  
	
	@Test(dependsOnMethods = "TC_02_login")
	public void TC_03_myAccount() {
		homePage.clickMyAccountLink();
		
		customerInfoPage = new CustomerInfoPageObject(driver);
		
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
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
	
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInfoPageObject customerInfoPage;
}
