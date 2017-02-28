package com.testing.utils;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileDriver;

public class SwipeFunctions {

	public static Dimension size;

	public static void swipingHorizontalL2R(MobileDriver driver) throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		// Swipe from Left to Right.
		driver.swipe(endx, starty, startx, starty, 3000);
		Thread.sleep(2000);
	}

	public static void swipingHorizontalR2L(MobileDriver driver) throws InterruptedException {
		// Get the size of screen.
		size = driver.manage().window().getSize();
		System.out.println(size);

		// Find swipe start and end point from screen's with and height.
		// Find startx point which is at right side of screen.
		int startx = (int) (size.width * 0.70);
		// Find endx point which is at left side of screen.
		int endx = (int) (size.width * 0.30);
		// Find vertical point where you wants to swipe. It is in middle of
		// screen height.
		int starty = size.height / 2;

		// Swipe from Right to Left.
		driver.swipe(startx, starty, endx, starty, 3000);
		Thread.sleep(2000);
	}

}
