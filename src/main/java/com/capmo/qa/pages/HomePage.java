package com.capmo.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 

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

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement productFilter;


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	public void filterSearchbox(String filterName)
	{
		Select dropdown = new Select(driver.findElement(By.xpath("productFilter")));  
		dropdown.selectByValue("lohi");
	}



	public void addMaxPriceItem()
	{


		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));

		double maxPrice =    priceList
				.stream()
				.mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.max()
				.getAsDouble();


		String xpath = "//div[normalize-space()='$"+maxPrice+"']/following-sibling::button[text()='Add to cart']";

		driver.findElement(By.xpath(xpath)).click();

	}

	public void addMinPriceItem()
	{
		List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));

		double minPrice =    priceList
				.stream()
				.mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.min()
				.getAsDouble();


		String xpath = "//div[normalize-space()='$"+minPrice+"']/following-sibling::button[text()='Add to cart']";

		driver.findElement(By.xpath(xpath)).click();

	}

	public void Logout()
	{
		burgerMenuBtn.click();

		logoutLink.click();

	}



}

