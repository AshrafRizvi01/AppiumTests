package com.test.utils;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Contains functions for right to left and Left to right swipe actions
 * 
 * @author Ashraf Iftekhar, Mar 30, 2017
 *
 */
public class SwipeFunctions {

	public static Dimension size;

	/**
	 * Provides a Left to right horizontal swipe in 1 seconds
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void LeftToRightHorrizontalSwipe(AppiumDriver<MobileElement> driver) throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.90);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		// Swipe from Left to Right.
		driver.swipe(endx, starty, startx, starty, 1000);
		Thread.sleep(2000);
	}

	/**
	 * Provides a Left to right horizontal swipe in 1 seconds
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void RightToLeftHorizontalSwipes(AppiumDriver<MobileElement> driver) throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.90);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		// Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 1000);
		Thread.sleep(2000);
	}

}
