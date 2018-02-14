package com.guru99.ecommerce.main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Util;

public class EcomPurchaseTC006 {
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
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//span[text()='Account']")).click();
	  driver.findElement(By.linkText("My Account")).click();
	  driver.findElement(By.id("email")).sendKeys("qwertyuiop@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("abcd@1234");
	  driver.findElement(By.id("send2")).click();
	  driver.switchTo().defaultContent();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")));
	  driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();
	  driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='LG LCD was added to your shopping cart.']")));
	  String subTotalCost=driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[5]/span/span")).getText();
	  float subTotalValue=Float.parseFloat(subTotalCost.substring(1, subTotalCost.length()));
	  driver.findElement(By.xpath("//span[text()='Proceed to Checkout']")).click();
	  
	  driver.findElement(By.id("billing:street1")).clear();
	  driver.findElement(By.id("billing:street1")).sendKeys("ABC");
	  driver.findElement(By.id("billing:city")).clear();
	  driver.findElement(By.id("billing:city")).sendKeys("New York");
	  Select selectState=new Select(driver.findElement(By.id("billing:region_id")));
	  selectState.selectByVisibleText("New York");
	  driver.findElement(By.id("billing:postcode")).clear();
	  driver.findElement(By.id("billing:postcode")).sendKeys("542896");
	  Select selectCountry=new Select(driver.findElement(By.id("billing:country_id")));
	  selectCountry.selectByValue("US");
	  /*List<WebElement> list=selectCountry.getAllSelectedOptions();
	  System.out.println(list.get(0).getText());
	  if(list.get(0).getText().equals("United States"))
	  {
		  
	  }
	  else
	  {
		  selectCountry.selectByValue("US");
	  } */
	  driver.findElement(By.id("billing:telephone")).clear();
	  driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
	  driver.findElement(By.xpath("//li[input[@id='billing:use_for_shipping_yes']]/label[text()='Ship to this address']")).click();
	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
	  
	  //driver.findElement(By.xpath("//label[contains(text(),'Fixed')]")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Fixed')]")));
	  String shippingCost=driver.findElement(By.xpath("//label[contains(text(),'Fixed')]/span")).getText();
	  float shippingValue=Float.parseFloat(shippingCost.substring(1, shippingCost.length()));
	  float grandTotal=shippingValue+subTotalValue;
	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='p_method_checkmo']")));
	  driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
	  driver.findElement(By.xpath("//span[text()='Continue']")).click();
	  //String expectedGrandTotal=Float.toString(grandTotal);
	  String actaulGrandTotal=driver.findElement(By.xpath("//strong/span[@class='price']")).getText();
	  if(actaulGrandTotal.contains(Float.toString(grandTotal)))
	  {
		  System.out.println("Grand total is correct");
	  }
	  else
	  {
		  System.out.println("Grand total is not correct");
		  System.exit(1);
	  }
	  
	  
	  
	  driver.findElement(By.xpath("//span[text()='Place Order']")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div/h1")).getText(), "Your order has been received.");
	  String orderId=driver.findElement(By.xpath("//p[contains(text(),'Your order # is:')]/a")).getText();
	  System.out.println("Your Order ID: "+orderId);
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}


}
