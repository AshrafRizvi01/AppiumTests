package com.csc.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.csc.constants.Constants;
import com.testing.utils.Capture_Screenshots;

/**
 * Contains tests for Sign Up screen
 * 
 * @author Ashraf Iftekhar, Feb 28, 2017
 *
 */
public class SignUpPageTests extends BaseTest {

	@DataProvider(name = "RegData")
	public Object[][] dataprovider() {
		Object[][] obj = new Object[][] { { "a", "b", "a", "a@b.cz", "aaaaaa" },
				{ "abcde", "fghij", "email@mail", "aaaaaa" }, { "abcde", "fghij", "email@mail.com", "aaa" } };
		return obj;
	}

	@Test(dataProvider = "RegData")
	public void Check_SignUp_page_validation(String FirstName, String LastName, String Email, String Password)
			throws InterruptedException {
		driver.findElement(By.id(id.SIGN_UP_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(id.FIRST_NAME)).sendKeys(FirstName);
		driver.findElement(By.id(id.LAST_NAME)).sendKeys(LastName);
		driver.findElement(By.id(id.EMAIL)).sendKeys(Email);
		driver.findElement(By.id(id.PASSWORD)).sendKeys(Password);
		driver.findElement(By.id(id.CONFIRM_PASSWORD)).sendKeys(Password);
		driver.hideKeyboard();
		driver.findElement(By.id(id.CONTINUE)).click();
		Thread.sleep(1000);
		Capture_Screenshots.CaptureScreenshot(driver, "login");
		Assert.assertEquals(Constants.SignUpActivity, driver.currentActivity());
		driver.findElement(By.id(id.BACK_BUTTON)).click();
	}

	@Test
	public void User_can_access_the_sign_in_button() throws InterruptedException {
		driver.findElement(By.id(id.SIGN_UP_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(id.LOGIN_LINK)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.currentActivity(), Constants.LoginActivity);
		driver.findElement(By.id(id.BACK_BUTTON)).click();
	}

	@Test()
	public void Check_whether_user_can_Sign_up_successfully() throws InterruptedException {
		driver.findElement(By.id(id.SIGN_UP_BUTTON)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(id.FIRST_NAME)).sendKeys("FirstName");
		driver.findElement(By.id(id.LAST_NAME)).sendKeys("LastName");
		driver.findElement(By.id(id.EMAIL)).sendKeys("Email");
		driver.findElement(By.id(id.PASSWORD)).sendKeys("Password");
		driver.findElement(By.id(id.CONFIRM_PASSWORD)).sendKeys("Password");
		driver.hideKeyboard();
		driver.findElement(By.id(id.CONTINUE)).click();
		Thread.sleep(1000);
		Capture_Screenshots.CaptureScreenshot(driver, "login");
		Assert.assertEquals(Constants.UploadPhotoActivity, driver.currentActivity());

	}

}
