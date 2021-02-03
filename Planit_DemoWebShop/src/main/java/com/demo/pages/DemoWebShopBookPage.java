package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopBookPage {

	WebDriver driver;

	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")
	WebElement homepage;
	@FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Books']")
	WebElement books;
	@FindBy(xpath = "//div[@class='product-item']//img[@title='Show details for Computing and Internet']")
	WebElement bookSelect;

	public DemoWebShopBookPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
// This method is for Selecting Books from Categories  
	public DemoWebShopBookPage bookSelection() {

		homepage.click();
		books.click();
		bookSelect.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		return new DemoWebShopBookPage(driver);

	}
}
