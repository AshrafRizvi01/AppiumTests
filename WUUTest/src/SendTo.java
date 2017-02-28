import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

/**
 * 
 * @author Ashraf Iftekhar, Jan 23, 2017
 *
 */
public class SendTo {

	@SuppressWarnings("rawtypes")
	AndroidDriver driver;
	String APK_PATH = "/Users/md.ashrafiftekhar/Documents/WuuBuilds/wuu-android-devServerDebug-0.0.1-a64e9ea.apk";
	String DEVICE_NAME = "00f613f88244c6a1";
	String PACKAGE = "com.wuu.android";
	String ACTIVITY = "com.wuu.android.feature.onboarding.launch.LaunchActivity";
	String EMAIL = "cooltester1@yopmail.com";
	Object[] contactlist;
	String destDir;
	DateFormat dateFormat;

	@Test
	public void f() throws InterruptedException {
		// Already on the SendTo page
		// List of contacts:
		@SuppressWarnings("unchecked")
		List<AndroidElement> textViews = driver.findElements(By.id("com.wuu.android:id/item_name_text"));
		for (WebElement textView : textViews) {

			textView.click();
			System.out.println(textView.getText());
			try {
				driver.findElement(By.id("com.wuu.android:id/send_text")).getText();
			} catch (Exception e) {
				Assert.fail("Send Not Available: " + textView.getText());
			}
			Thread.sleep(1000);
			takeScreenShot();

			textView.click();
			System.out.println(textView.getText());
			try {
				driver.findElement(By.id("com.wuu.android:id/send_text")).getText();
			} catch (Exception e) {
				System.out.println("Passed for: " + textView.getText());
			}
		}

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// click signIn button
		driver.findElement(By.id("sign_in_up_button")).click();
		// Enter a valid email
		driver.findElement(By.id("enter_email_edit_text")).sendKeys(EMAIL + "\n");
		// Select Enter code
		driver.findElement(By.id("com.wuu.android:id/enter_here_text")).click();
		// Enter the text Manually waiting for 10 seconds
		Thread.sleep(10000);
		// check code entered and proceeded to Home
		System.out.print("Enter code:");
		String X = driver.currentActivity().toString();
		if (X != ".feature.onboarding.whatiswuu.WhatIsWuuActivity")
			;
		{
			System.out.println("Enter code Manually");
			Thread.sleep(20000);

			System.out.println("Kindly Enter the code and move forward in 20 Seconds...");
			Thread.sleep(20000);

			System.out.println("Time expired");

		}

		// Click on the Square icon
		driver.findElement(By.id("com.wuu.android:id/send_text_wuu")).click();
		// Enter text in the text box
		driver.findElement(By.id("com.wuu.android:id/text_wuu")).sendKeys("Testing...");
		// Click the '>' icon
		driver.findElement(By.id("com.wuu.android:id/action_go")).click();
		// Wait for some time to load all contacts
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@SuppressWarnings("rawtypes")
	@BeforeClass
	public void beforeClass() {

		// Providing data to appium server
		File app = new File(APK_PATH);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", DEVICE_NAME);
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("appPackage", PACKAGE);
		cap.setCapability("appActivity", ACTIVITY);
		cap.setCapability("platformVersion", "7.1.1");
		// Connecting the server on the following URL
		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

	public void takeScreenShot() {
		// Set folder name to store screenshots.
		destDir = "Screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to
		// destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		// Quiting the app
		driver.quit();
	}

}
