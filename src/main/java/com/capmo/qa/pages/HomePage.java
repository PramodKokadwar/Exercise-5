package com.capmo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capmo.qa.base.TestBase;

public class HomePage extends TestBase {
	 
	
	@FindBy(id ="shopping_cart_container")
	WebElement shoppingCart;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement burgerMenuBtn;
	
	@FindBy(xpath = "//button[@id='react-burger-cross-btn']")
	WebElement burgerMenuCloseBtn;
	
	@FindBy(xpath = "//a[@id='inventory_sidebar_link']")
	WebElement allItemLink;
	
	@FindBy(xpath = "//a[@id='about_sidebar_link']")
	WebElement aboutLink;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutLink;
	
	@FindBy(xpath = "//a[@id='reset_sidebar_link']")
	WebElement resetLink;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	
	
	
	
	
}
