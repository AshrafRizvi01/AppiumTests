package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage {

	AppiumDriver<MobileElement> driver;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;
	}

	@iOSFindBy(id = "something")
	@AndroidFindBy(id = "com.livingapps.mdashrafiftekhar.tasker:id/email")
	public WebElement Textbox_Email;

	@AndroidFindBy(id = "com.livingapps.mdashrafiftekhar.tasker:id/password")
	public WebElement Textbox_Password;

	@AndroidFindBy(id = "com.livingapps.mdashrafiftekhar.tasker:id/login")
	public WebElement Button_Login;

	public void login(String email, String password) throws InterruptedException {
		Textbox_Email.sendKeys(email);
		Textbox_Password.sendKeys(password);
		Button_Login.click();
		Thread.sleep(2000);
	}

	public boolean loginResults(AppiumDriver<MobileElement> driver) {
		HomePage homePage = new HomePage(driver);
		if (homePage.Name.isDisplayed())
			return true;
		else
			return false;
	}
}
