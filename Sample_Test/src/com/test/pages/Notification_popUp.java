package com.test.pages;

import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Notification_popUp extends BaseTest {

	public Notification_popUp(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id = "android:id/button1")
	public MobileElement Allow_button;

	public boolean isNotificationPopup() {
		try {
			Allow_button.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
