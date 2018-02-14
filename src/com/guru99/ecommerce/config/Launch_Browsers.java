package com.guru99.ecommerce.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.guru99.ecommerce.util.Util;

public class Launch_Browsers {
	public static WebDriver getBrowserDriver()
	{
		File f=new File("./config-lib/config.properties");
		FileInputStream fis;
		WebDriver driver=null;
		try 
		{
			fis = new FileInputStream(f);
			Properties prop=new Properties();
			prop.load(fis);
			String browserName=prop.getProperty("browser");
			
			if(browserName.contains("firefox"))
			{
				System.setProperty("webdriver.firefox.marionette", Util.fireFoxDriverPath);
				driver=new FirefoxDriver();
			}
			else if(browserName.contains("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", Util.chromeDriverPath);
				driver=new ChromeDriver();
			}
			else 
			{
				driver=null;
				System.out.println("Please specify browser name as firefox or chrome in config.properties file");
				System.exit(1);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

}
