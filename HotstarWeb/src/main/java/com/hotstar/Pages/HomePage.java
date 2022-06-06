package com.hotstar.Pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotstar.Base.BaseTest;
import com.hotstar.Utils.SeleniumHelper;

public class HomePage {
	@FindBy(xpath = "//button[@class='slick-arrow slick-next']")
	WebElement carouselArrow;

	@FindBy(xpath = "//h2[@class='tray-title']")
	List<WebElement> items;

	@FindBy(xpath = "//div[contains(text(),'TV')]")
	WebElement TVBtn;

	@FindBy(xpath = "//div[contains(text(),'Movies')]")
	WebElement MoviesBtn;

	@FindBy(xpath = "//div[contains(text(),'Sports')]")
	WebElement SportsBtn;

	@FindBy(xpath = "//div/a/div[contains(@class,'kids')]")
	WebElement KidsBtn;

	@FindBy(xpath = "//div/a/div[contains(text(),'Disney+')]")
	WebElement DisneyBtn;

	@FindBy(xpath = "//div[@class='nav-logo']")
	WebElement HomeBtn;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	public void goToHomePage() {
		HomeBtn.click();
	}

	public TVPage goToTVPage() {
		TVBtn.click();
		System.out.println("Opened TV Page");
		return new TVPage();
	}

	public MoviesPage goToMoviesPage() {
		MoviesBtn.click();
		System.out.println("Opened Movies Page");
		return new MoviesPage();
	}

	public SportsPage goToSportsPage() {
		SportsBtn.click();
		System.out.println("Opened Sports Page");
		return new SportsPage();
	}

	public KidsPage goToKidsPage() {
		KidsBtn.click();
		System.out.println("Opened Kids Page");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new KidsPage();
	}

	public void clickOnCarousel() {
		SeleniumHelper.waitUntilElementClickable(carouselArrow);
		carouselArrow.click();
	}

	public void printTrayItemsOnHomePage() {

		for (WebElement e : items) {
			System.out.println(e.getText());
		}
	}
	
	
}
