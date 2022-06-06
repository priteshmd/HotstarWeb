package com.hotstar.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.Base.BaseTest;

public class SportsPage {

	@FindBy(xpath = "//div[contains(text(),'Sports')]/../../div/a")
	private List<WebElement> Sportslinks;
	
	
	public SportsPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	public void printSubMenuItems() {
		for (WebElement e : Sportslinks) {
			System.out.println(e.getText());
		}
	}
}
