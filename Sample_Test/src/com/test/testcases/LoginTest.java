package com.test.testcases;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.pages.LoginPage;
import com.test.utils.Reporting;
import com.test.utils.TestDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginTest {

	LoginPage loginPage;
	AppiumDriver<MobileElement> driver;

	@BeforeClass
	public void before() {
		driver = TestDriver.getAndroidDriver("/Users/md.ashrafiftekhar/Desktop/app-debug.apk",
				"com.livingapps.mdashrafiftekhar.tasker", "com.livingapps.mdashrafiftekhar.tasker.MainActivity", "4.4");

	}

	@Test(enabled = false)
	public void Check_whether_user_is_able_to_login_without_any_issues() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login("e@mail.com", "password");
		Assert.assertEquals(true, loginPage.loginResults(driver));
	}

	@Test()
	public void Sample_test_method_to_test_the_report_process() {
		Assert.assertEquals(true, false);
	}

	@Test()
	public void Sample_test_method_to_test_the_report_process2() {
		Assert.assertEquals(true, true);
	}

	@Test(dataProvider = "dp")
	public void Sample_test_method_to_test_the_report_process3(boolean a, boolean e) {
		Assert.assertEquals(a, e);
	}

	@DataProvider(name = "dp")
	public Object[][] dp() {
		Object[][] obj = { { true, false }, { true, true }, { false, false } };
		return obj;
	}

	@AfterClass
	public void report() throws ParserConfigurationException, SAXException, IOException {
		Reporting.addTestDetails("Ashraf.Iftekhar", "test", "Android", "Galaxy");
		Reporting.AddTesterNotes("I am very gratefull to you");
		Reporting.generate("/Users/md.ashrafiftekhar/Desktop/Test.html", "NewReport");
	}
}