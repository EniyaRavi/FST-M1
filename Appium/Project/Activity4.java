package project;

import static activities.ActionsBase.doSwipe;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
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

public class Activity4 {
	
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
		
		URL serverURL=new URI("http://localhost:4723").toURL();
		
		driver=new AndroidDriver(serverURL, options);
		
		driver.get("https://v1.training-support.net/selenium");
		wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	
	@Test
	public void test() {
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Login\"]")));
		
		Dimension dims=driver.manage().window().getSize();
		
		Point start= new Point((int)(dims.getWidth() * .50), (int)(dims.getHeight() * .90));
		Point end= new Point((int)(dims.getWidth() * .50), (int)(dims.getHeight() * .10));
		
		doSwipe(driver, start, end, 50);
		
		ActionsBase.doSwipe(driver, start, end, 50);

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Add tasks to list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[1]")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Get number of tasks");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[2]")));

		driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
				.sendKeys("Clear the list");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View[3]")));

		List<WebElement> taskList = driver
				.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']//android.view.View"));

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Add tasks to list']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Get number of tasks']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear the list']")).click();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();

		taskList = driver
				.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']//android.view.View"));

		Boolean isPassed = false;
		if (taskList.size() == 2) {
			System.out.println("Cleared all the tasks");
			isPassed = true;
		}
		Assert.assertTrue(isPassed);		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
