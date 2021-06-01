package com.dominous.operation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dominous.genericlib.BaseTest;
import com.dominous.genericlib.FileLib;
import com.dominous.genericlib.WebDriverCommonLib;
import com.dominous.pages.LoginPage;

@Listeners(com.dominous.genericlib.MyListeners.class)
public class ValidLoginTest extends BaseTest {

	@Test(priority=1)
	public void loginToApp() throws Throwable {
		LoginPage lp = new LoginPage();
		FileLib flib = new FileLib();
		lp.login(flib.readPropData(PROP_PATH, "username"), flib.readPropData(PROP_PATH, "password"));
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(), flib.readPropData(PROP_PATH, "homeTitle"), "Home page");

	

	}

}
