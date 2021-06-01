package com.dominous.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dominous.genericlib.BaseTest;


public class PrintPreviewPage {
	
	@FindBy(xpath="//td[contains(text(),'Campaign Details')]/ancestor::table/following-sibling::table[1]"
			+ "/descendant::input[@value='Print Preview ']") private WebElement printPreviewBtn;
	public PrintPreviewPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	public WebElement getPrintPreviewBtn() {
		return printPreviewBtn;
	}
    public void clickPrintPreview() {
    	printPreviewBtn.click();
    }
}
