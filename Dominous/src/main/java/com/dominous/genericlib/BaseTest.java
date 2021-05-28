package com.dominous.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoConsts{
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		FileLib flib = new FileLib();
		String browser = flib.readPropData(PROP_PATH, "browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			  System.setProperty(CHROME_KEY,CHROME_VALUE);
			  driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter Proper Browser name");
		}
		String appUrl = flib.readPropData(PROP_PATH, "url");
		driver.get(appUrl);
		driver.manage().window().maximize();
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "loginTitle"), "Login Page");
		
	}
	@AfterClass		
    public void closeBrowser()
    {
    	driver.quit();
    }
}
