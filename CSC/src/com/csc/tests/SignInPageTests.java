/**
 * 
 */
package com.csc.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.csc.constants.Constants;
import com.testing.utils.AppElements;
import com.testing.utils.Capture_Screenshots;

/**
 * Contains tests for Sign In screen
 * 
 * @author Ashraf Iftekhar, Feb 28, 2017
 *
 */
public class SignInPageTests extends BaseTest {
	boolean EmailErrorVisible = true;
	boolean PasswordErrorVisible = true;
	String EmailId = "mutualmobile333@gmail.com";
	String PasswordUsed = "aaaaaa";

	@DataProvider(name = "loginData")
	public Object[][] dataprovider() {
		Object[][] obj = new Object[][] { { "a@b", "aaa", true, true }, { "a@b@fg", "aaaaaa", true, false },
				{ "a@b.co", "aaaa", false, true }, { "aa@bb.cc", "asasasas", false, false } };
		return obj;
	}

	@Test(dataProvider = "loginData")
	public void Check_SignIn_page_validation(String Email, String Password, boolean emailErr, boolean passErr)
			throws InterruptedException {
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(id.EMAIL_TEXTBOX)).sendKeys(Email);
		driver.findElement(By.id(id.PASSWORD_TEXTBOX)).sendKeys(Password);
		driver.hideKeyboard();
		driver.findElement(By.id(id.LOGIN_BUTTON)).click();
		Thread.sleep(1000);
		Capture_Screenshots.CaptureScreenshot(driver, "login");
		if (emailErr == true) {
			EmailErrorVisible = AppElements.checkVisibility(driver.findElement(By.xpath(id.EMAIL_ERROR)));
			Assert.assertEquals(emailErr, EmailErrorVisible);
		}
		if (passErr == true) {
			PasswordErrorVisible = AppElements.checkVisibility(driver.findElement(By.xpath(id.PASSWORD_ERROR)));
			Assert.assertEquals(passErr, PasswordErrorVisible);
		}

		Thread.sleep(1000);
		driver.navigate().back();
	}

	@Test
	public void Check_whether_user_can_login_successfully() throws InterruptedException {
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(id.EMAIL_TEXTBOX)).sendKeys(EmailId);
		driver.findElement(By.id(id.PASSWORD_TEXTBOX)).click();
		driver.findElement(By.id(id.PASSWORD_TEXTBOX)).sendKeys(PasswordUsed);
		driver.hideKeyboard();
		driver.findElement(By.id(id.LOGIN_BUTTON)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.currentActivity(), Constants.HomeActivity);
		driver.findElement(By.xpath(id.HAMBURGER_ICON)).click();
		driver.findElement(By.id(id.SIGNOUT)).click();
		Thread.sleep(1000);
	}

	@Test
	public void Ensure_that_after_clicking_the_create_new_button_user_is_redircted_to_Sign_Up_screen()
			throws InterruptedException {
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(id.CREATE_NEW_BUTTON)).click();
		Thread.sleep(1000);
		Assert.assertEquals(Constants.SignUpActivity, driver.currentActivity());
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();

	}

	@Test
	public void Ensure_that_after_clicking_the_Forgot_Password_button_user_is_redircted_to_ForgotPassword_screen()
			throws InterruptedException {
		driver.findElement(By.id(id.SIGN_IN_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(id.FORGOT_PASSWORD_BUTTON)).click();
		Thread.sleep(1000);
		Assert.assertEquals(AppElements.checkVisibility(driver.findElement(By.id(id.WEBVIEW))), true);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();

	}

}
