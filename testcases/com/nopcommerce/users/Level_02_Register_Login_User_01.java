package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Login_User_01 {
	WebDriver driver;
	Select select;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, companyName, password;
	AbstractPage abstractPage;
	
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
		
		abstractPage = new AbstractPage();
		
		
		firstName = "MyFirstName";
		lastName = "MyLastName";
		email = "imtester" + random()+ "@yopmail.com";
		companyName = "FPT telecom";
		password ="123456";
	}

	@Test
	public void TC_01_register() {
		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "15");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");
		
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", companyName);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		
		abstractPage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(abstractPage.getText(driver, "//div[@class='result']"), "Your registration completed");
		
		//firstlastname@yopmail.com
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		
		abstractPage.clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(abstractPage.isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(abstractPage.isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
  
	
	@Test(dependsOnMethods = "TC_02_login")
	public void TC_03_myAccount() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertFalse(abstractPage.isElementSelected(driver, "//input[@id='gender-female']"));
		
		Assert.assertEquals(abstractPage.getAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(abstractPage.getAttribute(driver, "//input[@id='LastName']", "value"), lastName);
		
		Assert.assertEquals(abstractPage.getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthDay']"), "15");
		Assert.assertEquals(abstractPage.getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthMonth']"), "May");
		Assert.assertEquals(abstractPage.getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthYear']"), "1990");
		
		
		Assert.assertEquals(abstractPage.getAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abstractPage.getAttribute(driver, "//input[@id='Company']", "value"), companyName);
		
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
	
}
