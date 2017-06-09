
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.experitest.appium.*;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class test {
	private String host = "localhost";
	private int port = 8889;
	private String reportDirectory = "reports";
	private String reportFormat = "xml";
	private String testName = "Untitled";
	protected SeeTestIOSDriver<SeeTestIOSElement> driver = null;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
		dc.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
		dc.setCapability(SeeTestCapabilityType.TEST_NAME, testName);
		dc.setCapability(MobileCapabilityType.UDID, "3e3f9f3600b06de45ce6b8d2e2548bdefa512002");
		dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.bassforecast.bassforecastApp");
		driver = new SeeTestIOSDriver<>(new URL("http://" + host + ":" + port), dc);
	}

	@Test
	public void testUntitled() {
		driver.findElement(By.xpath("//*[@class='UIAWindow' and ./*[@class='UIAStatusBar']]")).click();
		driver.findElement(By.xpath("//*[@text='SIGN IN']")).click();
		driver.findElement(By.xpath("//*[@placeholder='Email']")).sendKeys("lunch@yopmail.com");
		new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder='Password']")));
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("aaaaaa");
		driver.findElement(By.xpath("//*[@text='SIGN IN']")).click();
		driver.findElement(By.xpath("//*[@text='OK']")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}