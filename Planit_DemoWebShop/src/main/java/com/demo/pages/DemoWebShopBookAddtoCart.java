package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopBookAddtoCart {

	WebDriver driver;
	String bookPrice;
	String expMessage;
	String actualMessage;
	String cartValue;

	@FindBy(xpath = "//input[@id='addtocart_13_EnteredQuantity']")
	WebElement bookQuantity;
	@FindBy(xpath = "//input[@id='add-to-cart-button-13']")
	WebElement bookaddtocart;
	@FindBy(xpath = "//li[@id=\"topcartlink\"]/a/span[1]")
	WebElement shippingCart;
	@FindBy(xpath = "//p[@class='content']")
	WebElement cartMessage;
	@FindBy(xpath = "//li[@id=\"topcartlink\"]/a/span[1]")
	WebElement cartValueElement;

	public DemoWebShopBookAddtoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// This method is for selecting the book from the list displayed and get the price details and book is adding to cart
	// and Validating “The product has been added to shopping cart” message
	public DemoWebShopBookAddtoCart bookAddtocart() throws InterruptedException {

		bookPrice = driver.findElement(By.xpath("//span[@class='price-value-13']")).getText();
		System.out.println("Bookrice =" +bookPrice);
		bookQuantity.click();
		bookQuantity.clear();
		bookQuantity.sendKeys("3");
		bookaddtocart.click();

		Thread.sleep(5000);

		expMessage = "The product has been added to your shopping cart";
		actualMessage = cartMessage.getText();

		String cartValue = cartValueElement.getText();

		// Assert.assertEquals(actualMessage, expMessage, "The product has been added to your shopping cart");
		System.out.println("Cart Quantity after book selection" + cartValue);
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		jsc.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
		shippingCart.click();

		return new DemoWebShopBookAddtoCart(driver);

	}
}
