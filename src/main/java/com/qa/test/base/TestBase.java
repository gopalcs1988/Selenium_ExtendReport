package com.qa.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import com.qa.test.utils.BrowserUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger();

	public TestBase() {
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialization()
	{
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();				
	}
	
	@AfterSuite(alwaysRun = true)
	public void AfterSuite() {
		BrowserUtils.closeBrowser();
	}


}
