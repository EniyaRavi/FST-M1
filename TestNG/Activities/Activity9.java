package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	
	WebDriver driver;
    WebDriverWait wait;
	
	@BeforeClass 
	public void setUp() {
		driver=new FirefoxDriver();
		Reporter.log("Starting the browser... |");
		driver.get("https://training-support.net/webelements/alerts");	
		Reporter.log("Opened the browser |");
		Reporter.log("Title of the page is: "+ driver.getTitle() + " |");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestCase setup started |");
		driver.switchTo().defaultContent();
	}
	
	@Test  (priority=1)
	public void simpleAlertTestCase() {
		Reporter.log("simpleAlertTestCase() started |");
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Alert opened |");
		Alert simpleAlert=driver.switchTo().alert();
		Reporter.log("Switched focus to simple alert |");
		String simpleAlertText=simpleAlert.getText();
		Reporter.log("Alert text is "+simpleAlertText+ " |");
		Assert.assertEquals("You've just triggered a simple alert!", simpleAlertText);
		simpleAlert.accept();
		Reporter.log("Simple Alert closed");
        Reporter.log("Simple Alert Test case ended |");
	}
	
	@Test (priority=2)
	public void confirmAlertTestCase() {
		Reporter.log("confirmAlertTestCase() started |");
		driver.findElement(By.id("confirmation")).click();
		Reporter.log("Confirm Alert opened |");
		Alert confirmAlert=driver.switchTo().alert();
		Reporter.log("Switched focus to confirm alert |");
		String confirmAlertText=confirmAlert.getText();
		Reporter.log("Alert text is "+confirmAlertText+ " |");
		Assert.assertEquals("You've just triggered a confirmation alert!", confirmAlertText);
		confirmAlert.accept();
        Reporter.log("Confirmation Alert closed |");
        Reporter.log("Confirm Alert Test case ended |");
	}
	
	@Test (priority=3)
	public void promptAlertTestCase() {
		Reporter.log("promptAlertTestCase() started |");
		driver.findElement(By.id("prompt")).click();
		Reporter.log("Prompt Alert opened |");
		Alert promptAlert=driver.switchTo().alert();
		Reporter.log("Switched focus to prompt alert |");
		String promptAlertText=promptAlert.getText();
		Reporter.log("Alert text is "+promptAlertText+ " |");
		Assert.assertEquals("I'm a Prompt! Type something into me!", promptAlertText);
		promptAlert.sendKeys("Awesome");
		Reporter.log("Text entered in prompt alert |");
		promptAlert.accept();
		Reporter.log("Prompt Alert closed |");
        Reporter.log("Prompt Alert Test case ended |");
	}
	
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}

}
