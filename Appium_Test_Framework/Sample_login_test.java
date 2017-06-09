import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utils.TestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Sample_login_test {

	AndroidDriver<MobileElement> driver;

	@BeforeMethod
	public void b() {
		driver = TestDriver.getAndroidDriver("/Users/md.ashrafiftekhar/Desktop/app-debug.apk",
				"speakingapp.howlerr.com.howlerr", "speakingapp.howlerr.com.howlerr.LoginActivity", "7.1.2");
	}

	@Test(dataProvider = "dp")
	public void g(String Str, int i, String Error) {

		WebElement error = driver.findElement(By.id("txt_addMobile"));
		WebElement Code = driver.findElement(By.id("editText_countryCode"));
		WebElement Phone = driver.findElement(By.id("editText_phoneNumber"));

		Code.sendKeys("" + i);
		Phone.sendKeys(Str);

		Assert.assertEquals(Error, error.getText());
	}

	@DataProvider
	public Object[][] dp() {
		Object[][] obj = { { "", 1, "Error" }, { "99707272", 2, "Success" } };
		return obj;
	}

}
