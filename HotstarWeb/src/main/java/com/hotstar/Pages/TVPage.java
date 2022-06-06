package com.hotstar.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.Base.BaseTest;

public class TVPage {

	@FindBy(xpath = "//div[contains(text(),'TV')]/../../div/a")
	private List<WebElement> TVlinks;
	
	
	public TVPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	public void printSubMenuItems() {
		for (WebElement e : TVlinks) {
			System.out.println(e.getText());
		}
	}
}
