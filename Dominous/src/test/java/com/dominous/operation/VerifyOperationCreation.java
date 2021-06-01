package com.dominous.operation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dominous.genericlib.BaseTest;
import com.dominous.genericlib.FileLib;
import com.dominous.genericlib.WebDriverCommonLib;
import com.dominous.pages.CreateCampaignPage;
import com.dominous.pages.DisplayingCustomViewDetailsPage;
import com.dominous.pages.HomePage;




@Listeners(com.dominous.genericlib.MyListeners.class)
public class VerifyOperationCreation extends BaseTest{
	
	@Test(priority=2)
	public void verifyOperationTest() throws Throwable {
	//open the browser and enter the test url click on sign in button and verify Login Page
	
	//login to app and verify HOME PAGE
	ValidLoginTest vl=new ValidLoginTest();
	vl.loginToApp();
	
	
	//click on operation module[operation modulemeans campaign module]
	HomePage hp=new HomePage();
	hp.clickcampaignLink();
	
	WebDriverCommonLib wlib=new WebDriverCommonLib();
	FileLib flib = new FileLib();
	wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "customViewTitle"), "custom View Page");
    
	//Click on New operation button
	DisplayingCustomViewDetailsPage dc=new DisplayingCustomViewDetailsPage();
	dc.clickNewCampaignBtn();
	//to verify the CreateNewCampaign
	wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "createCampaignTitle"),"Create Campaign Page" );
	
	//click on NewCampaign After getting CreateCampaignPage so we have create create campaign object
	CreateCampaignPage cc=new CreateCampaignPage();
	String campaignName = flib.getExcelData(EXCEL_PATH, "Customer", 1, 1);
	cc.enterCampaignName(campaignName);;
	
    //cc.enterCampaignName("Sangeetha");
	//to save
	cc.clickSaveBtn();
	Thread.sleep(2000);
	
	//we have click on outside
	hp.clickcampaignLink();
	Thread.sleep(2000);

	//to go in Custom view Details Page
	dc.verifyCampaignCreation(campaignName);
	
}
}