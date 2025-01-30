package activities;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {
	
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.messaging");
		options.setAppActivity(".ui.ConversationListActivity");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void createNewMessage() {
		driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();
		driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9842467266");
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
		driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
		driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();
		
		String message=driver.findElement(AppiumBy.id("com.google.android.apps.messaging:id/message_text")).getText();
		System.out.println("Sent message: "+message);
		Assert.assertEquals(message, "Hello from Appium");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
