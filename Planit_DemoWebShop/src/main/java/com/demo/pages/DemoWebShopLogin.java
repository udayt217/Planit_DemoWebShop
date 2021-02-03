package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopLogin {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Log in')]") 
	WebElement LoginButton;

	public DemoWebShopLogin (WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public DemoWebShopLogin LoginClick() {
		
		LoginButton.click();
		return new DemoWebShopLogin(driver);
		
	}
	
	}

