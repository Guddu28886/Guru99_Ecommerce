package com.guru99.ecommerce.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Handle {
	public static void selectDDLByVisibleText(WebElement element,String visibleText)
	{
		Select sct=new Select(element);
		sct.selectByVisibleText(visibleText);
	}
	public static void selectDDLByValue(WebElement element, String value)
	{
		Select sct=new Select(element);
		sct.selectByValue(value);
	}
	public static void selectDDLByIndex(WebElement element, int index)
	{
		Select sct=new Select(element);
		sct.selectByIndex(index);
	}

}
