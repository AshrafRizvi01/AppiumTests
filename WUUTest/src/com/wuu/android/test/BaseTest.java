package com.wuu.android.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.wuu.android.test.util.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Base class for all the tests.
 * 
 * Creates connection with the run configurations in order to provide
 * capabilities to Appium server
 * 
 * @author md.ashrafiftekhar
 *
 */
public class BaseTest {
	protected AndroidDriver<MobileElement> driver;

	@BeforeClass
	public void beforeClass() {
		driver = Utils.getDriver();
		if (driver == null) {
			Assert.fail("Unable to create driver");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
