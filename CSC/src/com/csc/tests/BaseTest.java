package com.csc.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.csc.constants.AndroidIds;
import com.csc.constants.Constants;
import com.testing.utils.Driver_Creation;

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

	// Driver
	AndroidDriver<MobileElement> driver;
	AndroidIds id = new AndroidIds();

	@BeforeClass
	public void beforeClass() {
		if (Constants.Platform == "Android") {
			driver = Driver_Creation.getAndroidDriver(Constants.apkPath, Constants.PackageName,
					Constants.LaunchActivity, Constants.AndroidVersion);
			if (driver == null) {
				Assert.fail("Unable to create driver");
			}
		} else {
			// driver = Driver_Creation.getiOSDriver(Constants.appPath,
			// Constants.DeviceName, Constants.UDID,
			// Constants.iOSVersion);
			if (driver == null) {
				Assert.fail("Unable to create driver");
			}
		}

	}
}
