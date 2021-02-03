package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopLogout {

	WebDriver driver;
		
	@FindBy(xpath = "//a[normalize-space()='Log out']")   
    WebElement logout;
	
	public DemoWebShopLogout(WebDriver driver) {  
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);  
	}  
//this method is for logout from Demo web shop   	
	
	public DemoWebShopLogout demologout()  {
		
		logout.click();
		return new DemoWebShopLogout (driver);
		
		
	}
}
