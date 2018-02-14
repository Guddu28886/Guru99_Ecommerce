package com.guru99.ecommerce.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class GetScreenshot {
	public static void captureScreenShot(WebDriver driver,String screenshotname)
	{
		try{
			
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File source=edriver.getScreenshotAs(OutputType.FILE);
		File target=new File("./screenshots/"+screenshotname+".jpg");
		FileUtils.copyFile(source, target);
	}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
