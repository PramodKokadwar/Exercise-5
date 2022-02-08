package com.capmo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.capmo.qa.base.TestBase;
import com.capmo.qa.pages.CheckOutPage;
import com.capmo.qa.pages.HomePage;
import com.capmo.qa.pages.LoginPage;
import com.capmo.qa.pages.YourCartPage;
import com.capmo.qa.util.TestUtil;

public class CapmoEndToEndTest extends TestBase {
	
	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	CheckOutPage checkOutPage;
	YourCartPage yourCartPage;
	
	public CapmoEndToEndTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		checkOutPage = new CheckOutPage();
		yourCartPage = new YourCartPage();
	}
	
	@Test
	public void campoEndToEndTest() throws InterruptedException {

		Thread.sleep(1000);
		
		loginPage.doLogin("standard_user", "secret_sauce");
		// verify login is successfully.

		// Verify is successfully login or not
		loginPage.verifyLoginIsSuccessful();
		
		// add min item in the card
		homePage.addMinPriceItem();
		
		// Click on Checkout button
		yourCartPage.clickOnCheckoutButton();
		
		//Enter your details in your information fields and click on finshed
		checkOutPage.yourInformationForm("Pramod", "Kokadwar", "10115");
		
		// Verify order is placed successfully 
		checkOutPage.verifyOrderConfirmationMessage();
		
		// perform logout 
		homePage.Logout();
		 
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	

}
