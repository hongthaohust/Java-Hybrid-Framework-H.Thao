package com.liveTechpanda.user;

import org.testng.annotations.Test;

import commons.AbstractTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_09_WebDataTable extends AbstractTest {
	WebDriver driver;
	
	String email = "admin@yourstore.com";
	String password = "admin";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
	}
	
	@Test
	public void TC_01_Register() {		
		// Paging
		
	}
  
	

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
