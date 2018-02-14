package com.guru99.ecommerce.main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.GetScreenshot;
import com.guru99.ecommerce.util.Util;

public class EcomRegisterTC005 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
   	  	 
    }
	@Test(priority=1)
  public void TC005() 
	{
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//span[text()='Account']")).click();
	  driver.findElement(By.linkText("My Account")).click();
	  driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  driver.findElement(By.id("firstname")).sendKeys("ABC");
	  driver.findElement(By.id("middlename")).sendKeys("m");
	  driver.findElement(By.id("lastname")).sendKeys("XYZ");
	  driver.findElement(By.id("email_address")).sendKeys("qwertyuiop1@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("abcd@1234");
	  driver.findElement(By.id("confirmation")).sendKeys("abcd@1234");
	  driver.findElement(By.xpath("//span[text()='Register']")).click();
	  
	  driver.findElement(By.xpath("//a[text()='TV']")).click();
	  driver.findElement(By.xpath("//div[h2[a[text()='LG LCD']]]/div/ul/li/a[text()='Add to Wishlist']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'LG LCD has been added to your wishlist.')]")));
	  driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
	  driver.findElement(By.id("email_address")).sendKeys("gudduumca@gmail.com");
	  driver.findElement(By.id("message")).sendKeys("my share list");
	  driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
	  String actualWishListMsg=driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
	  String expectedWishListMsg="Your Wishlist has been shared.";
	  Assert.assertEquals(actualWishListMsg, expectedWishListMsg);
	  
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}


}
