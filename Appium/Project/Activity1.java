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

public class Activity1 {
	
	AppiumDriver driver;
	WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.google.android.apps.tasks");
		options.setAppActivity(".ui.TaskListsActivity");
		options.noReset();

		// Server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverUrl, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test(priority = 1)
	public void addTask1Test() {
		// Task 1
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")));
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))
				.sendKeys("Complete Activity with Google Tasks");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("task_data")));

		String taskText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and contains(@text,'Google Tasks')]"))
				.getText();

		Assert.assertEquals(taskText, "Complete Activity with Google Tasks");
	}

	// Test function
	@Test(priority = 2, enabled = true)
	public void addTask2Test() {
		// Task 2
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create new task")));
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("task_data")));

		String taskText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and contains(@text,'with Google Keep')]"))
				.getText();

		Assert.assertEquals(taskText, "Complete Activity with Google Keep");
	}

	// Test function
	@Test(priority = 3, enabled = true)
	public void addTask3Test() {
		// Task 3
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create new task")));
		driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
		driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
		driver.findElement(AppiumBy.id("add_task_done")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("task_data")));

		String taskText = driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id='com.google.android.apps.tasks:id/task_name' and contains(@text,'second')]"))
				.getText();

		Assert.assertEquals(taskText, "Complete the second Activity Google Keep");
	}

	// Tear down function
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
