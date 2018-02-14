package com.guru99.ecommerce.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Util;

public class EcomPDFSaveTC007 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
   	  	 
    }
	@Test(priority=1)
  public void TC006() 
	{
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  driver.findElement(By.xpath("//span[text()='Account']")).click();
	  driver.findElement(By.linkText("My Account")).click();
	  driver.findElement(By.id("email")).sendKeys("qwertyuiop@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("abcd@1234");
	  driver.findElement(By.id("send2")).click();
	  //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a/strong")));
	  //driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a/strong")).click();
	  driver.findElement(By.linkText("MY ORDERS")).click();
	  driver.findElement(By.xpath("//tr[td[@class='number']]/td/span/a[text()='View Order']")).click();
	  driver.findElement(By.xpath("//a[text()='Print Order']")).click();
	  
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
