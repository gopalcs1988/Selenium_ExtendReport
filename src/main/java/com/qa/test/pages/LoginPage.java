package com.qa.test.pages;

import java.util.concurrent.TimeUnit;

import com.qa.test.core.BrowserInteractions;
import com.qa.test.utils.LocatorType;


public class LoginPage {

	static final String username = "username";
	static final String password = "password";
	static final String next_button = "continue";
	static final String loginButton = "login";

	public void login() throws Exception {
		BrowserInteractions.clearAndType(LocatorType.ID, username, "bssuqawwev3\\Blended_1400");
		BrowserInteractions.click(LocatorType.ID, next_button);
		BrowserInteractions.isVisible(LocatorType.ID, password);
		BrowserInteractions.clearAndType(LocatorType.ID, password, "Genesys");
		BrowserInteractions.click(LocatorType.ID, loginButton);		
	}

}
