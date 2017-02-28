import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Search {
	// AndroidDriver drive;
	AndroidDriver driver;
	Dimension size;
	String destDir;
	DateFormat dateFormat;

	@Test(dataProvider = "dp", enabled = false)
	public void fisrt_screen_test(String expected, String actual) throws IOException, InterruptedException {
		// test case for Email screen
		WebElement email = driver.findElement(By.id("enter_email_edit_text"));
		email.sendKeys(actual + "\n");
		Thread.sleep(1000);

		String temp = driver.findElement(By.id("error_text")).getText();
		takeScreenShot();
		if (temp == "") {
			driver.navigate().back();
		}
		Assert.assertEquals(temp, expected);
		// org.testng.Assert.assertEquals("Invalid Email", ;

	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "Invalid Email", "k" }, new Object[] { "Invalid Email", "a" },
				new Object[] { "Invalid Email", "  " }, new Object[] { "Invalid Email", "ashraf.rizvi" },
				new Object[] { "Invalid Email", "ashraf rizvi" }, };
	}

	@Test(enabled = false)
	public void CheckYourEmail() throws InterruptedException {
		WebElement email = driver.findElement(By.id("enter_email_edit_text"));
		email.sendKeys("ashrafrizvi3006@gmail.com" + "\n");
		Thread.sleep(1000);
		String checkemailtext = driver.findElement(By.id("com.wuu.android:id/check_email_textview")).getText();
		Assert.assertEquals(checkemailtext, "Check " + "\n" + "your " + "\n" + "email!");
		String magiclinktext = driver.findElement(By.id("com.wuu.android:id/tap_magic_link_text")).getText();
		Assert.assertEquals(magiclinktext, "Tap the magic link we emailed you to join Wuu.");
		driver.findElement(By.id("com.wuu.android:id/enter_here_text")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.currentActivity(), ".feature.onboarding.code.CodeActivity");
		System.out.println(driver.currentActivity());
		driver.navigate().back();
		driver.findElement(By.id("com.wuu.android:id/try_again_text")).click();
		Thread.sleep(1000);
		System.out.println(driver.currentActivity());
		Assert.assertEquals(driver.currentActivity(), ".feature.onboarding.email.EmailActivity");

	}

	@Test
	public void code() throws InterruptedException {
		WebElement codetextbox = driver.findElement(By.id("com.wuu.android:id/enter_code_edit_text"));
		codetextbox.sendKeys("" + "\n");
		Assert.assertEquals(driver.findElement(By.id("com.wuu.android:id/error_text")).getText(), "Invalid Magic Code");
		driver.getKeyboard();
		Thread.sleep(1000);
		takeScreenShot();
		codetextbox.sendKeys("123456" + "\n");
		try {
			driver.findElement(By.id("com.wuu.android:id/error_text")).getText();
			Assert.fail();
		} catch (Exception e) {

		}
		driver.findElement(By.id("com.wuu.android:id/try_again_text")).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.currentActivity(), ".feature.onboarding.email.EmailActivity");
	}

	@BeforeMethod
	public void before() throws InterruptedException {
		WebElement email = driver.findElement(By.id("enter_email_edit_text"));
		email.sendKeys("ashrafrizvi3006@gmail.com" + "\n");
		Thread.sleep(1000);
		driver.findElement(By.id("com.wuu.android:id/enter_here_text")).click();
		Thread.sleep(1000);
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		String apkpath = "/Users/md.ashrafiftekhar/Documents/WuuBuilds/wuu-android-devServerDebug-0.0.1-a64e9ea.apk";
		File app = new File(apkpath);

		DesiredCapabilities cap = new DesiredCapabilities();
		// capabilities.setCapability("BROWSER_NAME", "Android");
		// cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "0715f78909b62336");
		// cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("app", app.getAbsolutePath());
		cap.setCapability("appPackage", "com.wuu.android");
		cap.setCapability("appActivity", "com.wuu.android.feature.onboarding.launch.LaunchActivity");
		// capabilities.setCapability("automationName", "Appium");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		// test cases for the first screen:
		Thread.sleep(1000);
		takeScreenShot();
		// driver.findElement(By.id(WuuConstants.WHATISWUU_BUTTON_ID)).click();
		Thread.sleep(1000);
		// takeScreenShot();

		// driver.scrollTo("Paul Budnitz");
		Thread.sleep(1000);
		// takeScreenShot();
		Thread.sleep(2000);
		driver.findElement(By.id("close_image")).click();
		driver.findElement(By.id("sign_in_up_button")).click();
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
		driver.quit();
	}
}
