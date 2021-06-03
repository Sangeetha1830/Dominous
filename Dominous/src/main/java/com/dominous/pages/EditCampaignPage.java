 
package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;


public class EditCampaignPage {
	
	@FindBy(xpath="//td[contains(text(),'Campaign Details')]/ancestor::table/following::table[1]//input[@value='Edit']")
	    private WebElement editBtn;
	
	public EditCampaignPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

    public void clickEditBtn() {
    	editBtn.click();
    }
    public void clickClear() {
    	editBtn.clear();
    }
	
    

}
