package com.dominous.operation;

import org.openqa.selenium.Alert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dominous.genericlib.BaseTest;
import com.dominous.genericlib.FileLib;
import com.dominous.genericlib.WebDriverCommonLib;
import com.dominous.pages.CreateCampaignPage;
import com.dominous.pages.DeleteCampaignPage;
import com.dominous.pages.DisplayingCustomViewDetailsPage;
import com.dominous.pages.HomePage;
import com.dominous.pages.LoginPage;

@Listeners(com.dominous.genericlib.MyListeners.class)
public class VerifyDeleteOperation extends BaseTest{
	
	@Test
	public void verifyDeleteOperation() throws Throwable {
		LoginPage lp=new LoginPage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"),flib.readPropData(PROP_PATH, "password"));
		//this is the verification of the home page
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		
		//click on Campaignlink
		HomePage hp=new HomePage();
		hp.clickcampaignLink();
		Thread.sleep(2000);
	    wlib.verify(wlib.getPageTitle(),flib.readPropData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details Page");    
		
		//click on the new Campaign
	    DisplayingCustomViewDetailsPage dc=new DisplayingCustomViewDetailsPage();
	    dc.clickNewCampaignBtn();
	    Thread.sleep(2000);
	    wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createCampaignTitle"), "Create Campaign Page");
	    
	    //enter the campaignName
	    CreateCampaignPage cc=new CreateCampaignPage();
	    String campaignName = flib.getExcelData(EXCEL_PATH, "Customer", 2, 1);
	    cc.enterCampaignName(campaignName);
	    
	    //click on SaveButton
	    cc.clickSaveBtn();
	    Thread.sleep(2000);
	    
	    //Delete the campaign
	    DeleteCampaignPage dl=new DeleteCampaignPage();
	    dl.clickDelete();
	    Thread.sleep(2000);
	    Alert al=driver.switchTo().alert();
	    al.accept();
	    wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "deleteCampaignDetails"), "Displaying Custom View Details");
//	    Alert al=driver.switchTo().alert();
//	    al.accept();
   
		
		
		
		
	}

}
