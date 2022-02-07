package com.capmo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.capmo.qa.base.TestBase;
import com.capmo.qa.pages.HomePage;
import com.capmo.qa.pages.LoginPage;
import com.capmo.qa.util.TestUtil;

public class CapmoLoginTest extends TestBase {
	
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public CapmoLoginTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();	 
	}
	

	@Test
	public void verifyHomePageTitleTest() throws InterruptedException {

		// Verify title of home page
		String homePageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(homePageTitle, "Swag Labs",
				"Login Page title not matched");
	}
	
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException {

		
		loginPage.doLogin("standard_user", "secret_sauce");
		// verify login is successfully.

		// Verify is successfully login or not
		loginPage.verifyLoginIsSuccessful();
	}
	
	@Test
	public void verifyLoginWithInValidCredentials() throws InterruptedException {

		
		loginPage.doLogin("standard", "secret");
		
		// Verify assertion to verify error message
		Assert.assertEquals(loginPage.verifyErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
				"Login Page title not matched");
	 
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	
}
