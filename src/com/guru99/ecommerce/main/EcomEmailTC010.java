package com.guru99.ecommerce.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.ecommerce.config.Launch_Browsers;
import com.guru99.ecommerce.util.Util;

public class EcomEmailTC010 {
	WebDriver driver;
    @BeforeMethod
    public void setup()
    {
    	 driver=Launch_Browsers.getBrowserDriver();
   	  	 driver.get("http://live.guru99.com/index.php/backendlogin");
   	  	 
    }
	@Test(priority=1)
  public void TC006() throws InterruptedException 
	{
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  driver.findElement(By.id("username")).sendKeys("user01");
	  driver.findElement(By.id("login")).sendKeys("guru99com");
	  driver.findElement(By.xpath("//input[@value='Login']")).click();
	  driver.findElement(By.xpath("//span[text()='close']")).click();
	  Thread.sleep(2000);
	  WebElement menu=driver.findElement(By.xpath("//span[text()='Sales']"));
	  Actions act=new Actions(driver);
	  act.moveToElement(menu).perform();
	  driver.findElement(By.xpath("//span[text()='Orders']")).click();
	  Select sct=new Select(driver.findElement(By.id("sales_order_grid_export")));
	  sct.selectByVisibleText("CSV");
	  driver.findElement(By.id("id_9b977a18344c1e2f638d7431f4417422")).click();
	  
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}

}
