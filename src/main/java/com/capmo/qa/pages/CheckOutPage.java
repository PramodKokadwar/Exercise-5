package com.capmo.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.capmo.qa.base.TestBase;

public class CheckOutPage extends TestBase {
	
	
	@FindBy(id = "first-name")
	WebElement inputFirstName;
	
	@FindBy(id = "last-name")
	WebElement inputLastName;
	
	@FindBy(id = "postal-code")
	WebElement inputPostalCode;
	
	
	@FindBy(xpath = "//button[@id='cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(xpath = "//button[@id='finish']")
	WebElement finishBtn;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement completeHeader;
	
	@FindBy(xpath = "//div[@class='complete-text']")
	WebElement completeText;
	
	

	// Initializing the Page Objects:
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
 
	
	
	public CheckOutPage yourInformationForm(String firstname, String lastname, String postcode)
	{
		inputFirstName.sendKeys(firstname);
		inputLastName.sendKeys(lastname);
		inputPostalCode.sendKeys(postcode);
		
		continueBtn.click();
		
		return new CheckOutPage();
	}
	
	
	

}
