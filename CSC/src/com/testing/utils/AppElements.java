/**
 * 
 */
package com.testing.utils;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Finds elements for iOS and Android depending upon their drivers
 * 
 * @author Ashraf Iftekhar, Feb 24, 2017
 *
 */
public class AppElements {

	/**
	 * Gets AndroidElement for the given id
	 * 
	 * @param driver
	 * @param id
	 * @return AndroidElement
	 */
	public static MobileElement getElement(AndroidDriver<MobileElement> driver, String id) {
		MobileElement Element = driver.findElement(By.id(id));
		return Element;
	}

	/**
	 * Gets iOSElement for the given id
	 * 
	 * @param driver
	 * @param id
	 * @return iOSElement
	 */
	public static MobileElement getElement(IOSDriver<MobileElement> driver, String id) {
		MobileElement Element = driver.findElement(By.id(id));
		return Element;
	}

	/**
	 * Checks whether the element is visible or not?
	 * 
	 * @param Element
	 *            Element Id (AndroidElement)
	 * @return Returns boolean true or false
	 * 
	 * @author md.ashrafiftekhar
	 */
	public static Boolean checkVisibility(MobileElement Element) {
		Boolean isElementPresent = false;
		try {
			isElementPresent = Element.isDisplayed();
		} catch (Exception e) {
			System.out.println("Not found " + Element);
		}

		return isElementPresent;
	}
}
