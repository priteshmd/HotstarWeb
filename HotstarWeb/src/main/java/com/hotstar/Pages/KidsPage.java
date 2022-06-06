package com.hotstar.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.Base.BaseTest;
import com.hotstar.Utils.SeleniumHelper;

public class KidsPage {
	
	@FindBy(xpath = "//button[contains(text(),'Exit Kids')]")
	private WebElement exitKidsBtn;
	
	
	public KidsPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	public void exitKidsPage() {
		SeleniumHelper.waitUntilElementClickable(exitKidsBtn);
		exitKidsBtn.click();
	}
}
