/**
 * 
 */
package com.testing.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Captures Screenshots at different screens while in testing
 * 
 * @author Ashraf Iftekhar, Feb 24, 2017
 *
 */
public class Capture_Screenshots {

	/**
	 * Captures screenshot for Android tests
	 * 
	 * @param driver
	 * @param Name
	 * @return String Message
	 */
	public static String CaptureScreenshot(AndroidDriver<MobileElement> driver, String Name) {
		String destDir = "Screenshots";
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String FileName = dateFormat.format(new Date()) + "_" + Name + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + FileName));
			Name = "Successfully captured and saved as " + FileName;

		} catch (IOException e) {
			Name = "Unable to capture screenshots due to " + e;
		}
		return Name;
	}

	/**
	 * Captures screenshot for iOS tests
	 * 
	 * @param driver
	 * @param Name
	 * @return String Message
	 */
	public static String CaptureScreenshot(IOSDriver<MobileElement> driver, String Name) {
		String destDir = "Screenshots";
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + "_" + Name + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			Name = "Successfully captured and saved as " + destFile;
		} catch (IOException e) {
			Name = "Unable to capture screenshots due to " + e;
		}
		return Name;
	}

}
