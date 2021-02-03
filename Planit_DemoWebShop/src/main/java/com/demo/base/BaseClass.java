package com.demo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public static FileInputStream fis;

	@BeforeSuite

	public void OpenDemoWebshop() throws FileNotFoundException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver(); // Webdriver initialisation

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
		driver.get("http://demowebshop.tricentis.com/"); // to open the URL
		fis = new FileInputStream(System.getProperty("user.dir") + "\\DataDriven\\DemoTestData.xlsx");

	}

	@AfterSuite
	public void quitDemoWebshop() {
		driver.quit(); // to close the browser
	}
}