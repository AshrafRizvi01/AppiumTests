package com.test.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class test {

	AppiumDriver<MobileElement> idriver;

	@Test
	public void d() {
		idriver = TestDriver.getiOSDriver("/Users/md.ashrafiftekhar/Downloads/Development.ipa", "iPhone",
				"cac802a746b60f9f7bb17b459ec45579e550f958", "9.3.1");
		System.out.println(idriver);
	}

	public static IOSDriver<MobileElement> getiOSDriver(String appPath, String DeviceName, String UDID,
			String iOSVersion) {
		IOSDriver<MobileElement> Driver = null;
		if (Driver == null) {
			File app = new File(appPath);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("deviceName", DeviceName);
			cap.setCapability("udid", UDID);
			cap.setCapability("platformVersion", iOSVersion);
			cap.setCapability("deviceName", DeviceName);
			cap.setCapability("platformName", "iOS");
			cap.setCapability("autoAcceptAlerts", true);
			// cap.setCapability("appActivity", LaunchActivity);

			// AppiumServiceBuilder builder = new
			// AppiumServiceBuilder().withCapabilities(cap);
			//
			// service = AppiumDriverLocalService.buildService(builder);
			//
			// service.start();

			try {
				Driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			Driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		return Driver;
	}

}
