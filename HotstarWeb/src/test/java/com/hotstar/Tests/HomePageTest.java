package com.hotstar.Tests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hotstar.Base.BaseTest;
import com.hotstar.Pages.HomePage;
import com.hotstar.Utils.SeleniumHelper;

public class HomePageTest extends BaseTest{

	HomePage homepage;
	SeleniumHelper helper;
	String lang = "English";
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeSuite
	public void startTest(@Optional String browser) throws InterruptedException {
		driver = BaseTest.getDriver(browser);
		driver.get(prop.getProperty("URL"));
		Thread.sleep(8000);
	}
	
	@BeforeMethod
	public void startMethod(Method method) {
		System.out.println("\nStarting method " + method.getName());
		System.out.println("\t***********************\n");
	}
	
	@AfterMethod
	public void endMethod(Method method) {
		System.out.println("\nEnding method " + method.getName());
		System.out.println("\t========================\n");
	}
	
	@Test
	public void Test01() {
		homepage = new HomePage(driver);
		System.out.println("Printing Home page Tray items : \n");
		homepage.printTrayItemsOnHomePage();

	}
	
	@Test
	public void Test02() {
		homepage = new HomePage(driver);
		homepage.goToTVPage().printSubMenuItems();

	}
	@Test
	public void Test03() {
		homepage = new HomePage(driver);
		homepage.goToMoviesPage().printSubMenuItems();
	}
	
	@Test
	public void Test04() {
		homepage = new HomePage(driver);
		homepage.goToSportsPage().printSubMenuItems();

	}
	
	@Test
	public void Test05() {
		homepage = new HomePage(driver);
		homepage.goToKidsPage().exitKidsPage();
		System.out.println("Exiting Kids Page");
	}
	
	@Test
	@Parameters ("lang")
	public void Test06(@Optional String lang) {
		if(lang == null)
			lang = this.lang;
		homepage = new HomePage(driver);
		homepage.goToMoviesPage().openLangMovies(lang);
		System.out.println("Opening " + lang + " language Movies Page");
		SeleniumHelper.scrollDownBy(100);
		SeleniumHelper.scrollDownBy(100);
		SeleniumHelper.scrollDownBy(100);
	}
	
	@AfterSuite
	public void teardown() {
		if(driver != null)
			driver.close();
		driver.quit();
	}
}
