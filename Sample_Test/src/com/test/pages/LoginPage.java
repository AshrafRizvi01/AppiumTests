package com.test.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest {

	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "org.cscpbc.parenting:id/email")
	public MobileElement Textbox_Email;

	@AndroidFindBy(id = "org.cscpbc.parenting:id/password")
	public MobileElement Textbox_Password;

	@AndroidFindBy(id = "org.cscpbc.parenting:id/login_button")
	public MobileElement Continue_button;

	public void proceedToLoginPage() {
		FirstPage fp = new FirstPage(driver);
		fp.Click_login();
	}

	public void login(String email, String password, AppiumDriver<MobileElement> driver) throws InterruptedException {

		Thread.sleep(1000);
		Textbox_Email.sendKeys(email);
		Textbox_Password.sendKeys(password);
		driver.hideKeyboard();
		Continue_button.click();
		Thread.sleep(2000);
	}

}
