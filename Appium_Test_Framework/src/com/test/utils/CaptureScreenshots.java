package com.test.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Captures screenshot during the test for both iOS and Android Devices
 *
 * @author Ashraf Iftekhar, Mar 27, 2017
 *
 */
public class CaptureScreenshots {

	/**
	 * Captures screenshot during the test
	 *
	 * @param driver
	 *            Android Driver
	 * @param TestName
	 *            Name of the test to add in the screenshot name
	 * @author Ashraf Iftekhar, Mar 27, 2017
	 *
	 */
	public static void takeScreenshot(AndroidDriver<MobileElement> driver, String TestName) {
		String destDir = "Screenshots";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String destFile = "Android" + TestName + "_" + dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Captures screenshot during the test
	 * 
	 * @param driver
	 *            Android Driver
	 * @param TestName
	 *            Name of the test to add in the screenshot name
	 * 
	 * @author Ashraf Iftekhar, Mar 27, 2017
	 *
	 */
	public static void takeScreenshot(IOSDriver<MobileElement> driver, String TestName) {
		String destDir = "Screenshots";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String destFile = "iOS" + TestName + "_" + dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
