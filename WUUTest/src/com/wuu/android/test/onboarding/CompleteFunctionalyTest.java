package com.wuu.android.test.onboarding;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wuu.android.test.BaseTest;
import com.wuu.android.test.util.Constants;
import com.wuu.android.test.util.ReadVerificationEmail;
import com.wuu.android.test.util.Utils;

import io.appium.java_client.MobileElement;

/**
 * Tests Complete functionality test for WUU Android
 * 
 * @author Ashraf Iftekhar, Feb 13, 2017
 *
 */

public class CompleteFunctionalyTest extends BaseTest {

	@Test(priority = 0)
	public void check_whether_the_starts_with_the_SignIn_or_up_screen() {
		// Compare the actual activity with the expected activity
		Assert.assertEquals(driver.currentActivity(), Constants.LAUNCH_ACTIVITY);
		Utils.takeScreenshot(driver, "0");
	}

	@Test(priority = 1)
	public void check_whether_the_sign_in_button_proceeds_to_Whats_your_email_screen() {
		// Click the sign up button
		driver.findElement(By.id(Constants.SIGNIN_UP)).click();

		// Check the current activity is "What's Your Email" Screen or not
		Assert.assertEquals(driver.currentActivity(), Constants.EMAIL_ACTIVITY);
	}

	@Test(priority = 2)
	public void check_whether_entering_wrong_emails_proides_proper_error_message() throws InterruptedException {
		String errMsg = "";
		// Enter an invalid email
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest" + "\n");
		// Verify the results
		errMsg = driver.findElement(By.id("error_text")).getText();
		Utils.takeScreenshot(driver, "2");
		Assert.assertEquals(errMsg, "Invalid Email");

		// Again Enter an invalid email
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("1234455@3434@323" + "\n");
		// verifying the results
		errMsg = driver.findElement(By.id("error_text")).getText();
		Utils.takeScreenshot(driver, "2");
		Assert.assertEquals(errMsg, "Invalid Email");
	}

	@Test(priority = 3)
	public void check_whether_the_user_can_signIn_or_up_without_any_issue() throws InterruptedException {
		// Enter an invalid email
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys(Constants.EMAIL_ID + "\n");
		Thread.sleep(10000);
		// Get and enter the codes
		String code = ReadVerificationEmail.emailReader("mutualmobile333@gmail.com", "bl@ckb0x") + "\n";
		driver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.ENTER_CODE_EDITTEXT)).sendKeys(code);
		Thread.sleep(10000);
		if (driver.currentActivity() != Constants.ADD_CONTACTS_ACTIVITY) {
			code = ReadVerificationEmail.emailReader("mutualmobile333@gmail.com", "bl@ckb0x") + "\n";
			driver.findElement(By.id(Constants.ENTER_CODE_EDITTEXT)).sendKeys(code);
			Thread.sleep(5000);
		}
		if (Constants.IS_NEW_USER == true) {

		}
	}

	@Test(priority = 4)
	public void check_whether_user_can_access_contacts_and_proceed_to_stream_screen() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id(Constants.CONNECT_CONTACTS_BUTTON)).click();
		Thread.sleep(2000);
		if (Utils.checkVisibility(Constants.ALLOW_BUTTON) == true) {
			driver.findElement(By.id(Constants.ALLOW_BUTTON)).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(driver.currentActivity(), Constants.ADD_FB_CONTACTS_ACTIVITY);
		driver.findElement(By.id(Constants.FACEBOOK_SKIP)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.currentActivity(), Constants.STREAM_ACTIVITY);
	}

	@Test(priority = 5)
	public void check_whether_user_can_successfully_write_and_post_a_text_wuu() throws InterruptedException {
		driver.findElement(By.id(Constants.SQUARE_BUTTON_ID)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.TEXT_WUU_EDITTEXT_ID)).sendKeys("This is a test post");
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.FORWARD_BUTTON_ID)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.currentActivity(), Constants.SEND_TO_ACTIVITY);
		// get list items
		List<MobileElement> list = driver.findElements(By.id("send_to_list"));
		for (int i = 0; i <= list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
	}

}
