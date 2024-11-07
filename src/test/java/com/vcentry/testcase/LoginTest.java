package com.vcentry.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.base.BaseClass;
import com.vcentry.pages.LoginPage;
import com.vcentry.utils.Function;

public class LoginTest extends BaseClass {

	LoginPage login;

	
	@BeforeMethod
	public void launchUrl() {
		driver.get(Function.getProp("loginurl"));
		login = new LoginPage();
		
	}

	@Test(dataProvider = "ValidLogin",priority = 1)
	public void LoginWithValidCredentials(String uName, String pwd, String expectedResult) {

		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyHomePage(expectedResult);

	}
	
	@Test(dataProvider = "InvalidLogin",priority=2)
	public void LoginWithInvalidCredentials(String uName, String pwd, String expectedResult) {

		login.enterUsername(uName);
		login.enterPassword(pwd);
		login.clickLoginBtn();
		login.verifyError(expectedResult);

	}

	@DataProvider(name = "ValidLogin")

	public String[][] validlogin() {

		return Function.getTestData("login", "ValidCredentials");
	}

	

	@DataProvider(name = "InvalidLogin")

	public String[][] Invalidlogin() {

		return Function.getTestData("login", "InvalidCredentials");
	}
}
