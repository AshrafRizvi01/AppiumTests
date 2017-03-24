/**
 * 
 */
package com.csc.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.csc.constants.Constants;
import com.testing.utils.Capture_Screenshots;
import com.testing.utils.SwipeFunctions;

/**
 * Contains functional tests for the CSC launch page
 * 
 * @author Ashraf Iftekhar, Feb 27, 2017
 */
public class LaunchPageTests extends BaseTest {

	@Test(priority = 0)
	public void Check_Whether_the_pages_change_after_swiping_the_screen_horrizontally() throws InterruptedException {
		// Swipe the page four times Right to Left and Left to Right
		for (int i = 0; i < 4; i++) {
			SwipeFunctions.swipingHorizontalL2R(driver);
			Capture_Screenshots.CaptureScreenshot(driver, "Swipe L2R" + i);
		}
		for (int i = 0; i < 4; i++) {
			SwipeFunctions.swipingHorizontalR2L(driver);
			Capture_Screenshots.CaptureScreenshot(driver, "Swipe R2L" + i);
		}
	}

	@Test
	public void Check_Whether_tapping_the_Sign_in_button_proceeds_to_the_sign_in_screen() throws InterruptedException {
		// Tap on sign in button
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.currentActivity(), Constants.LoginActivity);
		driver.navigate().back();
	}

	@Test
	public void Check_Whether_tapping_the_Sign_up_button_proceeds_to_the_sign_up_screen() throws InterruptedException {
		// Tap on sign up button
		driver.findElement(By.id(id.SIGN_UP_BUTTON)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.currentActivity(), Constants.SignUpActivity);
		driver.navigate().back();
	}
}
