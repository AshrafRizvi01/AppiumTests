package com.test.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends BaseTest {

	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[6]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")
	public MobileElement iOS_NotificationButton;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextField[1]")
	@AndroidFindBy(id = "org.cscpbc.parenting:id/email")
	public MobileElement Textbox_Email;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIASecureTextField[1]")
	@AndroidFindBy(id = "org.cscpbc.parenting:id/password")
	public MobileElement Textbox_Password;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIAButton[1]")
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
