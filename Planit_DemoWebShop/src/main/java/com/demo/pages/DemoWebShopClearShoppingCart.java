package com.demo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopClearShoppingCart {
	WebDriver driver;

	@FindBy(xpath = "//li[@id=\"topcartlink\"]/a/span[2]")
	WebElement CartQuantity;

	@FindBy(xpath = "//input[@name='updatecart']")
	WebElement updateCart;

	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")
	WebElement homePage;

	public DemoWebShopClearShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
// This method is for clearing the shopping cart
	public DemoWebShopClearShoppingCart ClearSHoppingCart() {

		driver.findElement(By.xpath("//li[@id=\"topcartlink\"]/a/span[2]")).click();
		List<WebElement> totalCheckbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		System.out.println("Total Checkboxes =" + totalCheckbox.size());
		if (totalCheckbox.size() != 0) {
			for (WebElement allCheck : totalCheckbox) {
				allCheck.click();
				System.out.println("All checkboxes has been clicked");
			}
			updateCart.click();
			System.out.println("Cart has been Cleared");
			String cartValue = CartQuantity.getText();
			System.out.println("Cart quantity after clearig" + cartValue);
			homePage.click();
		} else {
			System.out.println("Cart Value 0");
		}

		return new DemoWebShopClearShoppingCart(driver);

	}
}