package com.qa.test.utils;

import org.openqa.selenium.WebDriver;

import com.qa.test.base.TestBase;

public class BrowserUtils extends TestBase{
	
	public static void closeBrowser() {
		
		driver.quit();
	}
	

}
