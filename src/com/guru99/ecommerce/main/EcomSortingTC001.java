package com.guru99.ecommerce.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Dropdown_Handle;
import com.guru99.ecommerce.util.GetScreenshot;
import com.guru99.ecommerce.util.Util;

public class EcomSortingTC001 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
    }
	@Test
  public void run() 
	{
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	  System.out.println(driver.getTitle());
	  WebElement element=driver.findElement(By.xpath("//div[label[text()='Sort By']]/select"));
	  Dropdown_Handle.selectDDLByVisibleText(element, "Name");
	  GetScreenshot.captureScreenShot(driver, "MobileNameSort_001");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
