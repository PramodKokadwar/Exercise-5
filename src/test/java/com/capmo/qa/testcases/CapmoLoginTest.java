package com.capmo.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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


	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();	 
	}
	
	
	
	@Test(priority = 2)
	public void verifyHomePageTitleTest() throws InterruptedException {

		// Verify title of home page
		String homePageTitle = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(homePageTitle, "Swag Labs",
				"Login Page title not matched");
	}
	
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() throws InterruptedException {

		
		loginPage.doLogin("standard_user", "secret_sauce");
	 
	}
	
	@Test(priority = 1)
	public void verifyLoginWithInValidCredentials() throws InterruptedException {

		
		loginPage.doLogin("standard", "secret");
	 
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}


	
}
