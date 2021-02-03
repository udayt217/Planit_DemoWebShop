package com.demo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DemoWebShopLoginPage {

	WebDriver driver;
	String expValueForSignIn;
	String actualValueSignIn;
	String expectedValueID;
	String actualValueID;
	String quantity;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement username;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;

	@FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
	WebElement validate;
	@FindBy(xpath = "//a[contains(text(),'atest@gmail.com')]")
	WebElement loginValidate;
	@FindBy(xpath = "//span[@class='cart-qty']")
	WebElement cartQuantity;
	
	public DemoWebShopLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// This is method is for login demo web shop and validating welcome message and validating user account id
	public DemoWebShopLoginPage Login() throws IOException {

		expValueForSignIn = "Welcome, Please Sign In!";
		actualValueSignIn = validate.getText();
		Assert.assertEquals(actualValueSignIn, expValueForSignIn, "Welcome, Please Sign In!” message Validated");
		System.out.println("Welcome, Please Sign In!” message Validated");
		username.sendKeys("atest@gmail.com");
		password.sendKeys("123456");       
		loginButton.click();
		expectedValueID = "atest@gmail.com";
		actualValueID = loginValidate.getText();
		Assert.assertEquals(actualValueID, expectedValueID, "the user account ID has been Validated");
		System.out.println("the user account ID has been Validated");
		quantity=cartQuantity.getText();
		System.out.println("Cart Quantity after login"+quantity);
		
		return new DemoWebShopLoginPage(driver);

	}

}