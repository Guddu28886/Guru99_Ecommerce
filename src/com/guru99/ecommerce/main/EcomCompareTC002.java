package com.guru99.ecommerce.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Dropdown_Handle;
import com.guru99.ecommerce.util.GetScreenshot;
import com.guru99.ecommerce.util.Util;

public class EcomCompareTC002 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
    }
	@Test
  public void run2() 
	{
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	  System.out.println(driver.getTitle());
	  //WebElement element=driver.findElement(By.xpath("//div[label[text()='Sort By']]/select"));
	  //Dropdown_Handle.selectDDLByVisibleText(element, "Name");
	  String priceMainPage=driver.findElement(By.xpath("//div[h2[a[text()='Sony Xperia']]]/div/span[@id='product-price-1']/span")).getText();
	  GetScreenshot.captureScreenShot(driver, "MainPagePrice_002");
	  driver.findElement(By.id("product-collection-image-1")).click();
	  String priceOrderPage=driver.findElement(By.xpath("//span[@id='product-price-1']/span")).getText();
	  GetScreenshot.captureScreenShot(driver, "OrderPagePrice_002");
	  Assert.assertEquals(priceMainPage, priceOrderPage);
	  /*if(priceMainPage.equals(priceOrderPage))
	  {
		  System.out.println("Price in main page is: '"+priceMainPage+"' is same as order page: '"+priceOrderPage+"'");
	  }
	  else
	  {
		  System.out.println("Price in main page is: '"+priceMainPage+"' is not same as order page: '"+priceOrderPage+"'"); 
	  } */
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
