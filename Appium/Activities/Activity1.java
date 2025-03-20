package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2"); // get current package under commands in appium inspector
		options.setAppActivity(".Calculator"); //get current activity under commands in appium inspector
		options.noReset();
		
        URL serverURL=new URI("http://localhost:4723").toURL();
		
		//Initialize the driver
		driver= new AndroidDriver(serverURL, options);
	}
	
	@Test
	public void multiplyTest() {
		driver.findElement(AppiumBy.id("digit_6")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"×\"]")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result= driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("Result is "+result);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
