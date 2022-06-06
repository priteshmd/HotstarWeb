package com.hotstar.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	private static WebDriver driver;
	protected static Properties prop;
	
	protected BaseTest() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WebDriver getDriver(String browser) {
//		WebDriver driver;
		if(prop.getProperty("browser") != null)
			browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
