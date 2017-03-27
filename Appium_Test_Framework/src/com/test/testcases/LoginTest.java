package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pages.LoginPage;
import com.test.utils.TestDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginTest {

	LoginPage loginPage;
	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void before() {
		driver = TestDriver.getAndroidDriver("/Users/md.ashrafiftekhar/Desktop/app-debug.apk",
				"com.livingapps.mdashrafiftekhar.tasker", "com.livingapps.mdashrafiftekhar.tasker.MainActivity", "4.4");

	}

	@Test
	public void Check_whether_user_is_able_to_login_without_any_issues() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login("e@mail.com", "password");
		Assert.assertEquals(true, loginPage.loginResults(driver));
	}
}