package com.nopcommerce.admin;

import org.testng.annotations.Test;

import commons.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
	}

	@Test
	public void TC_01_register() {
		
	}
  
	public void TC_02_login() {
	}
	
	public void TC_03_myAccount() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
