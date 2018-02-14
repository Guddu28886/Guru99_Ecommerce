package com.guru99.ecommerce.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Dropdown_Handle;
import com.guru99.ecommerce.util.GetScreenshot;
import com.guru99.ecommerce.util.Util;

public class EcomCartErrorTC003 {
	
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
   	  	 WebDriverWait wait=new WebDriverWait(driver,20);
    }
	@Test(priority=1)
  public void run1() 
	{
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	  System.out.println(driver.getTitle());
	  String mobileName="IPhone";
	  driver.findElement(By.xpath("//div[h2[a[text()='"+mobileName+"']]]/div/button[@title='Add to Cart']")).click();
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
	  driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
	  driver.findElement(By.xpath("//span[text()='Update']")).click();
	  String expectedErrorMsg="* The maximum quantity allowed for purchase is 500.";
	  String actualErrorMsg=driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
	  System.out.println("Expected Error: "+expectedErrorMsg);
	  System.out.println("Actual Error: "+actualErrorMsg);
	  Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	  GetScreenshot.captureScreenShot(driver, "MaxQuanityError_003");
	  driver.findElement(By.id("empty_cart_button")).click();
	  String expectedEmptyMsg="SHOPPING CART IS EMPTY";
	  String actaulEmptyMsg=driver.findElement(By.cssSelector(".page-title>h1")).getText();
	  System.out.println("Expected Empty Error: "+expectedEmptyMsg);
	  System.out.println("Actual Empty Error: "+actaulEmptyMsg);
	  GetScreenshot.captureScreenShot(driver, "CartEmpty_003");
	  Assert.assertEquals(actaulEmptyMsg, expectedEmptyMsg);
	
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
