package com.wuu.android.test.onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wuu.android.test.BaseTest;
import com.wuu.android.test.util.Constants;
import com.wuu.android.test.util.Utils;

/**
 * Contains tests for the Wuu TextEdit Activity
 * 
 * @author Mohammad Ashraf
 **/
public class TextResizeTests extends BaseTest {

	WebElement WuuTextEdit = null;

	@BeforeMethod
	public void before() throws InterruptedException {
		if (WuuTextEdit == null) {
			if (Utils.proceedToEnterWuuTextScreen() == true) {
				driver.findElement(By.id(Constants.SQUARE_BUTTON_ID)).click();
				Thread.sleep(1000);
			} else {
				Assert.fail("Failed to proceed Home screen");
			}
		}
	}

	/**
	 * Provide data to {@link checkWhetherTheTextsAreResizingProperly} method
	 * 
	 * @throws InterruptedException
	 * @author Mohammad Ashraf
	 */
	@DataProvider(name = "getWuuTexts")
	public Object[][] getWuuTexts() {
		return new Object[][] { new Object[] { "Hello World", "Two Words" },
				new Object[] { "Hello, How are you", "Sentence" },
				new Object[] {
						"Hello, Hope you are doing fine and I was just trying to provide some #oooo. $$$$ 77777 really nice and new things garbage",
						"Small Para" },
				new Object[] {
						"She Shoulda Said No is a 1949 exploitation film in the spirit of morality tales such as the 1936 films Reefer Madness and Marihuana. Directed by Sam Newfield (listed as Sherman Scott) and starring Lila Leeds, it was inspired by the 1948 arrest of movie stars Robert Mitchum and Leeds for marijuana possession. The actors, along with two others, were arrested after smoking marijuana at Leeds home and were charged with the felony of narcotics possession. Public empathy for Mitchum resulted in his charge being downgraded, and his sentence of sixty days in jail was set aside in 1951. Leeds served sixty days in prison, and after her release found no work in Hollywood until she was cast in this film. The film was issued under many titles and struggled to find a distributor until film presenter Kroger Babb reissued it as The Story of Lila Leeds and Her Exposé of the Marijuana Racket. It failed to achieve success under that title, and Babb eventually changed it to She Shoulda Said No! https://www.gogle.com yes",
						"long Para + Links" },
				new Object[] {
						"This site is probably more in lines of what you are looking for. Few type sizes, modernism, minimalism and up to date with the rest of the web. Almost type only but features an (extremely smart set) picture at the bottom of the first page... https://makingmusic.ableton.com/",
						"Para from websites" } };
	}

	/**
	 * Checks whether the text in the text box shrinks properly when the string
	 * gets bigger
	 * 
	 * @param Text
	 * @param TestName
	 * @throws InterruptedException
	 * @author Mohammad Ashraf
	 */
	@Test(dataProvider = "getWuuTexts", priority = 0)
	public void checkWhetherTheTextsAreResizingProperly(String Text, String TestName) throws InterruptedException {
		WuuTextEdit = driver.findElement(By.id(Constants.TEXT_WUU_EDITTEXT_ID));
		WuuTextEdit.sendKeys(Text);
		Thread.sleep(1000);
		Utils.takeScreenshot(driver, TestName);
		WuuTextEdit.clear();
	}

	/**
	 * Checks whether x and > buttons are located properly while entering the
	 * text and hiding the keypad.
	 * 
	 * @throws InterruptedException
	 * @author Mohammad Ashraf
	 */
	@Test(priority = 1)
	public void checkWhetherTheButtonsAreProperlyLocated() throws InterruptedException {
		WuuTextEdit = driver.findElement(By.id(Constants.TEXT_WUU_EDITTEXT_ID));
		WuuTextEdit.click();
		driver.navigate().back();
		Thread.sleep(1000);
		Utils.takeScreenshot(driver, "Buttons Test on write a wuu screen");
		WuuTextEdit.click();
		WuuTextEdit.sendKeys("yes");
		Utils.takeScreenshot(driver, "Buttons Test on write a wuu screen");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		Utils.takeScreenshot(driver, "Buttons Test on write a wuu screen");
	}
}
