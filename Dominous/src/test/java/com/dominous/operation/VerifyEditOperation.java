package com.dominous.operation;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dominous.genericlib.BaseTest;
import com.dominous.genericlib.FileLib;
import com.dominous.genericlib.WebDriverCommonLib;
import com.dominous.pages.CreateCampaignPage;
import com.dominous.pages.DisplayingCustomViewDetailsPage;
import com.dominous.pages.EditCampaignPage;
import com.dominous.pages.HomePage;
import com.dominous.pages.LoginPage;

@Listeners(com.dominous.genericlib.MyListeners.class)
public class VerifyEditOperation extends BaseTest {
	
	@Test(priority=3) 
	public void verifyEditOPeration() throws Throwable {
		LoginPage lp=new LoginPage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"),flib.readPropData(PROP_PATH, "password"));
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		
		HomePage hp = new HomePage();
		hp.clickcampaignLink();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details");
		
		DisplayingCustomViewDetailsPage dc=new DisplayingCustomViewDetailsPage();
		dc.clickNewCampaignBtn();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createCampaignTitle"), "Create Campaign Page");
		
		CreateCampaignPage cc=new CreateCampaignPage();
		String campaignName = flib.getExcelData(EXCEL_PATH, "Customer", 2, 1);
		cc.enterCampaignName(campaignName);
		
		cc.clickSaveBtn();
		Thread.sleep(2000);
		dc.verifyCampaignCreation(campaignName);
	
		
		EditCampaignPage ec=new EditCampaignPage();
		ec.clickEditBtn();
		Thread.sleep(5000);
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "editCampaignTitle"), "Edit Campaign Page");
		//ec.clickClear();
		String campaignNameE=flib.getExcelData(EXCEL_PATH, "Customer", 4, 1);
		cc.enterCampaignName(campaignName);
		cc.clickSaveBtn();
		//Thread.sleep(3000);
		//wlib.verify(wlib.getPageTitle(), flib.readPropData(EXCEL_PATH, "editCampaignDetails"), "Edit Campaign Details Page");
		//dc.verifyCampaignCreation(campaignNameE);
		
		
		
	}
	
	
	
	

}
