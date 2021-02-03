package com.demo.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.demo.base.BaseClass;
import com.demo.pages.DemoWebShopBillingAdress;
import com.demo.pages.DemoWebShopBookAddtoCart;
import com.demo.pages.DemoWebShopBookPage;
import com.demo.pages.DemoWebShopClearShoppingCart;
import com.demo.pages.DemoWebShopLogin;
import com.demo.pages.DemoWebShopLoginPage;
import com.demo.pages.DemoWebShopLogout;
import com.demo.pages.DemoWebSiteCheckout;

public class DemoWebShopTestClass extends BaseClass {

	@Test
	public void DemoWebShopTest() throws InterruptedException, IOException {

		DemoWebShopLogin DemoWSL = new DemoWebShopLogin(driver);
		DemoWSL.LoginClick();

		DemoWebShopLoginPage DemoWSLP = new DemoWebShopLoginPage(driver);
		DemoWSLP.Login();
		
		DemoWebShopClearShoppingCart DemoSCSC = new DemoWebShopClearShoppingCart(driver);
		DemoSCSC.ClearSHoppingCart();

		DemoWebShopBookPage DemoWSBP = new DemoWebShopBookPage(driver);
		DemoWSBP.bookSelection();

		DemoWebShopBookAddtoCart DemoWSBAC = new DemoWebShopBookAddtoCart(driver);
		DemoWSBAC.bookAddtocart();

		DemoWebSiteCheckout DemoWsco = new DemoWebSiteCheckout(driver);
		DemoWsco.checkout();

		DemoWebShopBillingAdress DemoSBA = new DemoWebShopBillingAdress(driver);
		DemoSBA.checkoutAddress();
	
		DemoWebShopLogout Demologout = new DemoWebShopLogout(driver);
		Demologout.demologout();

	}

}
