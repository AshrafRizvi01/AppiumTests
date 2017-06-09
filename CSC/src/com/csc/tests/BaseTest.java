package com.csc.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.csc.constants.AndroidIds;
import com.csc.constants.Constants;
import com.testing.utils.Driver_Creation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

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
	IOSDriver<MobileElement> driver;
	AndroidIds id = new AndroidIds();

	@BeforeClass
	public void beforeClass() {
		if (Constants.Platform == "Android") {
			driver = Driver_Creation.getiOSDriver("/Users/md.ashrafiftekhar/Downloads/Development.ipa", "iPhone",
					"19163ccbccc5d7cff7dec2f53807b3957a813c46", "10.2.1");
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
