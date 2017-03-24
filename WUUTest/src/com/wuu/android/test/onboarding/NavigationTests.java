package com.wuu.android.test.onboarding;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wuu.android.test.BaseTest;
import com.wuu.android.test.util.Constants;
import com.wuu.android.test.util.Utils;

/**
 * Tests navigation flow for on-boarding screens
 * 
 * @author Ashraf Iftekhar, Jan 23, 2017
 *
 */
public class NavigationTests extends BaseTest {

	@Test(priority = 0)
	/**
	 * Tests if the user can navigate to and from the what is Wuu screen
	 * 
	 * @throws InterruptedException
	 * 
	 * @author Ashraf Iftekhar, Jan 23, 2017
	 */
	public void canNavigateToAndFrom_WhatIsWuu() throws InterruptedException {
		driver.findElement(By.id(Constants.WHATISWUU_BUTTON)).click();
		Thread.sleep(1000);
		driver.scrollTo("Paul Budnitz");
		Utils.takeScreenshot(driver, "Navigate To What is wuu");
		driver.findElement(By.id(Constants.CLOSE_IMAGE)).click();

		driver.findElement(By.id(Constants.WHATISWUU_BUTTON)).click();
		driver.navigate().back();
		Thread.sleep(1000);

		// driver.navigate().back();
		// Thread.sleep(1000);
		// ((AndroidDriver)
		// driver).pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);

		driver.findElement(By.id(Constants.SIGNIN_UP)).click();
		driver.navigate().back();
	}

	@Test(priority = 1)
	public void canNavigateToAndFrom_WhatsYourEmail() throws InterruptedException {
		driver.findElement(By.id(Constants.SIGNIN_UP)).click();
		driver.navigate().back();
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.SIGNIN_UP)).click();
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest@yopmail.com" + "\n");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void checkYourEmail() throws InterruptedException {
		driver.findElement(By.id(Constants.SIGNIN_UP)).click();
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest@yopmail.com" + "\n");
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.TRY_AGAIN)).click();
		Thread.sleep(1000);
		if (Utils.checkVisibility(Constants.ENTER_EMAIL_EDITTEXT) == false) {
			Assert.fail("Element Not Found");
		} else {
			driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest@yopmail.com" + "\n");
			Thread.sleep(1000);
		}

		driver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(priority = 3)
	public void enterCode() throws InterruptedException {
		driver.findElement(By.id(Constants.SIGNIN_UP)).click();
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest@yopmail.com" + "\n");
		Thread.sleep(1000);
		driver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		driver.findElement(By.id(Constants.TRY_AGAIN_CODE)).click();
		driver.findElement(By.id(Constants.ENTER_EMAIL_EDITTEXT)).sendKeys("abctest@yopmail.com" + "\n");
		driver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		if (Utils.checkVisibility(Constants.ENTER_IT_HERE) == false) {
			Assert.fail();
		} else {
			driver.findElement(By.id(Constants.ENTER_IT_HERE)).click();
		}
		String code = Utils.getCode() + "\n";
		driver.findElement(By.id(Constants.ENTER_CODE_EDITTEXT)).sendKeys(code);
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void proceedToHome() throws InterruptedException {
		if (Utils.checkVisibility(Constants.SKIP_BUTTON_CONTACTS) == true) {
			driver.findElement(By.id(Constants.SKIP_BUTTON_CONTACTS)).click();
			driver.navigate().back();
			driver.findElement(By.id(Constants.CONNECT_CONTACTS_BUTTON)).click();
			Thread.sleep(2000);
			driver.findElement(By.id(Constants.FACEBOOK_SKIP)).click();
		}
	}

}
