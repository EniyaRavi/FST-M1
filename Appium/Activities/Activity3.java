package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {
	
	AppiumDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppActivity(".Calculator");
		options.setAppPackage("com.android.calculator2");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
	}
	
	@Test
	public void additionTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String addResult=driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("5+9 = "+addResult);
		
		Assert.assertEquals(addResult, "14");
		
	}
	
	@Test
	public void subtractionTest() {
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String subtractResult=driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("10-5 = "+subtractResult);
		
		Assert.assertEquals(subtractResult, "5");
		
	}
	
	@Test
	public void multiplyTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("op_mul")).click();
		driver.findElement(AppiumBy.id("digit_1")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String multiplyResult=driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("5x100 = "+multiplyResult);
		
		Assert.assertEquals(multiplyResult, "500");	
	}
	
	@Test
	public void divideTest() {
		driver.findElement(AppiumBy.id("digit_5")).click();
		driver.findElement(AppiumBy.id("digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String divideResult=driver.findElement(AppiumBy.id("result")).getText();
		System.out.println("50/2 = "+divideResult);
		
		Assert.assertEquals(divideResult, "25");	
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
