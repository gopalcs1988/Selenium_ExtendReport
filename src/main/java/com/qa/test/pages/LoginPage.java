package com.qa.test.pages;

import java.util.concurrent.TimeUnit;

import com.qa.test.base.TestBase;
import com.qa.test.core.BrowserInteractions;
import com.qa.test.utils.LocatorType;


public class LoginPage {

	static final String username = "username";
	static final String password = "password";
	static final String next_button = "continue";
	static final String loginButton = "login";

	public void login() throws Exception {
		TestBase.log.info("Enter the user name");
		BrowserInteractions.clearAndType(LocatorType.ID, username, "bssuqawwev3\\Blended_1400");
		TestBase.log.info("Click on the next button to enter the password");
		BrowserInteractions.click(LocatorType.ID, next_button);
		TestBase.log.info("Check whether password text field is visible");
		BrowserInteractions.isVisible(LocatorType.ID, password);
		TestBase.log.info("Enter the password to login into the application");
		BrowserInteractions.clearAndType(LocatorType.ID, password, "Genesys");
		TestBase.log.info("Click the login button");
		BrowserInteractions.click(LocatorType.ID, loginButton);		
	}

}
