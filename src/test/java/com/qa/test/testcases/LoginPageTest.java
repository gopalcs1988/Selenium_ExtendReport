package com.qa.test.testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.test.base.TestBase;
import com.qa.test.core.BrowserInteractions;
import com.qa.test.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	public LoginPageTest(){
		super();		
	}
	
	@BeforeClass
	public void setup() {
		log.info("Initialization method calls to initiate the driver");
		loginPage = new LoginPage();
		Initialization();
		log.info("Access the login page");
		BrowserInteractions.navigateToURL(prop.getProperty("url"));
	}
	
	@Test(priority = 1)
	public void login() throws Exception	{
		log.info("Login Module called");
		loginPage.login();
	}
}
