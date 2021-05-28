package com.dominous.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.dominous.genericlib.BaseTest;





public class DisplayingCustomViewDetailsPage {
	
	@FindBy(xpath="//input[@value='New Campaign']") private WebElement newCampaignBtn;
	@FindBy(xpath="//table[@class='secContent']//tbody//tr[*]//td[@class='tableData'][3]")
	private List<WebElement> campaignList;
	
	public DisplayingCustomViewDetailsPage() {
		
	     PageFactory.initElements(BaseTest.driver, this);
	}
	
	public WebElement getNewCampaignBtn() {
		return newCampaignBtn;
	}
	
	public void setNewCampaignBtn(WebElement newCampaignBtn) {
		this.newCampaignBtn = newCampaignBtn;
	}
	
	public void clickNewCampaignBtn() {
		
		newCampaignBtn.click();
		
	}
	public void verifyCampaignCreation(String campaign) {
		for(WebElement onecampaign:campaignList){
			String campaignName = onecampaign.getText();
			if(campaignName.equals(campaign))
			{
				Reporter.log("Our Campaign is Created",true);
				break;
			}
			else
			{
				Reporter.log("Our Campaign is not Created",true);
			}
		}
	}

}
