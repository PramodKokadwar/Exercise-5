package com.capmo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capmo.qa.base.TestBase;

public class YourCartPage extends TestBase {
	
	

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement checkOutButton;
	
	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShopping;
	
	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement continueShopping;
	
	 
	// Initializing the Page Objects:
		public YourCartPage() {
			PageFactory.initElements(driver, this);
		}
		
		
		
		
		
}
