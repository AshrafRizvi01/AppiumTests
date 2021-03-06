package com.testing.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Creates driver for iOS and Android devices in order to execute Appium tests.
 * 
 * @author Ashraf Iftekhar, Feb 24, 2017
 *
 */
public class Driver_Creation {

	public static AndroidDriver<MobileElement> driver;
	public static IOSDriver<MobileElement> iDriver;

	/**
	 * Returns driver for Android devices in order to execute Appium tests on
	 * android devices.
	 * 
	 * @param apkPath
	 *            Path of the APK file in the system
	 * @param PackageName
	 *            Name of Package
	 * @param LaunchActivity
	 *            Path of Main Activity
	 * @param AndroidVersion
	 *            Device Software Version
	 * @return AndroidDriver
	 * 
	 * @author Ashraf Iftekhar, Feb 24, 2017
	 */
	public static AndroidDriver<MobileElement> getAndroidDriver(String apkPath, String PackageName,
			String LaunchActivity, String AndroidVersion) {
		if (driver == null) {
			File app = new File(apkPath);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("appPackage", PackageName);
			cap.setCapability("appActivity", LaunchActivity);
			cap.setCapability("platformVersion", AndroidVersion);
			cap.setCapability("deviceName", "testdevice");
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		return driver;
	}

	/**
	 * Returns driver for iOS devices in order to execute Appium tests on iOS
	 * devices.
	 * 
	 * @param appPath
	 *            Path of the IPA or APP file in the system
	 * @param DeviceName
	 *            Name of Package
	 * @param UDID
	 *            Path of Main Activity
	 * @param iOSVersion
	 *            Device Software Version
	 * @return IOSDriver
	 * 
	 * @author Ashraf Iftekhar, Feb 24, 2017
	 */
	public static IOSDriver<MobileElement> getiOSDriver(String appPath, String DeviceName, String UDID,
			String iOSVersion) {
		if (iDriver == null) {
			File app = new File(appPath);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("ForceDevice", DeviceName);
			cap.setCapability("UDID", UDID);
			cap.setCapability("platformVersion", iOSVersion);
			cap.setCapability("deviceName", "testdevice");
			try {
				iDriver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			iDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		return iDriver;
	}

}
