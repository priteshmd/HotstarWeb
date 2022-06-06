package com.hotstar.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hotstar.Base.BaseTest;

public class SeleniumHelper extends BaseTest {
	static WebDriver driver = getDriver();
	static WebDriverWait wait = new WebDriverWait(driver,10);
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void waitUntilElementClickable(WebElement e) {
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public static void waitUntilElementVisible(WebElement e) {
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public static void moveToElement(WebElement e) {
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform();
	}
	
	public static void scrollDownBy(int n) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+ n +")");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
