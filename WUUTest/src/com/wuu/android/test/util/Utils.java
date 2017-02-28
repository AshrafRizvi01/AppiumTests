package com.wuu.android.test.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utils {

	private static final String apkPath = "/Users/md.ashrafiftekhar/Documents/WuuBuilds/base.apk";
	private static AndroidDriver<MobileElement> MobileDriver;

	/**
	 * Provides a singleton of {@link AndroidDriver} with the required
	 * capabilities
	 * 
	 * @return AndroidDriver instance to use for testing
	 */
	public static AndroidDriver<MobileElement> getDriver() {
		if (MobileDriver == null) {
			File app = new File(apkPath);
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", "Samsung");
			cap.setCapability("app", app.getAbsolutePath());
			cap.setCapability("appPackage", "com.wuu.android");
			cap.setCapability("appActivity", "com.wuu.android.feature.onboarding.launch.LaunchActivity");
			cap.setCapability("platformVersion", "6.0.1");
			try {
				MobileDriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			MobileDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		}
		return MobileDriver;
	}

	public static void takeScreenshot(AndroidDriver<MobileElement> driver, String TestName) {
		String destDir = "Screenshots";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdirs();
		String destFile = TestName + "_" + dateFormat.format(new Date()) + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks whether the element is visible or not?
	 * 
	 * @param id
	 *            Element Id (String)
	 * @return Returns boolean true or false
	 * 
	 * @author md.ashrafiftekhar
	 */
	public static Boolean checkVisibility(String id) {
		Boolean isElementPresent = false;
		try {
			isElementPresent = getDriver().findElement(By.id(id)).isDisplayed();
		} catch (Exception e) {
			System.out.println("Not found " + id);
		}

		return isElementPresent;
	}

	public static String getCode() throws InterruptedException {
		return ReadVerificationEmail.emailReader("mutualmobile333@gmail.com", "bl@ckb0x");
	}

	public static boolean proceedToEnterWuuTextScreen() throws InterruptedException {
		MobileDriver.findElement(By.id(Constants.SIGNIN_UP)).click();
		MobileDriver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("mutualmobile333@gmail.com" + "\n");
		Thread.sleep(1000);
		MobileDriver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		Thread.sleep(1000);
		String code = Utils.getCode() + "\n";
		MobileDriver.findElement(By.id(Constants.ENTER_CODE_EDITTEXT)).sendKeys(code);
		Thread.sleep(2000);
		MobileDriver.findElement(By.id(Constants.SKIP_BUTTON_CONTACTS)).click();
		Thread.sleep(1000);
		MobileDriver.findElement(By.id(Constants.FACEBOOK_SKIP)).click();
		Thread.sleep(1000);
		if (checkVisibility(Constants.SQUARE_BUTTON_ID) == true) {
			return true;
		} else {
			return false;
		}
	}

}
