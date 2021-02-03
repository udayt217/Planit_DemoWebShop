package com.demo.datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoWebshopDataDriven {
	@Test             // This method is for data driven 
	public void Datadriven() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Webdriver initialisation

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
		driver.get("http://demowebshop.tricentis.com/"); // to open the URL
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\DataDriven\\DemoTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet xs = wb.getSheet("TestData");
		int Rcount = xs.getLastRowNum();
		System.out.println(Rcount);

		for (int i =1 ; i <= Rcount; i++) {

			XSSFRow xr = xs.getRow(i);
			XSSFCell xc = xr.getCell(0);
			XSSFCell xc1 = xr.getCell(1);
		 	XSSFCell xcreate= xr.createCell(2);
		 	    driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
	        	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(xc.getStringCellValue());
	        	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(xc1.getStringCellValue());
	        	xcreate.setCellValue("Pass");
	        	driver.findElement(By.xpath("//input[@value='Log in']")).click();  
	        	driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
	        	 }
FileOutputStream fos= new FileOutputStream(System.getProperty("user.dir") + "\\DataDrivenResult\\DemoTestDataResult.xlsx");
wb.write(fos); 
wb.close();	
driver.quit();	
	}
	}
