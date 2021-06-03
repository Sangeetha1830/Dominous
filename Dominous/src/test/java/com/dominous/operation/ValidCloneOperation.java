package com.dominous.operation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dominous.genericlib.BaseTest;
import com.dominous.genericlib.FileLib;
import com.dominous.genericlib.WebDriverCommonLib;
import com.dominous.pages.CloneCampaignPage;
import com.dominous.pages.CreateCampaignPage;
import com.dominous.pages.DisplayingCustomViewDetailsPage;
import com.dominous.pages.HomePage;
import com.dominous.pages.LoginPage;

@Listeners(com.dominous.genericlib.MyListeners.class)
public class ValidCloneOperation extends BaseTest{
	
	@Test
	public void verifyCloneOperation() throws Throwable {
		LoginPage lp =new LoginPage();
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home Page");
		
		HomePage hp=new HomePage();
		hp.clickcampaignLink();
		Thread.sleep(2000);
		wlib.verify(wlib.getPageTitle(),flib.readPropData(PROP_PATH, "customViewTitle"), "Displaying Custom View Details Page");
		
		DisplayingCustomViewDetailsPage dc=new DisplayingCustomViewDetailsPage();
		dc.clickNewCampaignBtn();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createCampaignTitle"), "Create Campaign Page");
		
		CreateCampaignPage cc=new CreateCampaignPage();
		String campaignName = flib.getExcelData(EXCEL_PATH, "Customer", 2,1);
		cc.enterCampaignName(campaignName);
		
		cc.clickSaveBtn();
		
		//verify the clonebutton
		CloneCampaignPage cl=new CloneCampaignPage();
		cl.clickClone();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "cloneCampaignTitle"), "Clone Campaign Page");
		cc.clickSaveBtn();
		dc.verifyCampaignCreation(campaignName);
		
		
		
	}

}
