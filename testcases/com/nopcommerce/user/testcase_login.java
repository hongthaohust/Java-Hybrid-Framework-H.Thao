package com.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class testcase_login {
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
		driver.findElement(By.className("ico-register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText("15");
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText("May");
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText("1990");
		
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(companyName);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		
		driver.findElement(By.id("register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector(".page-body .result")).getText(), "Your registration completed");
	}
  
	@Test (dependsOnMethods = "TC_01_register")
	public void TC_02_login() {
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys(password);
		
		driver.findElement(By.cssSelector(".login-button")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-account")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(".ico-logout")).isDisplayed());
	}
  
	@Test
	public void TC_03_myAccount() {
		driver.findElement(By.cssSelector(".ico-account")).click();
		
		Assert.assertTrue(driver.findElement(By.id("gender-male")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("gender-female")).isEnabled());
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getText(), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getText(), lastName);
		
		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption(), "15");
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption(), "May");
		
		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption(), "1990");
		
		Assert.assertEquals(driver.findElement(By.id("Email")).getText(), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getText(), companyName);
		
	}

	@AfterClass
	public void afterClass() {
	}
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
