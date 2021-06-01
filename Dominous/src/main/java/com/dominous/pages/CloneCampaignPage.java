package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;


public class CloneCampaignPage {
	
	@FindBy(xpath="//td[contains(text(),'Campaign Details')]/ancestor::table/following-sibling::table[1]/descendant::input[@value='Clone']")
	private WebElement cloneBtn;
	
	public CloneCampaignPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getCloneBtn() {
		return cloneBtn;
	}
	public void clickClone() {
		cloneBtn.click();
		
	}
	
	
	
	

}
