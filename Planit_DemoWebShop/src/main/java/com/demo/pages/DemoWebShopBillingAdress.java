package com.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoWebShopBillingAdress {
	WebDriver driver;
	String expOrderMessage;
	String actOrderMessage;

	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement billingadddress;
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement billingaddCountinue;
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	WebElement billingaddCountry;
	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	WebElement billingaddCity;
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	WebElement billingaddress;
	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	WebElement billingzip;
	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	WebElement billingPhone;
	@FindBy(xpath = "//*[@name='shipping_address_id']")
	WebElement shippingAdd;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement contiuneshippingAdd;
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement shippingmethod;
	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	WebElement continueshippingmethod;
	@FindBy(xpath = "//input[@id='shippingoption_1']")
	WebElement nextDayAir;
	@FindBy(xpath = "//input[@id='paymentmethod_0']")
	WebElement cod;
	@FindBy(xpath = "//input[@id='paymentmethod_0']")
	WebElement paymentMethod;
	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	WebElement continuepaymentmethod;
	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	WebElement continuepaymentinformation;
	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirmorder;
	@FindBy(xpath = "//p[normalize-space()='You will pay by COD']")
	WebElement codmessage;
	@FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
	WebElement ordermessage;
	@FindBy(xpath = "//*[contains(text(),'Order number')]")
	WebElement ordernumber;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Countinue;

	public DemoWebShopBillingAdress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//this method is for providing billing details, shipping address,shipping method
// and payment method and validating cod text message and validating the message order success and printing order number.
	public DemoWebShopBillingAdress checkoutAddress() throws InterruptedException {

		Select billingAdd = new Select(billingadddress);
		billingAdd.selectByVisibleText("New Address");

		Select billingcountry = new Select(billingaddCountry);
		billingcountry.selectByVisibleText("India");

		billingaddCity.sendKeys("hyd");
		billingaddress.sendKeys("hyd");
		billingzip.sendKeys("6666");
		billingPhone.sendKeys("565566666");
		billingaddCountinue.click();

		Select ShippingAddress = new Select(shippingAdd);
		ShippingAddress.selectByVisibleText("atest dummy, hyd, hyd 6666, India");

		Thread.sleep(3000);
		contiuneshippingAdd.click();
		nextDayAir.click();
		continueshippingmethod.click();
		Thread.sleep(3000);
		cod.click();
		System.out.println("Cash on deleivery Selected");
		continuepaymentmethod.click();
		String codMessag = codmessage.getText();
		System.out.println(codMessag);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		continuepaymentinformation.click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		confirmorder.click();
		expOrderMessage = "Your order has been successfully processed!";
		actOrderMessage = ordermessage.getText();
		if (expOrderMessage.contains(actOrderMessage)) {
			System.out.println(actOrderMessage);
		} else {
			System.out.println("Order unsuccessful");
		}
		String orderno = ordernumber.getText();
		System.out.println("Your Orderno=" + orderno);

		Countinue.click();

		return new DemoWebShopBillingAdress(driver);
	}
}