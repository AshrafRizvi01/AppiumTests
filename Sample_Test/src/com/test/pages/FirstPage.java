package com.test.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FirstPage {

	@AndroidFindBy(id = "org.cscpbc.parenting:id/splash_log_in")
	public MobileElement SignIn_Button;

	@AndroidFindBy(id = "org.cscpbc.parenting:id/splash_sign_up")
	public MobileElement SignUp_Button;

	public FirstPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 2, TimeUnit.SECONDS), this);
	}

	public void Click_login() {
		SignIn_Button.click();
	}
}