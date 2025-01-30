package activities;

import static activities.ActionsBase.doSwipe;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options=new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
		
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	
	@Test
	public void volume75Test() {
		
		driver.get("https://training-support.net/webelements/sliders");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id=\"volume\"]")));
		Dimension dims=driver.manage().window().getSize();
		System.out.println(dims);
		
		Point start= new Point((int)(dims.getWidth() * .50), (int)(dims.getHeight() * .65));
		Point end= new Point((int)(dims.getWidth() * .67), (int)(dims.getHeight() * .65));
		
		doSwipe(driver, start, end, 2000);
		
//		String volumeText=driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'%')]")).getText();
//		
//		assertTrue(volumeText.contains("75%"));
	}
	
	@Test
    public void volume25Test() {
		
		driver.get("https://training-support.net/webelements/sliders");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id=\"volume\"]")));
		Dimension dims=driver.manage().window().getSize();
		System.out.println(dims);
		
		Point start= new Point((int)(dims.getWidth() * .50), (int)(dims.getHeight() * .65));
		Point end= new Point((int)(dims.getWidth() * .33), (int)(dims.getHeight() * .65));
		
		doSwipe(driver, start, end, 2000);
		
//		String volumeText=driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'%')]")).getText();
//		
//		assertTrue(volumeText.contains("25%"));
	}
	
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
