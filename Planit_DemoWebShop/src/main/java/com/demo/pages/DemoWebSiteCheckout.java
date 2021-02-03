package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoWebSiteCheckout {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement checkbox;
	@FindBy(xpath = "//button[normalize-space()='Checkout']")
	WebElement checkoutbutton;
	@FindBy(xpath = "//*[@class='product-price']")
	WebElement subTotalElement;

	@FindBy(xpath = "//*[@class='product-price order-total']")
	WebElement TotalElement;

	public DemoWebSiteCheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// This method is for sub total and total values and clicking checkout  
	public DemoWebSiteCheckout checkout() {

		String subTotal = subTotalElement.getText();
		System.out.println("Subtotal =" + subTotal);
		String TotalAmount = TotalElement.getText();
		System.out.println("TotalAmount =" + TotalAmount);

		Assert.assertEquals(TotalAmount, subTotal);
		System.out.println("validated the “Sub-Total” Price for selected book");
		checkbox.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		checkoutbutton.click();
		return new DemoWebSiteCheckout(driver);
	}

}
