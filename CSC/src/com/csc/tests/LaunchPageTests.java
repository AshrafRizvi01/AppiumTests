/**
 * 
 */
package com.csc.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Contains functional tests for the CSC launch page
 * 
 * @author Ashraf Iftekhar, Feb 27, 2017
 */
public class LaunchPageTests extends BaseTest {

	@Test
	public void Check_Whether_tapping_the_Sign_in_button_proceeds_to_the_sign_in_screen() throws InterruptedException {
		// Tap on sign in button
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		driver.navigate().back();
	}

	@Test
	public void Check_Whether_tapping_the_Sign_up_button_proceeds_to_the_sign_up_screen() throws InterruptedException {
		// Tap on sign up button
		driver.findElement(By.id(id.SIGN_UP_BUTTON)).click();
		Thread.sleep(1000);
		driver.navigate().back();
	}
}
