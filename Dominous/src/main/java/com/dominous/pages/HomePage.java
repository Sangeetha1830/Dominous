package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Campaigns']") private WebElement campaignsLink;
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getCampaignLink() {
		return campaignsLink;
	}
	
	
	public void clickcampaignLink() {
		campaignsLink.click();
		
	}
	
	
	

}
