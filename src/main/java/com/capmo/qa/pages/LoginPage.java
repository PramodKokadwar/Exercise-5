package com.capmo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capmo.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginBtn;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement loginErrorMsg;
	
	


	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}


	public HomePage doLogin(String user, String pwd)
	{
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
