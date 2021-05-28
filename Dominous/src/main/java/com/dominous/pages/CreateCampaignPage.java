package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;



public class CreateCampaignPage {
	
	@FindBy(xpath="//input[@name='property(Campaign Name)']") private WebElement campaignNameBtn;
	@FindBy(xpath="//div[@class='bodyText mandatory']/following-sibling::table[2]//input[@value='Save']") 
	private WebElement saveBtn;
	
	
	public CreateCampaignPage() {
		
		PageFactory.initElements(BaseTest.driver, this);
	}


	public WebElement getCampaignName() {
		return campaignNameBtn;
	}
	
    public void enterCampaignName(String campaignName) {
		campaignNameBtn.sendKeys(campaignName);
		
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	 
	public void clickSaveBtn() {
		saveBtn.click();
	}


	
}


