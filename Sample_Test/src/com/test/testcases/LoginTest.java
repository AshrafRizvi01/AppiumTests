package com.test.testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.pages.FirstPage;
import com.test.pages.LoginPage;
import com.test.pages.Notification_popUp;
import com.test.utils.TestDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginTest {

	AppiumDriver<MobileElement> driver;
	//
	// @AfterClass
	// public void report() throws ParserConfigurationException, SAXException,
	// IOException {
	// System.out.println("running");
	// Reporting.addTestDetails("Ashraf.Iftekhar", "test", "Android", "Galaxy");
	// Reporting.AddTesterNotes("I am very gratefull to you");
	// String[] emails = { "ashraf.iftekhar@mutualmobile.com",
	// "sandeep.akula@mutualmobile.com" };
	// Reporting.generate(emails);
	// }

	@BeforeClass
	public void before() {
		driver = TestDriver.getAndroidDriver("/Users/md.ashrafiftekhar/Downloads/app-devServer-release (3).apk",
				"org.cscpbc.parenting", "org.cscpbc.parenting.view.activity.LaunchActivity", "4.4");
		System.out.println("before");

	}

	@Test()
	public void Check_whether_user_is_able_to_login_without_any_issues() throws InterruptedException {
		FirstPage fp = new FirstPage(driver);
		fp.Click_login();
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(driver);
		lp.login("reg3@test.com", "aaaaaa", driver);
		System.out.println("Run Completed");
		Notification_popUp np = new Notification_popUp(driver);
		Assert.assertEquals(true, np.isNotificationPopup());
	}
}
