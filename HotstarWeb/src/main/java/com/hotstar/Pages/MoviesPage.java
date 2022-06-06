package com.hotstar.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.Base.BaseTest;
import com.hotstar.Utils.SeleniumHelper;

public class MoviesPage {

	@FindBy(xpath = "//div[contains(text(),'Movies')]/../../div/a")
	private List<WebElement> Movieslinks;
	
	@FindBy(xpath = "//div[contains(text(),'Movies')]")
	WebElement MoviesBtn;
	
	public MoviesPage() {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}
	
	public void printSubMenuItems() {
		for (WebElement e : Movieslinks) {
			System.out.println(e.getText());
		}
	}
	
	public void openLangMovies(String lang) {
		boolean status = false;
		SeleniumHelper.moveToElement(MoviesBtn);
		for (WebElement e : Movieslinks) {
			String act = e.getText();
			if(lang.equalsIgnoreCase(act)) {
				status = true;
				SeleniumHelper.moveToElement(e);
				e.click();
				break;
			}		
		}
		if(!status)
			System.out.println("Incorrect language");
		
		
	}
	
	
}
