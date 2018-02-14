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

public class EcomPopUpTC004 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get(Util.url);
   	  	 
    }
	@Test(priority=1)
  public void run1() 
	{
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//a[text()='Mobile']")).click();
	  System.out.println(driver.getTitle());
	  String mobileName1="IPhone";
	  String mobileName2="Samsung Galaxy";
	  driver.findElement(By.xpath("//div[h2[a[text()='"+mobileName1+"']]]/div/ul/li/a[text()='Add to Compare']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='compare-items']/li/p/a[text()='"+mobileName1+"']")));
	  driver.findElement(By.xpath("//div[h2[a[text()='"+mobileName2+"']]]/div/ul/li/a[text()='Add to Compare']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='compare-items']/li/p/a[text()='"+mobileName2+"']")));
	  driver.findElement(By.xpath("//span[text()='Compare']")).click();
	  Set<String> windowIds=driver.getWindowHandles();
	  Iterator<String> itr=windowIds.iterator();
	  String parentWindow=itr.next();
	  String childWindow=itr.next();
	  driver.switchTo().window(childWindow);
	  String expectedHeading="COMPARE PRODUCTS";
	  String actualHeading=driver.findElement(By.xpath("//*[@id='top']/body/div/div/h1")).getText();
	  Assert.assertEquals(actualHeading, expectedHeading);
	  String popUpPhone1=driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
	  String popUpPhone2=driver.findElement(By.xpath("//h2/a[@title='Samsung Galaxy']")).getText();
	  Assert.assertEquals(popUpPhone1, "IPHONE");
	  Assert.assertEquals(popUpPhone2, "SAMSUNG GALAXY");
	  GetScreenshot.captureScreenShot(driver, "PopUp_Window_Compare");
	  driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	  driver.switchTo().window(parentWindow);
	  
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	


}
