package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.UserAddressesPO;
import pageObjects.UserBackInStockSubsPO;
import pageObjects.UserChangePasswordPO;
import pageObjects.UserCustomerInfoPO;
import pageObjects.UserDownloadableProductPO;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserMyProductReviewPO;
import pageObjects.UserOrdersPO;
import pageObjects.UserPageGeneratorManager;
import pageObjects.UserRegisterPO;
import pageObjects.UserRewardPointsPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_08_Register_Login_User_Rest_Parameter extends AbstractTest {
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
		homePage = UserPageGeneratorManager.getHomePage(driver);
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
	
	@Test (dependsOnMethods = "TC_03_myAccount")
	public void TC_04_Rest_Parameter_C1() {
		
		addressesPage = (UserAddressesPO) customerInfoPage.openMenubarLink01(driver,"Addresses"); // vào trang address
		
		customerInfoPage = (UserCustomerInfoPO) addressesPage.openMenubarLink01(driver, "Customer info"); // vào trang customer info
		
		orderPage = (UserOrdersPO) customerInfoPage.openMenubarLink01(driver,"Orders"); // vào trang orders
		
		customerInfoPage = (UserCustomerInfoPO) orderPage.openMenubarLink01(driver, "Customer info"); // vào trang customer info
		
		myProductPage = (UserMyProductReviewPO) customerInfoPage.openMenubarLink01(driver, "My product reviews"); // vào trang my product reciew
		
		customerInfoPage = (UserCustomerInfoPO) myProductPage.openMenubarLink01(driver, "Customer info"); // vào trang customer info
	}
	
	@Test (dependsOnMethods = "TC_03_myAccount")
	public void TC_05_Rest_Parameter_C2() {
		
		customerInfoPage.openMenubarLink02(driver,"Addresses"); // vào trang address
		addressesPage = UserPageGeneratorManager.getAddressesPage(driver);
		
		addressesPage.openMenubarLink02(driver, "Customer info"); // vào trang customer info
		customerInfoPage = UserPageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInfoPage.openMenubarLink02(driver,"Orders"); // vào trang orders
		orderPage = UserPageGeneratorManager.getOrdersPage(driver);
		
		orderPage.openMenubarLink02(driver, "Customer info"); // vào trang customer info
		customerInfoPage = UserPageGeneratorManager.getCustomerInfoPage(driver);
		
		customerInfoPage.openMenubarLink02(driver, "My product reviews"); // vào trang my product reciew
		myProductPage = UserPageGeneratorManager.getMyProductReviewPage(driver);
		
		myProductPage.openMenubarLink02(driver, "Customer info"); // vào trang customer info
		customerInfoPage = UserPageGeneratorManager.getCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInfoPO customerInfoPage;
	UserAddressesPO addressesPage;
	UserOrdersPO orderPage;
	UserMyProductReviewPO myProductPage;
	UserDownloadableProductPO downloadableProductPage;
	UserBackInStockSubsPO backInStockSubsPage;
	UserRewardPointsPO rewardPointPage;
	UserChangePasswordPO changePasswordPage;
}
