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

public class Level_02_Register_Login_User_02 extends AbstractPage {
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
		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "15");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "May");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1990");
		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", companyName);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);
		
		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getText(driver, "//div[@class='result']"), "Your registration completed");
		
		//firstlastname@yopmail.com
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		clickToElement(driver, "//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		
		clickToElement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
  
	
	@Test(dependsOnMethods = "TC_02_login")
	public void TC_03_myAccount() {
		clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertFalse(isElementSelected(driver, "//input[@id='gender-female']"));
		
		Assert.assertEquals(getAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getAttribute(driver, "//input[@id='LastName']", "value"), lastName);
		
		Assert.assertEquals(getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthDay']"), "15");
		Assert.assertEquals(getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthMonth']"), "May");
		Assert.assertEquals(getFirstSelectedTextIndropdown(driver, "//select[@name='DateOfBirthYear']"), "1990");
		
		
		Assert.assertEquals(getAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getAttribute(driver, "//input[@id='Company']", "value"), companyName);
		
		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));
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
