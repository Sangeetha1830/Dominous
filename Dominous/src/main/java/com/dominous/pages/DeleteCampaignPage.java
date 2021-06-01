package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;


public class DeleteCampaignPage {
	
	@FindBy(xpath="//td[contains(text(),'Campaign Details')]/ancestor::table/following-sibling::table[1]/descendant::input\r\n"
			+ "[@value='Delete'] ") private WebElement deleteBtn;
	
	public DeleteCampaignPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public void clickDelete() {
		deleteBtn.click();
	}
	
	

}
