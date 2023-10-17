package com.nopcommerce.users;

import org.testng.annotations.Test;

import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Register_Login_User_Multiple_Browser {
	WebDriver driver;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, companyName, password;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		} else {
//			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
//		}
		
		if(browserName.equals("firefox_ui")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(browserName.equals("chrome_ui")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox_headless")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless=new");
			options.addArguments("window-size=1920×1080");
			driver = new FirefoxDriver(options);
		} else if(browserName.equals("chrome_headless")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("window-size=1920×1080");
			driver = new ChromeDriver(options);
		} else if(browserName.equals("edge_chromium")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Please input browser value");
		}

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
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		registerPage.clickLoginLink();
		
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
