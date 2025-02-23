package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	AppiumDriver driver;
	WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.keep");
		options.setAppActivity(".activities.BrowseActivity");
		options.noReset();

		// Server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverUrl, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	@Test(priority = 1)
	public void addNoteTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Create a note")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("New text note")));
		driver.findElement(AppiumBy.accessibilityId("New text note")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
		driver.findElement(AppiumBy.id("editable_title")).sendKeys("Appium Project");
		driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Activity 2");
		Thread.sleep(Duration.ofSeconds(5));
		driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("toolbar")));

		String noteText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title' and @text='Appium Project']"))
				.getText();

		Assert.assertEquals(noteText, "Appium Project");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
