package com.dominous.genericlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommonLib  extends BaseTest{
	
	public String getPageTitle()
	{
		return driver.getTitle();
		
	}
	public void waitForPageLoad(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void verify(String actual,String expected,String page)
	{
		Assert.assertEquals(actual,expected);
		Reporter.log(page+ "is Displayed, PASS", true);
	}
	public void mouseHover(WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void getPageScreenshot(String path) throws Throwable
	{
	   TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		//how to copy paste we use Files.copy we use
		Files.copy(src, dest);
	}
	
	public void selectOption(WebElement element,int index)
	{
		Select sel = new Select(element);
	    sel.selectByIndex(index);
	}
	
	public void selectOption(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectOption(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void verifyElementDisplayed(WebElement element,String elementName)
	{
		if(element.isDisplayed())
		{
			Assert.assertTrue(true);
			Reporter.log(elementName+" is displayed, PASS",true);
		}
		else
		{
			Reporter.log(elementName+" is not displayed, FAIL", false);
			Assert.assertTrue(false);
		}
	}
	 
		
	

}
