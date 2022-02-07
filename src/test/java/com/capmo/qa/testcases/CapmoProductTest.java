package com.capmo.qa.testcases;

 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capmo.qa.base.TestBase;
import com.capmo.qa.pages.HomePage;
import com.capmo.qa.pages.LoginPage;
import com.capmo.qa.util.TestUtil;

public class CapmoProductTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public CapmoProductTest() {
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
	public void addMaxItemIntheCartAndVerify() throws InterruptedException {

		Thread.sleep(1000);
		
		loginPage.doLogin("standard_user", "secret_sauce");
		// verify login is successfully.

		// Verify is successfully login or not
		loginPage.verifyLoginIsSuccessful();
		
		// add max item in the card
		homePage.addMaxPriceItem();
		
		Thread.sleep(1000);
		
		homePage.Logout();
	}
	
	
	@Test
	public void addMinItemIntheCartAndVerify() throws InterruptedException {

		Thread.sleep(1000);
		
		loginPage.doLogin("standard_user", "secret_sauce");
		// verify login is successfully.

		// Verify is successfully login or not
		loginPage.verifyLoginIsSuccessful();
		
		// add min item in the card
		homePage.addMinPriceItem();
		
		Thread.sleep(1000);
		
		homePage.Logout();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	

}
